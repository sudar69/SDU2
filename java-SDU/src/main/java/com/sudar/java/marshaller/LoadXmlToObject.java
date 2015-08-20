package com.sudar.java.marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sudar.java.model.Cell;
import com.sudar.java.model.Coll;
import com.sudar.java.model.Function;
import com.sudar.java.model.FunctionsList;
import com.sudar.java.model.MenuItem;
import com.sudar.java.model.Row;

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
		
		Cell cell1 = new Cell();
		cell1.setValue(0.16);
		
		Coll coll1 = new Coll();
		coll1.setIndex(0.5);
		coll1.setCell(cell1);
		Row row1 = new Row();
		row1.setIndex(0);
		row1.getColl().add(coll1);
		
		List<Row> table = book1.getRow();
		table.add(row1);

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
