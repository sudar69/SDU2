package com.sudar.java;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.apache.commons.math3.ode.sampling.StepHandler;

public class SDUThread extends Thread {

	@Override
	public void run() {
		SDU();
	}

	public void SDU() {
		ClassicalRungeKuttaIntegrator rk4 = new ClassicalRungeKuttaIntegrator(0.01);
		FirstOrderDifferentialEquations ode = new Lorenz();
		double[] y = new double[] { 10.0, -2.0, 50 }; // initial state
		StepHandler stepHandler = new WriteToFileStepHandler("lorenz.csv");
		rk4.addStepHandler(stepHandler);
		rk4.integrate(ode, // equations
				0.0, // start time
				y, // initial conditions
				100.0, // end time
				y); // result
		for (int i = 0; i < y.length; i++) {
			System.out.println(y[i]);
		}
	}

	public class Lorenz implements FirstOrderDifferentialEquations {

		double sigma = 10.0;
		double beta = 8 / 3;
		double rho = 28.0;
		double X, Y, Z;

		@Override
		public void computeDerivatives(double t, double[] y, double[] yDot)
				throws MaxCountExceededException, DimensionMismatchException {
			X = y[0];
			Y = y[1];
			Z = y[2];
			yDot[0] = sigma * (Y - X);
			yDot[1] = X * (rho - Z) - Y;
			yDot[2] = (X * Y) - (beta * Z);
		}

		@Override
		public int getDimension() {
			// TODO Auto-generated method stub
			return 3;
		}

	}

}
