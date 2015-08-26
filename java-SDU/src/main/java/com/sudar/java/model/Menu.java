package com.sudar.java.model;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Menu {

	private List<MenuItem> items = new ArrayList<MenuItem>();
	
	public Menu() {
		
		String[][] data = {
				{ "Открыть файл", "?action=func" },
				{ "Открыть функцию", "?controller=func" },
				{ "Создать новый файл с исходными данными", "createfile" },
				{ "Создать функцию одного аргумента", "createfunc1" },
				{ "Создать функцию двух аргументов", "createfunc2" }};
	    for (String s[] : data) {
	      
	      MenuItem book1 = new MenuItem();
	      book1.setTitle(s[0]);
	      book1.setUrl(s[1]);
	      
	      items.add(book1);
	    }
		
	}
	
    @XmlElement(name="items")
    public List<MenuItem> getBooks() {
        return items;
    }
	
}
