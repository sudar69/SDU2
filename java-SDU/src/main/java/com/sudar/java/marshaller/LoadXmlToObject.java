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

	public FunctionsList loadFunctionsList() {
		try {

			File file = new File("FunctionsList.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(FunctionsList.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FunctionsList customer = (FunctionsList) jaxbUnmarshaller.unmarshal(file);
			// System.out.println(customer);
			return customer;

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveXML() {

		FunctionsList customer = new FunctionsList();

		Function book1 = new Function();
		book1.setName("Cx");
		book1.setType("f2");
		book1.setDescription("Cx(alpha Mtau) for 120M");
		book1.setNameFirstArgument("delta");
		float[] x1 = { 255, 255, 0 };
		float[][] matrixB = { { -9, 1, 0 }, { 4, 1, 1 }, { -2, 2, -1 } };
		book1.setX1(x1);
		book1.setX2(x1);
		book1.setY1(matrixB);

		customer.getFunctions().add(book1);
		book1.setDescription("Cx(alpha Mtau) for 120M2");
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
