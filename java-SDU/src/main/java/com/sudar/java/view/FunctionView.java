package com.sudar.java.view;

import com.sudar.java.marshaller.LoadXmlToObject;
import com.sudar.java.marshaller.MarshallerToXML;
import com.sudar.java.model.FilesList;
import com.sudar.java.model.FunctionsList;

public class FunctionView {
	
	public static String all(MarshallerToXML xml, FunctionsList ob) throws Exception {
		//return xml.marshaller(ob.loadFunctionsList().getFunctions().get(0), "functionsList.xsl");
		return xml.marshaller(LoadXmlToObject.getFl(), "functionsList.xsl");
	}
	
	public static String func2(MarshallerToXML xml, FunctionsList ob, int in) throws Exception {
		return xml.marshaller(ob.getFunctions().get(in), "function2.xsl");
	}
	
	public static String func1(MarshallerToXML xml, FunctionsList ob, int in) throws Exception {
		return xml.marshaller(ob.getFunctions().get(in), "function1.xsl");
	}
	
	public static String allFiles(MarshallerToXML xml, FilesList ob) throws Exception {
		return xml.marshaller(LoadXmlToObject.getFilesList(), "filesList.xsl");
	}
	
	public static String file(MarshallerToXML xml, FilesList ob, int in) throws Exception {
		return xml.marshaller(ob.getFile().get(in), "file.xsl");
	}
	
}
