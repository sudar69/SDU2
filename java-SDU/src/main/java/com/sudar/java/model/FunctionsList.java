package com.sudar.java.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlRootElement
public class FunctionsList {
	
	private static Logger log = Logger.getLogger(FunctionsList.class);
	
	private List<Function> function = new ArrayList<Function>();
	
	@XmlElement(name="function")
    public List<Function> getFunctions() {
        return function;
    }
	
	public void add(String type) {
		log.info("addRow");
		Cell cell1 = new Cell();
		cell1.setValue(0);
		
		Coll coll1 = new Coll();
		coll1.setIndex(0);
		coll1.setCell(cell1);
		
		ArrayList<Coll> aColl = new ArrayList<Coll>();
		aColl.add(coll1);
		
		Row row1 = new Row();
		row1.setIndex(0);
		row1.setColl(aColl);
		
		ArrayList<Row> aRow = new ArrayList<Row>();
		aRow.add(row1);
				
		Function f = new Function();
		f.setRow(aRow);
		f.setDescription("newFunction");
		f.setNameFirstArgument("x");
		f.setName("y");
		f.setType(type);
		getFunctions().add(f);
	}
	
}
