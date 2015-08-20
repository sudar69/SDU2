package com.sudar.java.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class Function {
		
	private String name;
	
	private String type;
	
	private String description;
	
	private String nameFirstArgument;
	
	private String nameSecondArgument;
	
	private List<Row> row  = new ArrayList<Row>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNameFirstArgument() {
		return nameFirstArgument;
	}

	public void setNameFirstArgument(String nameFirstArgument) {
		this.nameFirstArgument = nameFirstArgument;
	}

	public String getNameSecondArgument() {
		return nameSecondArgument;
	}

	public void setNameSecondArgument(String nameSecondArgument) {
		this.nameSecondArgument = nameSecondArgument;
	}

	public List<Row> getRow() {
		return row;
	}

	public void setRow(List<Row> row) {
		this.row = row;
	}
	
	@XmlElement(name="size")
	public int getSizeRow() {
		return row.size();
	}

}
