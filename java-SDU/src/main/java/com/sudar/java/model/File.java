package com.sudar.java.model;

import java.util.ArrayList;
import java.util.List;

public class File {
	
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
}
