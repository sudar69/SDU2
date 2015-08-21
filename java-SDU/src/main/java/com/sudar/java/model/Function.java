package com.sudar.java.model;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sudar.java.marshaller.LoadXmlToObject;

import java.util.ArrayList;

@XmlRootElement
public class Function {

	private String name;

	private String type;

	private String description;

	private String nameFirstArgument;

	private String nameSecondArgument;

	private List<Row> row = new ArrayList<Row>();

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

	@XmlElement(name = "size")
	public int getSizeRow() {
		return row.size();
	}

	public void add() {
		Cell cell1 = new Cell();
		cell1.setValue(0);

		Row row1 = new Row();
		row1.setIndex(0);

		for (int j = 0; j < getRow().get(0).getSizeRow(); j++) {
			Coll coll1 = new Coll();
			coll1.setIndex(getRow().get(0).getColl().get(j).getIndex());
			coll1.setCell(cell1);
			row1.getColl().add(coll1);
		}

		getRow().add(row1);
	}

	public void save(Map<String, String> myGet) {
		setName(myGet.get("yName").toString());
		setType(myGet.get("argumentNum").toString());
		setDescription(myGet.get("funcDesc").toString());
		setNameFirstArgument(myGet.get("x1Name").toString());
		setNameSecondArgument(myGet.get("x2Name").toString());
		for (int i = 0; i < getSizeRow(); i++) {
			Row tRow = getRow().get(i);
			tRow.setIndex(Double.parseDouble(myGet.get("x1" + (i + 1)).toString()));
			for (int j = 0; j < tRow.getSizeRow(); j++) {
				tRow.getColl().get(j).setIndex(Double.parseDouble(myGet.get("x2" + (j + 1)).toString()));
				tRow.getColl().get(j).getCell()
						.setValue(Double.parseDouble(myGet.get("y" + (i + 1) + "_" + (j + 1)).toString()));
			}
		}
		LoadXmlToObject.saveXML();
	}

}
