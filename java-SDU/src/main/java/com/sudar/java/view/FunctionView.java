package com.sudar.java.view;

import com.sudar.java.marshaller.LoadXmlToObject;
import com.sudar.java.marshaller.MarshallerToXML;
import com.sudar.java.model.FunctionsList;

public class FunctionView {
	
	public static String all(MarshallerToXML xml, FunctionsList ob) throws Exception {
		//return xml.marshaller(ob.loadFunctionsList().getFunctions().get(0), "functionsList.xsl");
		return xml.marshaller(LoadXmlToObject.getFl(), "functionsList.xsl");
	}
	
	public static String func2(MarshallerToXML xml, FunctionsList ob, int in) throws Exception {
		return xml.marshaller(ob.getFunctions().get(in), "function2.xsl");
	}
	
}
