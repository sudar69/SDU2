package com.sudar.java.marshaller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sudar.java.model.FunctionsList;


public class LoadXmlToObject {
	
	private static FunctionsList fl;

	public void loadFunctionsList() {
		try {

			File file = new File("FunctionsList.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(FunctionsList.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FunctionsList customer = (FunctionsList) jaxbUnmarshaller.unmarshal(file);
			// System.out.println(customer);
			setFl(customer);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void saveXML() {

		try {

			File file = new File("FunctionsList.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(FunctionsList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(getFl(), file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static FunctionsList getFl() {
		return fl;
	}

	public void setFl(FunctionsList fl) {
		this.fl = fl;
	}
}
