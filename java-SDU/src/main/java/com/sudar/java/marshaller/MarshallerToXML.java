package com.sudar.java.marshaller;

import com.sudar.java.model.Menu;
import com.sudar.java.model.MenuItem;
import com.sudar.java.model.StartPage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import javax.xml.bind.*;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.IOException;
import java.io.StringWriter;

public class MarshallerToXML {
    
	public String marshaller(StartPage startPage) throws Exception {
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
         
        Menu catalog = new Menu();
 
        // Create Transformer
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource("index.xsl");
        Transformer transformer = tf.newTransformer(xslt);
 
        // Source
        JAXBContext jc = JAXBContext.newInstance(Menu.class);
        JAXBSource source = new JAXBSource(jc, catalog);
 
        // Result
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
         
        // Transform
        transformer.transform(source, result);
        return writer.toString();
    }
}
