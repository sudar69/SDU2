package com.sudar.java.model;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Menu {

	private List<MenuItem> items = new ArrayList<MenuItem>();
	
	public Menu() {
		MenuItem book1 = new MenuItem();
        book1.setTitle("Открыть файл");
        book1.setUrl("open");
 
        MenuItem book2 = new MenuItem();
        book2.setTitle("Создать новый файл с исходными данными");
        book2.setUrl("createfile");
        
        MenuItem book3 = new MenuItem();
        book3.setTitle("Создать функцию одного аргумента");
        book3.setUrl("createfunc1");
        
        MenuItem book4 = new MenuItem();
        book4.setTitle("Создать функцию двух аргументов");
        book4.setUrl("createfunc2");
         
        items.add(book1);
        items.add(book2);
        items.add(book3);
        items.add(book4);
	}
	
    @XmlElement(name="items")
    public List<MenuItem> getBooks() {
        return items;
    }
	
}
