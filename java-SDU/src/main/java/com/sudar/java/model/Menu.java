package com.sudar.java.model;

import java.util.*;
import javax.xml.bind.annotation.*;

import com.sudar.java.marshaller.LoadXmlToObject;

@XmlRootElement
public class Menu {

	private List<MenuItem> items = new ArrayList<MenuItem>();

	private List<File> file = new ArrayList<File>();

	public Menu() {

		String[][] data = { { "Открыть файл", "?controller=files" }, { "Открыть функцию", "?controller=func" } };
		for (String s[] : data) {

			MenuItem book1 = new MenuItem();
			book1.setTitle(s[0]);
			book1.setUrl(s[1]);

			items.add(book1);
		}
		loadFile();

	}

	private void loadFile() {
		FilesList fl = LoadXmlToObject.getFilesList();

		for (int i = 0; i < fl.getFile().size(); i++) {
			if (fl.getFile().get(i).getStartCalc() != 0) {
				getFile().add(fl.getFile().get(i));
			}
		}
	}

	@XmlElement(name = "items")
	public List<MenuItem> getBooks() {
		return items;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

}
