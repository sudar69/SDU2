package com.sudar.java.controller;

import java.util.Map;

import org.apache.log4j.Logger;

import com.sudar.java.marshaller.LoadXmlToObject;
import com.sudar.java.marshaller.MarshallerToXML;
import com.sudar.java.model.File;
import com.sudar.java.model.FilesList;
import com.sudar.java.view.FunctionView;

public class FilesController {
	
	private static Logger log = Logger.getLogger(FunctionController.class);

	private String action;
	private String view;
	private String fname;
	private Map<String, String> myGets;
	
	public FilesController(Map<String, String> gets) {
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
	
	public String files() throws Exception {
		
		FilesList fl = LoadXmlToObject.getFilesList();

		if (getAction() != null && getAction().equals("add")) {
			fl.add();
		} else if (validAction("addTeta0")) {
			getFirstFile(fl).getParameter().addTeta0();
		} else if (validAction("save")) {
			getFirstFile(fl).save(getMyGets());
		} else if (validAction("startCalculation")) {
			getFirstFile(fl).startCalculation();
		}
		
		if (getFname() == null) {
			MarshallerToXML XML = new MarshallerToXML();
			return FunctionView.allFiles(XML, fl);
		} else if (getFname() != null) {
			for (int i = 0; i < fl.getFile().size(); i++) {
				if (fl.getFile().get(i).getParameter().getTitle().equals(getFname())) {
					MarshallerToXML XML = new MarshallerToXML();
					return FunctionView.file(XML, fl, i);
				}
			}

		}
		return "";
		
	}
	
	private boolean validAction(String s) {
		if (getAction() != null && getAction().equals(s) && getFname() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	private File getFirstFile(FilesList fl_) {
		for (int i = 0; i < fl_.getFile().size(); i++) {
			if (fl_.getFile().get(i).getParameter().getTitle().equals(getFname())) {
				return fl_.getFile().get(i);
			}
		}
		return null;
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
}
