package com.sudar.java.model;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class StartPage {
	
	private final String files = "Открыть файл";
	
	private String createFile = "Создать новый файл с исходными данными";
	
	private String createTableFunc1 = "функцию одного аргумента";
	
	private String createTableFunc2 = "функцию двух аргументов";

	@XmlElement(name="files")
	public String getFiles() {
		return files;
	}

	@XmlElement(name="createFile")
	public String getCreateFile() {
		return createFile;
	}

	public void setCreateFile(String createFile) {
		this.createFile = createFile;
	}

	@XmlElement(name="createTableFunc1")
	public String getCreateTableFunc1() {
		return createTableFunc1;
	}

	public void setCreateTableFunc1(String createTableFunc1) {
		this.createTableFunc1 = createTableFunc1;
	}

	@XmlElement(name="createTableFunc2")
	public String getCreateTableFunc2() {
		return createTableFunc2;
	}

	public void setCreateTableFunc2(String createTableFunc2) {
		this.createTableFunc2 = createTableFunc2;
	}
}
