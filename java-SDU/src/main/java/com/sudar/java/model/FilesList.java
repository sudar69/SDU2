package com.sudar.java.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlRootElement
public class FilesList {
	private static Logger log = Logger.getLogger(FilesList.class);
	
	private List<File> file = new ArrayList<File>();

	@XmlElement(name="file")
	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}
	
	public void add() {
		log.info("add");
		File file = new File();
		Parameter parameter = new Parameter();
		parameter.setTitle("NewFile");
		parameter.addTeta0();
		parameter.defaultRpk();
		parameter.defaultRpgforv();
		parameter.defaultBeginData();
		file.setParameter(parameter);
		getFile().add(file);
	}

}
