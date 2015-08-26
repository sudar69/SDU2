package com.sudar.java.controller;

import java.util.Map;

import org.apache.log4j.Logger;

import com.sudar.java.http.HttpResponse;
import com.sudar.java.marshaller.LoadXmlToObject;
import com.sudar.java.marshaller.MarshallerToXML;
import com.sudar.java.model.Function;
import com.sudar.java.model.FunctionsList;
import com.sudar.java.view.FunctionView;

public class FunctionController {

	private static Logger log = Logger.getLogger(HttpResponse.class);

	private String action;
	private String view;
	private String fname;
	private Map<String, String> myGets;

	public FunctionController(Map<String, String> gets) {
		if (gets != null) {
			setMyGets(gets);
			if (gets.get("action") != null)
				setAction(gets.get("action").toString());
			if (gets.get("view") != null)
				setView(gets.get("view").toString());
			if (gets.get("fname") != null)
				setFname(gets.get("fname").toString());
		}
		log.info(getAction() + " " + getView() + " " + getFname());
	}

	public String func() throws Exception {
		FunctionsList fl = LoadXmlToObject.getFl();

		if (validAction("addrow")) {
			getFirstFunction(fl).addRow();
		} else if (validAction("deleteRows")) {
			getFirstFunction(fl).deleteRows(getMyGets());
		} else if (validAction("addColumn")) {
			getFirstFunction(fl).addColumn();
		} else if (validAction("deleteColumns")) {
			getFirstFunction(fl).deleteColumns(getMyGets());
		} else if (validAction("save")) {
			getFirstFunction(fl).save(getMyGets());
		} else if (validAction("=")) {
			getFirstFunction(fl).calculateTF(getMyGets());
		} else if (getAction() != null && getAction().equals("add1")) {
			fl.add("1");
		} else if (getAction() != null && getAction().equals("add2")) {
			fl.add("2");
		}

		if (getView() == null) {
			// ob.saveXML();
			// fillResponse("");
			MarshallerToXML XML = new MarshallerToXML();
			return FunctionView.all(XML, fl);
			// fillResponse(XML.marshaller(ob.loadFunctionsList().getFunctions().get(0),
			// "functionsList.xsl"));
			// fillResponse(XML.marshaller(ob.loadFunctionsList().getFunctions().get(0),
			// "function.xsl"));
		} else if (getView() != null && getView().equals("f2") && getFname() != null) {
			for (int i = 0; i < fl.getFunctions().size(); i++) {
				if (fl.getFunctions().get(i).getDescription().equals(getFname())) {
					MarshallerToXML XML = new MarshallerToXML();
					return FunctionView.func2(XML, fl, i);
				}
			}

		} else if (getView() != null && getView().equals("f1") && getFname() != null) {
			for (int i = 0; i < fl.getFunctions().size(); i++) {
				if (fl.getFunctions().get(i).getDescription().equals(getFname())) {
					MarshallerToXML XML = new MarshallerToXML();
					return FunctionView.func1(XML, fl, i);
				}
			}

		}
		MarshallerToXML XML = new MarshallerToXML();
		return FunctionView.all(XML, fl);
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

	public Map<String, String> getMyGets() {
		return myGets;
	}

	public void setMyGets(Map<String, String> myGets) {
		this.myGets = myGets;
	}

	private boolean validAction(String s) {
		if (getAction() != null && getAction().equals(s) && getFname() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	private Function getFirstFunction(FunctionsList fl_) {
		for (int i = 0; i < fl_.getFunctions().size(); i++) {
			if (fl_.getFunctions().get(i).getDescription().equals(getFname())) {
				return fl_.getFunctions().get(i);
			}
		}
		return null;
	}
}
