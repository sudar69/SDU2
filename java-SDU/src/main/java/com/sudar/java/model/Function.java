package com.sudar.java.model;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.sudar.java.marshaller.LoadXmlToObject;

import java.util.ArrayList;

@XmlRootElement
public class Function {

	private static Logger log = Logger.getLogger(Function.class);

	private String name;

	private String type;

	private String description;

	private String nameFirstArgument;

	private String nameSecondArgument;

	private List<Row> row = new ArrayList<Row>();

	private String tempValue;

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

	public void addRow() {
		log.info("addRow");

		Row row1 = new Row();
		row1.setIndex(0);

		for (int j = 0; j < getRow().get(0).getSizeRow(); j++) {
			Coll coll1 = new Coll();
			coll1.setIndex(getRow().get(0).getColl().get(j).getIndex());

			Cell cell1 = new Cell();
			cell1.setValue(0);

			coll1.setCell(cell1);
			row1.getColl().add(coll1);
		}

		getRow().add(row1);
	}

	public void addColumn() {
		log.info("addColumn");

		for (int i = 0; i < getSizeRow(); i++) {
			Row tRow = getRow().get(i);

			Cell cell1 = new Cell();
			cell1.setValue(0);

			Coll coll1 = new Coll();
			coll1.setIndex(0);
			coll1.setCell(cell1);

			tRow.getColl().add(coll1);
		}
	}

	public void deleteRows(Map<String, String> myGet) {
		log.info("deleteRows");
		for (int i = getSizeRow() - 1; i >= 0; i--) {
			if (myGet.get("checkboxX1" + (i + 1)) != null) {
				getRow().remove(i);
			}
		}
	}

	public void deleteColumns(Map<String, String> myGet) {
		log.info("deleteColumns");
		for (int i = getSizeRow() - 1; i >= 0; i--) {
			Row tRow = getRow().get(i);
			for (int j = tRow.getSizeRow() - 1; j >= 0; j--) {
				if (myGet.get("checkboxX2" + (j + 1)) != null) {
					tRow.getColl().remove(j);
				}
			}
		}
	}

	public void save(Map<String, String> myGet) {
		log.info("save");
		LoadXmlToObject.saveXML();
		setName(myGet.get("yName").toString());
		setType(myGet.get("argumentNum").toString());
		setDescription(myGet.get("funcDesc").toString());
		setNameFirstArgument(myGet.get("x1Name").toString());
		if (getType().equals("2"))
			setNameSecondArgument(myGet.get("x2Name").toString());
		for (int i = 0; i < getSizeRow(); i++) {
			Row tRow = getRow().get(i);
			tRow.setIndex(Double.parseDouble(myGet.get("x1" + (i + 1)).toString()));
			for (int j = 0; j < tRow.getSizeRow(); j++) {
				if (getType().equals("2"))
					tRow.getColl().get(j).setIndex(Double.parseDouble(myGet.get("x2" + (j + 1)).toString()));
				tRow.getColl().get(j).getCell()
						.setValue(Double.parseDouble(myGet.get("y" + (i + 1) + "_" + (j + 1)).toString()));
			}
		}
		LoadXmlToObject.saveXML();
	}

	public double eval(double x1) {

		if (x1 < getRow().get(0).getIndex())
			return getRow().get(0).getColl().get(0).getCell().getValue();

		if (x1 >= getRow().get(getSizeRow() - 1).getIndex())
			return getRow().get(getSizeRow() - 1).getColl().get(0).getCell().getValue();
		for (int i = 0; i < getSizeRow() - 1; i++) {
			if (x1 >= getRow().get(i).getIndex() && x1 < getRow().get(i + 1).getIndex()) {
				double proc = (x1 - getRow().get(i).getIndex())
						/ (getRow().get(i + 1).getIndex() - getRow().get(i).getIndex());
				return getRow().get(i).getColl().get(0).getCell().getValue()
						+ proc * (getRow().get(i + 1).getColl().get(0).getCell().getValue()
								- getRow().get(i).getColl().get(0).getCell().getValue());
			}
		}
		return -1;
	}

	public double eval(double x1, double x2) {
		int x1i = 0, x2i = 0;

		if (x1 < getRow().get(0).getIndex()) {
			x1 = getRow().get(0).getIndex();
			x1i = 0;
		} else if (x1 >= getRow().get(getSizeRow() - 1).getIndex()) {
			x1 = getRow().get(getSizeRow() - 1).getIndex();
			x1i = getSizeRow() - 2;
		} else {
			for (int i = 0; i < getSizeRow() - 1; i++) {
				if (x1 >= getRow().get(i).getIndex() && x1 < getRow().get(i + 1).getIndex()) {
					x1i = i;
					break;
				}
			}
		}

		if (x2 < getRow().get(x1i).getColl().get(0).getIndex()) {
			x2 = getRow().get(x1i).getColl().get(0).getIndex();
			x2i = 0;
		} else if (x2 >= getRow().get(x1i).getColl().get(getRow().get(x1i).getSizeRow() - 1).getIndex()) {
			x2 = getRow().get(x1i).getColl().get(getRow().get(x1i).getSizeRow() - 1).getIndex();
			x2i = getRow().get(x1i).getSizeRow() - 2;
		} else {
			for (int i = 0; i < getRow().get(x1i).getSizeRow() - 1; i++) {
				if (x2 >= getRow().get(x1i).getColl().get(i).getIndex()
						&& x2 < getRow().get(x1i).getColl().get(i + 1).getIndex()) {
					x2i = i;
					break;
				}
			}
		}

		double x1p = (x1 - getRow().get(x1i).getIndex())
				/ (getRow().get(x1i + 1).getIndex() - getRow().get(x1i).getIndex());
		double x2p = (x2 - getRow().get(x1i).getColl().get(x2i).getIndex())
				/ (getRow().get(x1i).getColl().get(x2i + 1).getIndex()
						- getRow().get(x1i).getColl().get(x2i).getIndex());
		double y1 = getRow().get(x1i).getColl().get(x2i).getCell().getValue()
				+ x1p * (getRow().get(x1i + 1).getColl().get(x2i).getCell().getValue()
						- getRow().get(x1i).getColl().get(x2i).getCell().getValue());
		double y2 = getRow().get(x1i).getColl().get(x2i + 1).getCell().getValue()
				+ x1p * (getRow().get(x1i + 1).getColl().get(x2i + 1).getCell().getValue()
						- getRow().get(x1i).getColl().get(x2i + 1).getCell().getValue());

		return x2p * (y2 - y1) + y1;

	}

	public void calculateTF(Map<String, String> myGet) {
		log.info("calculateTF");
		if (getType().equals("2") && myGet.get("x1Value") != null && myGet.get("x2Value") != null) {
			setTempValue(String.valueOf(eval(Double.parseDouble(myGet.get("x1Value").toString()),
					Double.parseDouble(myGet.get("x2Value").toString()))));
		} else if (getType().equals("1") && myGet.get("x1Value") != null) {
			setTempValue(String.valueOf(eval(Double.parseDouble(myGet.get("x1Value").toString()))));
		}
	}

	public String getTempValue() {
		return tempValue;
	}

	public void setTempValue(String tempValue) {
		this.tempValue = tempValue;
	}

}
