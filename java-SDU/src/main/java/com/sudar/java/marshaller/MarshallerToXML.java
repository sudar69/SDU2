package com.sudar.java.marshaller;

import com.sudar.java.model.StartPage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import javax.xml.bind.*;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.IOException;

public class MarshallerToXML {
    
	public static void marshaller(StartPage startPage) throws Exception {
        // Create Transformer
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource("index.xsl");
        Transformer transformer = tf.newTransformer(xslt);
 
        // Source
        JAXBContext jc = JAXBContext.newInstance(StartPage.class);
        JAXBSource source = new JAXBSource(jc, startPage);
 
        // Result
        StreamResult result = new StreamResult("index.html");
         
        // Transform
        transformer.transform(source, result);
    }
}
