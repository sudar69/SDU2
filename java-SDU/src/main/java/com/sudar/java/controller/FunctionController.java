package com.sudar.java.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sudar.java.http.HttpResponse;
import com.sudar.java.marshaller.LoadXmlToObject;
import com.sudar.java.marshaller.MarshallerToXML;
import com.sudar.java.model.Cell;
import com.sudar.java.model.Coll;
import com.sudar.java.model.FunctionsList;
import com.sudar.java.model.Row;
import com.sudar.java.view.FunctionView;

public class FunctionController {
	
	private static Logger log = Logger.getLogger(HttpResponse.class);
	
	private String action;
	private String view;
	private String fname;
	
	public FunctionController(Map gets) {
		if (gets != null) {
			if (gets.get("action") != null) setAction(gets.get("action").toString());
			if (gets.get("view") != null) setView(gets.get("view").toString());
			if (gets.get("fname") != null) setFname(gets.get("fname").toString());
		}
		log.info(getAction() + " " + getView() + " " + getFname());
	}
	
	public String func() throws Exception {
		LoadXmlToObject ob = new LoadXmlToObject();	
		FunctionsList fl = ob.loadFunctionsList();
		
		if (getAction() != null && getAction().equals("addrow") && getFname() != null) {
			for (int i = 0; i < fl.getFunctions().size();i++) {
				if (fl.getFunctions().get(i).getDescription().equals(getFname())) {
					List<Row> row = fl.getFunctions().get(i).getRow();
										
					Cell cell1 = new Cell();
					cell1.setValue(0);					
					Coll coll1 = new Coll();
					coll1.setIndex(0);
					coll1.setCell(cell1);
					Row row1 = new Row();
					row1.setIndex(0);
					row1.getColl().add(coll1);
					
					row.add(row1);

				}
			}
		}
		
		if (getView() == null) {			
			//ob.saveXML();
			//fillResponse("");
			MarshallerToXML XML = new MarshallerToXML();
			return FunctionView.all(XML, fl);
			//fillResponse(XML.marshaller(ob.loadFunctionsList().getFunctions().get(0), "functionsList.xsl"));
			//fillResponse(XML.marshaller(ob.loadFunctionsList().getFunctions().get(0), "function.xsl"));
		} else if (getView() != null && getView().equals("f2") && getFname() != null) {
			for (int i = 0; i < fl.getFunctions().size();i++) {
				if (fl.getFunctions().get(i).getDescription().equals(getFname())) {
					MarshallerToXML XML = new MarshallerToXML();
					return FunctionView.func2(XML, fl, i);
				}
			}
			
		}
		return "";
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
}
