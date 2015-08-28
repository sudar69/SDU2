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
		
		for (int i = 0; i < getRpk().size(); i++) {
			String pname = getRpk().get(i).getPname();
			if (myGet.get(pname) != null) {
				getRpk().get(i).setCheck(true);
			} else {
				getRpk().get(i).setCheck(true);
			}
		}
		
		for (int i = 0; i < getRpgforv().size(); i++) {
			String pname = getRpgforv().get(i).getPname();
			if (myGet.get(pname) != null) {
				getRpgforv().get(i).setCheck(true);
			} else {
				getRpgforv().get(i).setCheck(true);
			}
		}
		ParamValue t = new ParamValue();
		t.setPname("x0");
		//getBeginData().indexOf(t);
		log.info("indexOf" + getBeginData().indexOf(t));
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

}
