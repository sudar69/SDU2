package com.sudar.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Parameter {

	private static Logger log = Logger.getLogger(Parameter.class);

	private String title;

	private List<Teta0> teta0 = new ArrayList<Teta0>();

	private boolean aerdinamik = false;

	private boolean findI = false;

	private boolean findIp2 = false;

	private boolean findIp1p2 = false;

	private boolean findIaut = false;

	private boolean findIvse = false;

	private boolean findpp = false;

	private boolean findpm = false;

	private boolean saveCalculation = false;

	private List<ChBoolean> rpk = new ArrayList<ChBoolean>();

	private List<ChBoolean> rpgforv = new ArrayList<ChBoolean>();

	private List<ParamValue> beginData = new ArrayList<ParamValue>();

	private List<ParamValue> valueConst = new ArrayList<ParamValue>();
	
	private String cxDeltaMtauFile = new String();
	
	private String cyDeltaMtauFile = new String();
	
	private String mzwzMtauFile = new String();
	
	private String mzdeltaMtauFile = new String();
	
	private String mxwxMtauFile = new String();
	
	private String mxalphaMtauFile = new String();
	
	private double maxStep1 = 0.01;
	
	private double initialStep1 = 0.01;
	
	private double relTol1 = 1e-3;
	
	private double absTol1 = 1e-6;
	
	private double maxStep2 = 0.001;
	
	private double initialStep2 = 0.001;
	
	private double relTol2 = 1e-3;
	
	private double absTol2 = 1e-6;

	public void addTeta0() {
		Teta0 t = new Teta0();
		t.setId(getTeta0().size() + 1);
		t.setCheckbox(false);
		t.setD(1000);
		t.setTeta0(1);
		getTeta0().add(t);
	}

	public void defaultRpk() {
		String[] name = { "Все", "Xp, Zp", "dXtys", "Вд, Вб, Вв", "Вд2, Вб2", "dZw", "dXw", "dXh", "dXt", "dXtz",
				"dXtzr+", "dXtzr-", "dXv0", "dXq", "dXw0", "dXvr", "dZvr", "dZwaz, dПwaz", "dPwax, dZwax", "dZwпz",
				"dXwпx" };
		String[] pname = { "allCorrections", "checkboxXpZp", "checkboxDxtys", "checkboxVd", "checkboxVd2",
				"checkboxDzw", "checkboxDxw", "checkboxDxh", "checkboxDxt", "checkboxDxtz", "checkboxDXtzrp",
				"checkboxDXtzrm", "checkboxDxv0", "checkboxDxq", "checkboxDxw0", "checkboxXvr", "checkboxZvr",
				"checkboxDzwaz", "checkboxDpwax", "checkboxDzwp", "checkboxDxwp" };
		for (int i = 0; i < name.length; i++) {
			ChBoolean ch = new ChBoolean();
			ch.setName(name[i]);
			ch.setPname(pname[i]);
			ch.setCheck(false);
			getRpk().add(ch);
		}
	}

	public void defaultRpgforv() {
		String[] name = { "Вбн, Вдн", "dXp/" + "\n" + "dr0", "dXp/" + "\n" + "dalpha", "dXp/" + "\n" + "ddoper",
				"dXp/" + "\n" + "ddsopl", "dXp/" + "\n" + "dgamma", "dZp/" + "\n" + "dx10", "dXp/" + "\n" + "dx20",
				"dZp/" + "\n" + "dalpha10", "dXp/" + "\n" + "dalpha20", "dZp/" + "\n" + "dx1k", "dXp/" + "\n" + "dx2k",
				"dZp/" + "\n" + "dalpha1k", "dXp/" + "\n" + "dalpha2k", "dXp/" + "\n" + "dtn",
				"dXp/" + "\n" + "ddelta" };
		String[] pname = { "allCorrectionsVb", "checkboxdr0", "checkboxdalpha", "checkboxddoper", "checkboxddsopl",
				"checkboxgamma", "checkboxdx10", "checkboxdx20", "checkboxdalpha10", "checkboxdalpha20", "checkboxdx1k",
				"checkboxdx2k", "checkboxdalpha1k", "checkboxdalpha2k", "checkboxdtn", "checkboxddelta" };
		for (int i = 0; i < name.length; i++) {
			ChBoolean ch = new ChBoolean();
			ch.setName(name[i]);
			ch.setPname(pname[i]);
			ch.setCheck(false);
			getRpgforv().add(ch);
		}
	}

	public void defaultValueConst() {
		String[][] t = { { "eta", "eta", "25", "0" }, { "eta1", "eta1", "1", "0" }, { "dTz, град", "dTz", "10", "0" },
				{ "dTзр+", "dTzrp", "10", "0" }, { "dTзр-", "dTzrm", "-10", "0" }, { "w0", "w0", "0", "0" },
				{ "tн, с", "tn", "1000", "0" }, { "tauaN, с", "tauaN", "1", "0" }, { "g, м/с2", "g", "9.81", "0" },
				{ "qn, кг", "qn", "46", "0" }, { "qпут2, кг", "qput2", "0", "0" }, { "k1", "k1", "0", "0" },
				{ "k2", "k2", "0", "0" }, { "I1N", "I1N", "0", "0" }, { "dtau, град", "dtau", "10", "0" },
				{ "tauoN, К", "tauoN", "288.9", "0" }, { "rooN", "rooN", "0.123", "0" },
				{ "PoN, мм.рт.ст", "PoN", "750", "0" }, { "dP, мм.рт.ст", "dP", "10", "0" },
				{ "dVo, %V0", "dV0", "1", "0" }, { "dq, 1в/зн", "dq", "1", "0" }, { "dw, кг", "dw", "0", "0" },
				{ "lтз", "ltz", "0.000792", "0" }, { "lq", "lq", "0.165", "0" }, { "lwzr", "lwzr", "1.03", "0" },
				{ "LB, м", "LB", "0.7", "0" }, { "Wx, м/с", "Wx", "10", "0" }, { "Wz, м/с", "Wz", "10", "0" },
				{ "Wax, м/с", "Wax", "10", "0" }, { "Waz, м/с", "Waz", "10", "0" }, { "Wpx, м/с", "Wpx", "10", "0" },
				{ "Wpz, м/с", "Wpz", "10", "0" }, { "d, м", "d", "0.152", "0" }, { "doper", "doper", "0.152", "0" },
				{ "dsopl", "dsopl", "0.152", "0" }, { "A", "A", "0.1563", "0" }, { "C", "C", "0.008", "0" },
				{ "R, м/град", "R", "29.27", "0" }, { "dteta, рад", "dteta", "0.001042", "0" },
				{ "r teta0, тыс", "rteta0", "0.25", "0" }, { "rv0, %v0", "rv0", "0.15", "0" },
				{ "rc, %", "rc", "0.4", "0" }, { "rw", "rw", "0.25", "0" }, { "rz, рад", "rz", "0.0007", "0" },
				{ "delta, рад", "delta_", "0", "0" }, { "alpha", "alpha", "0", "0" },
				{ "gamma, рад", "gamma", "0", "0" }, { "gamma_aer, рад", "gamma_aer", "0", "0" },
				{ "gamma_w", "gamma_w", "0", "0" }, { "gamma_m", "gamma_m", "0", "0" }, { "rx, м", "rx_", "0", "0" },
				{ "ry, м", "ry_", "0", "0" }, { "rz, м", "rz_", "0", "0" }, { "Bspin", "Bspin", "0.890118", "0" },
				{ "ar", "ar", "0.261798", "0" }, { "omega_з", "omegaz", "7.292e-5", "0" },
				{ "Rз", "Rz", "6371000", "0" }, { "kb", "kb", "1", "0" }, { "sBr", "sBr", "-1", "0" },
				{ "K5", "K5", "0", "0" }, { "K2", "K2", "0", "0" }, { "K3", "K3", "1", "0" }, { "K4", "K4", "1", "0" },
				{ "K10", "K10", "1", "0" }, { "K6", "K6", "1", "0" }, { "dtetak, рад", "dtetak", "0", "0" },
				{ "dvk, м/с", "dvk", "0", "0" }, { "dyk, м/с", "dyk", "0", "0" },
				{ "r tetak, тыс", "rtetak", "0", "0" }, { "rvk, %v0", "rvk", "0", "0" },
				{ "r psik, тыс", "rpsik", "0", "0" }, { "dgammas, рад", "dgammas", "0", "0" },
				{ "ddsopl, м", "ddsopl", "0", "0" }, { "ddoper, м", "ddoper", "0", "0" },
				{ "dalpha, рад", "dalpha", "0", "0" }, { "ddelta, рад", "ddelta_", "0", "0" },
				{ "dx10, рад", "dx10", "0.1", "0" }, { "dx20, рад", "dx20", "0.1", "0" },
				{ "dalpha10, рад/с", "dalpha10", "1.5", "0" }, { "dalpha20, рад/с", "dalpha20", "1.5", "0" },
				{ "dx1k, рад", "dx1k", "0", "0" }, { "dx2k, рад", "dx2k", "0", "0" },
				{ "dalpha1k, рад/с", "dalpha1k", "0", "0" }, { "dalpha2k, рад/с", "dalpha2k", "0", "0" },
				{ "dtн, с", "dtn", "0", "0" }, { "dr0, рад/с", "dr0", "20", "0" },
				{ "rx10, рад", "rx10", "0.015", "0" }, { "rx20, рад", "rx20", "0.01748", "0" },
				{ "ralpha10, рад/с", "ralpha10", "0.05", "0" }, { "ralpha20, рад/с", "ralpha20", "0.087", "0" },
				{ "rx1k, рад", "rx1k", "0", "0" }, { "rx2k, рад", "rx2k", "0", "0" },
				{ "ralpha1k, рад/с", "ralpha1k", "0", "0" }, { "ralpha2k, рад/с", "ralpha2k", "0", "0" },
				{ "rgammas, рад", "rgammas", "0", "0" }, { "rdelta, м", "rdelta", "0", "0" },
				{ "ralpha, рад", "ralpha", "0", "0" }, { "rdoper, м", "rdoper", "0", "0" },
				{ "rdsopl, м", "rdsopl", "0", "0" }, { "rr0, рад/с", "rr0", "0.01", "0" },
				{ "rtн, с", "rtn", "0", "0" } };
		for (int i = 0; i < t.length; i++) {

			ParamValue pv = new ParamValue();
			pv.setName(t[i][0]);
			pv.setPname(t[i][1]);
			pv.setValue(Double.parseDouble(t[i][2]));
			if (t[i][3].equals("1")) {
				pv.setReadonly(true);
			} else {
				pv.setReadonly(false);
			}

			getValueConst().add(pv);
		}
	}

	public void defaultBeginData() {
		String[][] t = { { "X0, м", "x0", "0", "1" }, { "Y0, м", "y0", "0", "1" }, { "Z0, м", "z0", "0", "1" },
				{ "V0, м/с", "v0", "1", "0" }, { "psi10, рад", "psi10", "0", "1" },
				{ "psi20=teta0, рад", "psi20", "-1", "1" }, { "x10, рад", "x10", "0", "0" },
				{ "x20, рад", "x20", "0", "0" }, { "alpha10, рад/с", "alpha10", "0", "0" },
				{ "alpha20, рад/с", "alpha20", "0", "0" }, { "r0, рад/с", "r0", "-2", "1" },
				{ "Pi0", "Pi0", "1", "1" } };
		for (int i = 0; i < t.length; i++) {

			ParamValue pv = new ParamValue();
			pv.setName(t[i][0]);
			pv.setPname(t[i][1]);
			pv.setValue(Double.parseDouble(t[i][2]));
			if (t[i][3].equals("1")) {
				pv.setReadonly(true);
			} else {
				pv.setReadonly(false);
			}

			getBeginData().add(pv);
		}
	}

	public void save(Map<String, String> myGet) {
		log.info("save");
		// setTitle(myGet.get("title").toString());
		for (int i = 0; i < getTeta0().size(); i++) {
			Teta0 t = getTeta0().get(i);
			if (myGet.get("checkboxTeta" + i) != null) {
				t.setCheckbox(true);
			} else {
				t.setCheckbox(false);
			}
			t.setD(Double.parseDouble(myGet.get("D" + (i + 1)).toString()));
			t.setTeta0(Double.parseDouble(myGet.get("teta0" + (i + 1)).toString()));
			t.setIput(Double.parseDouble(myGet.get("i" + (i + 1)).toString()));
			t.setIaut(Double.parseDouble(myGet.get("iaut" + (i + 1)).toString()));
			t.setIput2(Double.parseDouble(myGet.get("iput2" + (i + 1)).toString()));
			t.setDxtzrpts(Double.parseDouble(myGet.get("dxtzrpts" + (i + 1)).toString()));
			t.setPp(Double.parseDouble(myGet.get("pp" + (i + 1)).toString()));
			t.setDxtzrmts(Double.parseDouble(myGet.get("dxtzrmts" + (i + 1)).toString()));
			t.setPm(Double.parseDouble(myGet.get("pm" + (i + 1)).toString()));

		}

		if (myGet.get("aerdinamik") != null) {
			setAerdinamik(true);
		} else {
			setAerdinamik(false);
		}

		if (myGet.get("findI") != null) {
			setFindI(true);
		} else {
			setFindI(false);
		}

		if (myGet.get("findIp2") != null) {
			setFindIp2(true);
		} else {
			setFindIp2(false);
		}

		if (myGet.get("findIp1p2") != null) {
			setFindIp1p2(true);
		} else {
			setFindIp1p2(false);
		}

		if (myGet.get("findIaut") != null) {
			setFindIaut(true);
		} else {
			setFindIaut(false);
		}

		if (myGet.get("findIvse") != null) {
			setFindIvse(true);
		} else {
			setFindIvse(false);
		}

		if (myGet.get("findpp") != null) {
			setFindpp(true);
		} else {
			setFindpp(false);
		}

		if (myGet.get("findpm") != null) {
			setFindpm(true);
		} else {
			setFindpm(false);
		}

		if (myGet.get("saveCalculation") != null) {
			setSaveCalculation(true);
		} else {
			setSaveCalculation(false);
		}

		if (myGet.get("docTitle") != null) {
			setTitle(myGet.get("docTitle").toString());
		}

		for (int i = 0; i < getRpk().size(); i++) {
			String pname = getRpk().get(i).getPname();
			if (myGet.get(pname) != null) {
				getRpk().get(i).setCheck(true);
			} else {
				getRpk().get(i).setCheck(false);
			}
		}

		for (int i = 0; i < getRpgforv().size(); i++) {
			String pname = getRpgforv().get(i).getPname();
			if (myGet.get(pname) != null) {
				getRpgforv().get(i).setCheck(true);
			} else {
				getRpgforv().get(i).setCheck(false);
			}
		}

		for (int i = 0; i < getBeginData().size(); i++) {
			String pname = getBeginData().get(i).getPname();
			if (!getBeginData().get(i).isReadonly()) {
				if (myGet.get(pname) != null) {
					getBeginData().get(i).setValue(Double.parseDouble(myGet.get(pname).toString()));
				}
			}
		}

		for (int i = 0; i < getValueConst().size(); i++) {
			String pname = getValueConst().get(i).getPname();
			if (myGet.get(pname) != null) {
				getValueConst().get(i).setValue(Double.parseDouble(myGet.get(pname).toString()));
			}
		}
		
		if (myGet.get("cxDeltaMtauFile") != null) {
			setCxDeltaMtauFile(myGet.get("cxDeltaMtauFile").toString());
		}
		
		if (myGet.get("cyDeltaMtauFile") != null) {
			setCyDeltaMtauFile(myGet.get("cyDeltaMtauFile").toString());
		}
		
		if (myGet.get("mzwzMtauFile") != null) {
			setMzwzMtauFile(myGet.get("mzwzMtauFile").toString());
		}
		
		if (myGet.get("mzdeltaMtauFile") != null) {
			setMzdeltaMtauFile(myGet.get("mzdeltaMtauFile").toString());
		}
		
		if (myGet.get("mxwxMtauFile") != null) {
			setMxwxMtauFile(myGet.get("mxwxMtauFile").toString());
		}
		
		if (myGet.get("mxalphaMtauFile") != null) {
			setMxalphaMtauFile(myGet.get("mxalphaMtauFile").toString());
		}
		
		if (myGet.get("maxStep1") != null) {
			setMaxStep1(Double.parseDouble(myGet.get("maxStep1").toString()));
		}
		
		if (myGet.get("initialStep1") != null) {
			setInitialStep1(Double.parseDouble(myGet.get("initialStep1").toString()));
		}
		
		if (myGet.get("relTol1") != null) {
			setRelTol1(Double.parseDouble(myGet.get("relTol1").toString()));
		}
		
		if (myGet.get("absTol1") != null) {
			setAbsTol1(Double.parseDouble(myGet.get("absTol1").toString()));
		}
		
		if (myGet.get("maxStep2") != null) {
			setMaxStep2(Double.parseDouble(myGet.get("maxStep2").toString()));
		}
		
		if (myGet.get("initialStep2") != null) {
			setInitialStep2(Double.parseDouble(myGet.get("initialStep2").toString()));
		}
		
		if (myGet.get("relTol2") != null) {
			setRelTol2(Double.parseDouble(myGet.get("relTol2").toString()));
		}
		
		if (myGet.get("absTol2") != null) {
			setAbsTol2(Double.parseDouble(myGet.get("absTol2").toString()));
		}

	}

	public List<Teta0> getTeta0() {
		return teta0;
	}

	public void setTeta0(List<Teta0> teta0) {
		this.teta0 = teta0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAerdinamik() {
		return aerdinamik;
	}

	public void setAerdinamik(boolean aerdinamik) {
		this.aerdinamik = aerdinamik;
	}

	public boolean isFindI() {
		return findI;
	}

	public void setFindI(boolean findI) {
		this.findI = findI;
	}

	public boolean isFindIp2() {
		return findIp2;
	}

	public void setFindIp2(boolean findIp2) {
		this.findIp2 = findIp2;
	}

	public boolean isFindIp1p2() {
		return findIp1p2;
	}

	public void setFindIp1p2(boolean findIp1p2) {
		this.findIp1p2 = findIp1p2;
	}

	public boolean isFindIaut() {
		return findIaut;
	}

	public void setFindIaut(boolean findIaut) {
		this.findIaut = findIaut;
	}

	public boolean isFindIvse() {
		return findIvse;
	}

	public void setFindIvse(boolean findIvse) {
		this.findIvse = findIvse;
	}

	public boolean isFindpp() {
		return findpp;
	}

	public void setFindpp(boolean findpp) {
		this.findpp = findpp;
	}

	public boolean isFindpm() {
		return findpm;
	}

	public void setFindpm(boolean findpm) {
		this.findpm = findpm;
	}

	public boolean isSaveCalculation() {
		return saveCalculation;
	}

	public void setSaveCalculation(boolean saveCalculation) {
		this.saveCalculation = saveCalculation;
	}

	public List<ChBoolean> getRpk() {
		return rpk;
	}

	public void setRpk(List<ChBoolean> rpk) {
		this.rpk = rpk;
	}

	public List<ChBoolean> getRpgforv() {
		return rpgforv;
	}

	public void setRpgforv(List<ChBoolean> rpgforv) {
		this.rpgforv = rpgforv;
	}

	public List<ParamValue> getBeginData() {
		return beginData;
	}

	public void setBeginData(List<ParamValue> beginData) {
		this.beginData = beginData;
	}

	public List<ParamValue> getValueConst() {
		return valueConst;
	}

	public void setValueConst(List<ParamValue> valueConst) {
		this.valueConst = valueConst;
	}

	public String getCxDeltaMtauFile() {
		return cxDeltaMtauFile;
	}

	public void setCxDeltaMtauFile(String cx_delta_Mtau_file) {
		this.cxDeltaMtauFile = cx_delta_Mtau_file;
	}

	public String getCyDeltaMtauFile() {
		return cyDeltaMtauFile;
	}

	public void setCyDeltaMtauFile(String cydelta_Mtau_file) {
		this.cyDeltaMtauFile = cydelta_Mtau_file;
	}

	public String getMzwzMtauFile() {
		return mzwzMtauFile;
	}

	public void setMzwzMtauFile(String mzwz_Mtau_file) {
		this.mzwzMtauFile = mzwz_Mtau_file;
	}

	public String getMzdeltaMtauFile() {
		return mzdeltaMtauFile;
	}

	public void setMzdeltaMtauFile(String mzdelta_Mtau_file) {
		this.mzdeltaMtauFile = mzdelta_Mtau_file;
	}

	public String getMxwxMtauFile() {
		return mxwxMtauFile;
	}

	public void setMxwxMtauFile(String mxwx_Mtau_file) {
		this.mxwxMtauFile = mxwx_Mtau_file;
	}

	public String getMxalphaMtauFile() {
		return mxalphaMtauFile;
	}

	public void setMxalphaMtauFile(String mxalpha_Mtau_file) {
		this.mxalphaMtauFile = mxalpha_Mtau_file;
	}

	public double getMaxStep1() {
		return maxStep1;
	}

	public void setMaxStep1(double maxStep1) {
		this.maxStep1 = maxStep1;
	}

	public double getInitialStep1() {
		return initialStep1;
	}

	public void setInitialStep1(double initialStep1) {
		this.initialStep1 = initialStep1;
	}

	public double getRelTol1() {
		return relTol1;
	}

	public void setRelTol1(double relTol1) {
		this.relTol1 = relTol1;
	}

	public double getAbsTol1() {
		return absTol1;
	}

	public void setAbsTol1(double absTol1) {
		this.absTol1 = absTol1;
	}

	public double getMaxStep2() {
		return maxStep2;
	}

	public void setMaxStep2(double maxStep2) {
		this.maxStep2 = maxStep2;
	}

	public double getInitialStep2() {
		return initialStep2;
	}

	public void setInitialStep2(double initialStep2) {
		this.initialStep2 = initialStep2;
	}

	public double getRelTol2() {
		return relTol2;
	}

	public void setRelTol2(double relTol2) {
		this.relTol2 = relTol2;
	}

	public double getAbsTol2() {
		return absTol2;
	}

	public void setAbsTol2(double absTol2) {
		this.absTol2 = absTol2;
	}

}
