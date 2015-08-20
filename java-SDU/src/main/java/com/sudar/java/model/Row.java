package com.sudar.java.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Row {
	
	private double index;
	
	private List<Coll> coll  = new ArrayList<Coll>();

	public double getIndex() {
		return index;
	}

	public void setIndex(double index) {
		this.index = index;
	}

	public List<Coll> getColl() {
		return coll;
	}

	public void setColl(List<Coll> coll) {
		this.coll = coll;
	}
	
	@XmlElement(name="size")
	public int getSizeRow() {
		return coll.size();
	}

}
