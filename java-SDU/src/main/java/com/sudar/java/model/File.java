package com.sudar.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.sudar.java.marshaller.LoadXmlToObject;

@XmlRootElement
public class File {
	
	private static Logger log = Logger.getLogger(File.class);
	
	private Parameter parameter = new Parameter();
	
	private List<Result> results = new ArrayList<Result>();

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	public void save(Map<String, String> map) {
		log.info("save");
		LoadXmlToObject.saveFilesListXML();
		getParameter().save(map);
		LoadXmlToObject.saveFilesListXML();
	}
}
