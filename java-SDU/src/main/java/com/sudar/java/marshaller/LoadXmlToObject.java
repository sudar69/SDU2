package com.sudar.java.marshaller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sudar.java.model.Function;
import com.sudar.java.model.FunctionsList;
import com.sudar.java.model.MenuItem;

public class LoadXmlToObject {
	
	public void loadXML() {
		try {
		
			File file = new File("FunctionsList.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(FunctionsList.class);
		
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FunctionsList customer = (FunctionsList) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);
		
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}
	
	public void saveXML() {
		
		FunctionsList customer = new FunctionsList();

	
		Function book1 = new Function();
	    book1.setName("test1");
	    book1.setType("test2");
	      
	    customer.getFunctions().add(book1);
		
		try {
		
			File file = new File("file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(FunctionsList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);
		
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
}
