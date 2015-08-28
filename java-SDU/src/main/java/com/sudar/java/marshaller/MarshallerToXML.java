package com.sudar.java.marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import com.sudar.java.model.FilesList;
import com.sudar.java.model.FunctionsList;
import com.sudar.java.model.Menu;

import java.io.StringWriter;

public class MarshallerToXML {
    
	public String marshaller(Object contentObject, String fileId) throws Exception {
        // Create Transformer
        /*TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource("index.xsl");
        Transformer transformer = tf.newTransformer(xslt);
 
        // Source
        JAXBContext jc = JAXBContext.newInstance(StartPage.class);
        JAXBSource source = new JAXBSource(jc, startPage);

        // Result
        //StreamResult result = new StreamResult("index.html");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
         
        // Transform
        transformer.transform(source, result);
        return writer.toString();*/
         
        
 
        // Create Transformer
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource(fileId);
        Transformer transformer = tf.newTransformer(xslt);
 
        // Source
        JAXBContext jc = JAXBContext.newInstance(Menu.class, FunctionsList.class, FilesList.class);
        JAXBSource source = new JAXBSource(jc, contentObject);
 
        // Result
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
         
        // Transform
        transformer.transform(source, result);
        return writer.toString();
    }
}
