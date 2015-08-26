package com.sudar.java.model;

import java.util.ArrayList;
import java.util.List;

public class Parameter {
	
	private String title;
	
	private List<Teta0> teta0 = new ArrayList<Teta0>();
	
	private boolean aerdinamik;
	
	private boolean findI;
	
	private boolean findIp2;
	
	private boolean findIp1p2;
	
	private boolean findIaut;
	
	private boolean findIvse;
	
	private boolean findpp;
	
	private boolean findpm;
	
	private boolean saveCalculation;
	
	private List<ChBoolean> rpk = new ArrayList<ChBoolean>();
	
	private List<ChBoolean> rpgforv = new ArrayList<ChBoolean>();
	
	private List<ParamValue> beginData = new ArrayList<ParamValue>();
	
	private List<ParamValue> valueConst = new ArrayList<ParamValue>();

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
