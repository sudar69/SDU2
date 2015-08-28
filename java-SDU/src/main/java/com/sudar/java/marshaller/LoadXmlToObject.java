package com.sudar.java.marshaller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sudar.java.model.FilesList;
import com.sudar.java.model.FunctionsList;


public class LoadXmlToObject {
	private static Logger log = Logger.getLogger(LoadXmlToObject.class);
	
	private static FunctionsList fl;
	
	private static FilesList filesList;

	public void loadFunctionsList() {
		log.info("loadFunctionsList");
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
	
	public void loadFilesList() {
		log.info("loadFilesList");
		try {

			File file = new File("filesList.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(FilesList.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FilesList customer = (FilesList) jaxbUnmarshaller.unmarshal(file);
			// System.out.println(customer);
			setFilesList(customer);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void saveXML() {
		log.info("saveXML");
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
	
	public static void saveFilesListXML() {
		log.info("saveFilesListXML");
		try {

			File file = new File("filesList.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(FilesList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(getFilesList(), file);

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

	public static FilesList getFilesList() {
		return filesList;
	}

	public void setFilesList(FilesList filesList) {
		this.filesList = filesList;
	}
}
