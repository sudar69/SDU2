package com.sudar.java;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.log4j.Logger;

import com.sudar.java.marshaller.LoadXmlToObject;
import com.sudar.java.model.Function;
import com.sudar.java.model.FunctionsList;
import com.sudar.java.model.Parameter;

public class SDUThread_ extends Thread {

	private static Logger log = Logger.getLogger(SDUThread_.class);

	private FileStream fs = new FileStream();

	SDUThread_(FileStream fs) {
		this.setFs(fs);
	}

	@Override
	public void run() {
		SDU();
	}

	public void SDU() {
		ClassicalRungeKuttaIntegrator rk4 = new ClassicalRungeKuttaIntegrator(0.01);
		FirstOrderDifferentialEquations ode = new Lorenz(getFs());
		double[] y = new double[] { 0, 0, 0, 650, 0, 0, 0, 0, 0, 0, 1, 1 }; // initial
																			// state
		StepHandler stepHandler = new WriteToFileStepHandler("lorenz.csv");
		rk4.addStepHandler(stepHandler);
		rk4.integrate(ode, // equations
				0.0, // start time
				y, // initial conditions
				1.0, // end time
				y); // result
		for (int i = 0; i < y.length; i++) {
			System.out.println(y[i]);
		}
	}

	public FileStream getFs() {
		return fs;
	}

	public void setFs(FileStream fs) {
		this.fs = fs;
	}

	public class Lorenz implements FirstOrderDifferentialEquations {

		double teta0, q0, g, K5, Rz, kb, tn, Wp1x, Wp1z, tauaN, w0, k2, dTzr, I1, k1, Wp2x, Wp2z, dtau, tauoN, rooN, d,
				ip1, ia, ip2, gamma_aer, gamma_, dsopl, C, LB, sBr, A, alpha, doper, omegaz, Bspin, ar, delta_, K2, K3,
				K4, R_;

		Function fnCx, fnCydelta, fnmzwz, fnmzdelta, fnmxwx, fnmxalpha;

		double X, Y, Z, V, PSI1, PSI2, X1, X2, ALPHA1, ALPHA2, R, PI;

		Lorenz(FileStream fs) {
			setConstants(fs);
		}

		@Override
		public void computeDerivatives(double t, double[] y, double[] yDot)
				throws MaxCountExceededException, DimensionMismatchException {

			X = y[0];
			Y = y[1];
			Z = y[2];
			V = y[3];
			PSI1 = y[4];
			PSI2 = y[5];
			X1 = y[6];
			X2 = y[7];
			ALPHA1 = y[8];
			ALPHA2 = y[9];
			R = y[10];
			PI = y[11];

			/*
			 * log.info("teta0=" + teta0 + " X=" + X + " Y=" + Y + " Z=" + Z +
			 * " V=" + V + " PSI1=" + PSI1 + " PSI2=" + PSI2 + " X1=" + X1 +
			 * " X2=" + X2 + " ALPHA1=" + ALPHA1 + " ALPHA2=" + ALPHA2 + " R=" +
			 * R + " PI=" + PI);
			 */

			double m0 = q0 / g;
			double teta = Math.asin(Math.cos(PSI1) * Math.sin(Math.toRadians(teta0) + PSI2));
			if (K5 < 0.5) {
				yDot[0] = V * Math.cos(teta);
			} else {
				yDot[0] = V * Math.cos(teta) / (1 - 2 * Y / Rz) / kb;
			}

			double x_ = yDot[0];

			yDot[1] = V * Math.sin(teta);

			double y_ = yDot[1];

			if (K5 < 0.5) {
				yDot[2] = V * Math.sin(PSI1);
			} else {
				yDot[2] = -V * Math.sin(PSI1) / (1 - Y / Rz) / kb;
			}
			double z_ = yDot[2];

			double muy = 0;
			double ap = 0;
			double Wx = 0, Wz = 0;
			if (t < tn) {
				muy = 0;
				ap = 0;
				Wx = Wp1x;
				Wz = Wp1z;
			} else if (t >= tn && t < tn + tauaN) {
				muy = w0 * (t - tn) / (m0 * g * (tauaN - k2 * dTzr));
				ap = w0 * (I1 + k1 * dTzr) / (m0 * (1 - muy) * (tauaN - k2 * dTzr));
				Wx = 0;// Wax;
				Wz = 0;// Waz;
			} else if (t >= tn + tauaN) {
				muy = w0 / (m0 * g);
				ap = 0;
				Wx = Wp2x;
				Wz = Wp2z;
			}

			double tauy = fntau(Y) + dtau;
			double atau = 20 * Math.sqrt(tauy);
			double H = PI * tauoN / tauy;
			// log.info(PI +" "+ tauoN +" "+ tauy);
			double ro = rooN * H;
			// log.info(ro +" "+ rooN +" "+ H);
			double delta1 = X1 - PSI1;
			double delta2 = X2 - PSI2;
			double teta2r = Math.atan(y_ / (x_ - Wx));
			double gamma1 = Math.atan(-Wz / V);
			double delta1r = delta1 - gamma1;
			double gamma2 = teta2r - teta;
			double delta2r = delta2 - gamma2;
			double vr = V * Math.sqrt(1 - 2 * (V * Math.cos(teta) * Wx + V * Math.sin(PSI1) * Wz) / (V * V)
					+ (Wx * Wx + Wz * Wz) / (V * V));
			double vrtau = vr * Math.sqrt(tauoN / tauy);
			double Mtau = vr / atau;
			double delta = Math.sqrt(delta1 * delta1 + delta2 * delta2);
			double Cx = fnCx.eval(Math.abs(X2), Mtau);
			double Cydelta = fnCydelta.eval(Mtau);
			double mzwz = fnmzwz.eval(Mtau);
			double mzdelta = fnmzdelta.eval(Mtau);
			double mxwx = fnmxwx.eval(Mtau);
			double mxalpha = fnmxalpha.eval(Mtau);
			// log.info(Cx +" "+ Cydelta +" "+ mzwz +" "+ mzdelta +" "+ mxwx +"
			// "+ mxalpha);
			double Sm = Math.PI * d * d / 4.0;
			double aN = ro * Sm * Cydelta / (2 * m0 * (1 - muy));
			double aR = 0;
			if (t < tn) {
				aR = ip1 * Cx * ro * vr * vr * Sm / (2 * m0 * (1 - muy));
			} else if (t >= tn && t < tn + tauaN) {
				aR = ia * Cx * ro * vr * vr * Sm / (2 * m0 * (1 - muy));
			} else if (t >= tn + tauaN) {
				aR = ip2 * Cx * ro * vr * vr * Sm / (2 * m0 * (1 - muy));
			}
			// log.info(Cx +" "+ ro +" "+ vr +" "+ Sm +" "+ m0 +" "+ muy);
			double P2 = I1 * w0 / tauaN * Math.sin(gamma_aer);
			double bp = P2 * Math.sin(gamma_) * dsopl / (2 * C);
			double LM = LB;
			double bR = sBr * ro * Sm * LM * mzdelta / (2 * A);
			double bD = ro * Sm * LM * LM * mzwz / A;
			double omega = C * R / A;
			double bA = ro * Sm * alpha * doper * mxalpha / 2;
			double bG = ro * Sm * doper * doper * mxwx / 2;

			yDot[3] = ap * Math.cos(delta2) - aR * Math.cos(gamma2) - g * Math.sin(teta) * (1 - 2 * Y / Rz)
					- aN * vr * vr * delta2r * Math.sin(gamma2);

			/*
			 * log.info(ap +" "+ delta2 +" "+ aR +" "+ gamma2 +" "+ g +" "+ teta
			 * +" "+ Y +" "+ Rz +" "+ aN +" "+ vr +" " + delta2r);
			 */

			if (K5 < 0.5) {
				yDot[4] = ap * Math.sin(delta1) / V + aN * V * delta1r * Math.cos(gamma1) - aR * Math.sin(gamma1) / V;
				yDot[5] = ap * Math.sin(delta2) / V + aN * vr * vr * delta2r * Math.cos(gamma2) / V
						- aR * Math.sin(gamma2) / V - g * Math.cos(teta) / V;
			} else {
				yDot[4] = ap * Math.sin(delta1) / V + aN * V * delta1r * Math.cos(gamma1) - aR * Math.sin(gamma1) / V
						+ 1.5 * omegaz * (Math.sin(Bspin) + Math.cos(Bspin) * Math.tan(teta) * Math.cos(ar)) * kb;
				yDot[5] = ap * Math.sin(delta2) / V + aN * vr * vr * delta2r * Math.cos(gamma2) / V
						- aR * Math.sin(gamma2) / V - g * Math.cos(teta) / V
						+ (0.2 * vr * Math.cos(teta) / (Rz + Y) + 1 * omegaz * Math.cos(Bspin) * Math.sin(ar)) * kb;
			}
			yDot[6] = ALPHA1;
			yDot[7] = ALPHA2;
			yDot[8] = bR * V * V * delta1r - bD * V * ALPHA1 + omega * ALPHA2 - P2 * delta_ / A * Math.sin(R);
			yDot[9] = bR * vr * vr * delta2r - bD * vr * ALPHA2 - omega * ALPHA1 + P2 * delta_ / A * Math.cos(R);
			yDot[10] = K2 * bp + K3 * bA * vr * vr - K4 * bG * vr * R;
			yDot[11] = -PI * V * Math.sin(teta) / (R_ * tauy);

			/*
			 * log.info("teta0=" + teta0 + " X=" + yDot[0] + " Y=" + yDot[1] +
			 * " Z=" + yDot[2] + " V=" + yDot[3] + " PSI1=" + yDot[4] + " PSI2="
			 * + yDot[5] + " X1=" + yDot[6] + " X2=" + yDot[7] + " ALPHA1=" +
			 * yDot[8] + " ALPHA2=" + yDot[9] + " R=" + yDot[10] + " PI=" +
			 * yDot[11]);
			 */
			log.info(muy + " " + ap + " " + tauy + " " + atau + " " + H + " " + ro + " " + delta1 + " " + delta2 + " "
					+ teta2r + " " + gamma1 + " " + delta1r + " " + gamma2 + " " + delta2r /*+ " " + vr + " " + vrtau
					+ " " + Mtau + " " + delta + " " + Cx + " " + Cydelta + " " + mzwz + " " + mzdelta + " " + mxwx
					+ " " + mxalpha + " " + Sm + " " + aN + " " + aR + " " + P2 + " " + bp + " " + LM + " " + bR + " "
					+ bD + " " + omega + " " + bA + " " + bG*/);
		}

		@Override
		public int getDimension() {
			// TODO Auto-generated method stub
			return 12;
		}

		double fntau(double y) {
			if (y <= 9300)
				return 288.9 - 6.328e-3 * y;
			if (y <= 12000)
				return 230.05 - 6.328e-3 * (y - 9300) + 1.172e-6 * Math.pow(y - 9300, 2);
			return 221.51;
		}

		public void setConstants(FileStream fs) {
			/*
			 * Mtauar = ""; Cxar = ""; Cydeltaar = ""; mzwzar = ""; mzdeltaar =
			 * ""; mxwxar = ""; mxalphaar = ""; Yrd = 0.0; dZwpCalculated =
			 * false; dPwpCalculated = false; _dpsi_ = _dteta_ = 0.0; kSaved =
			 * false; tetak = 0.0; tk = 0.0; vk = 0.0;
			 * dyk=_dy_=dvk=_dalpha2k_=dalpha2k=dx2k=dx1k=_dx1k_=dalpha1k=
			 * _dalpha1k_=_dx2k_=_dv_=dtetak=0.0;
			 */
			ip1 = fs.getParameter().getTeta0().get(fs.getTetaNumber()).getIput();
			ia = fs.getParameter().getTeta0().get(fs.getTetaNumber()).getIaut();
			ip2 = fs.getParameter().getTeta0().get(fs.getTetaNumber()).getIput2();
			gamma_ = findValue(fs, "gamma");
			gamma_aer = findValue(fs, "gamma_aer");
			// gammaw = findValue(fs, "gamma_w")));
			// gammam = findValue(fs, "gamma_m")));
			teta0 = fs.getParameter().getTeta0().get(fs.getTetaNumber()).getTeta0();
			dTzr = 0;
			w0 = findValue(fs, "w0");
			tn = findValue(fs, "tn");
			delta_ = findValue(fs, "delta_");
			tauaN = findValue(fs, "tauaN");
			g = findValue(fs, "g");
			q0 = findValue(fs, "qn");
			k1 = 0;
			k2 = 0;
			// pp = findValue(fs, "pp" + IntToStr(row))));
			// pm = findValue(fs, "pm" + IntToStr(row))));
			I1 = findValue(fs, "I1N");
			dtau = 0;
			tauoN = findValue(fs, "tauoN");
			rooN = findValue(fs, "rooN");
			LB = findValue(fs, "LB");
			Wp1x = 0;
			Wp1z = 0;
			// Wax = 0;
			// Waz = 0;
			Wp2x = 0;
			Wp2z = 0;
			d = findValue(fs, "d");
			dsopl = findValue(fs, "dsopl");
			doper = findValue(fs, "doper");
			alpha = findValue(fs, "alpha");
			A = findValue(fs, "A");
			C = findValue(fs, "C");
			R = findValue(fs, "R");
			Bspin = findValue(fs, "Bspin");
			ar = findValue(fs, "ar");
			omegaz = findValue(fs, "omegaz");
			Rz = findValue(fs, "Rz");
			kb = findValue(fs, "kb");
			sBr = findValue(fs, "sBr");

			// управляющие константы
			K2 = findValue(fs, "K2");
			K3 = findValue(fs, "K3");
			K4 = findValue(fs, "K4");
			K5 = findValue(fs, "K5");
			// K10=StrToInt(point2comma(parameters.get("K10")));
			// K6=StrToInt(point2comma(parameters.get("K6")));

			FunctionsList fl = LoadXmlToObject.getFl();
			for (int i = 0; i < fl.getFunctions().size(); i++) {
				if (fl.getFunctions().get(i).getDescription().equals(fs.getParameter().getCxDeltaMtauFile())) {
					fnCx = fl.getFunctions().get(i);
				}
				if (fl.getFunctions().get(i).getDescription().equals(fs.getParameter().getCyDeltaMtauFile())) {
					fnCydelta = fl.getFunctions().get(i);
				}
				if (fl.getFunctions().get(i).getDescription().equals(fs.getParameter().getMzwzMtauFile())) {
					fnmzwz = fl.getFunctions().get(i);
				}
				if (fl.getFunctions().get(i).getDescription().equals(fs.getParameter().getMzdeltaMtauFile())) {
					fnmzdelta = fl.getFunctions().get(i);
				}
				if (fl.getFunctions().get(i).getDescription().equals(fs.getParameter().getMxwxMtauFile())) {
					fnmxwx = fl.getFunctions().get(i);
				}
				if (fl.getFunctions().get(i).getDescription().equals(fs.getParameter().getMxalphaMtauFile())) {
					fnmxalpha = fl.getFunctions().get(i);
				}
			}
		}

		private double findValue(FileStream fs, String s) {
			for (int i = 0; i < fs.getParameter().getValueConst().size(); i++) {
				if (fs.getParameter().getValueConst().get(i).getPname().equals(s)) {
					return fs.getParameter().getValueConst().get(i).getValue();
				}
			}
			return 0;
		}

	}

}
