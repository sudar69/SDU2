package com.sudar.java.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FunctionsList {
	
	private List<Function> function = new ArrayList<Function>();
	
	@XmlElement(name="function")
    public List<Function> getFunctions() {
        return function;
    }
}
