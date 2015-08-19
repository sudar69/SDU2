package com.sudar.java.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * HttpRequest class parses the HTTP Request Line (method, URI, version) 
 * and Headers http://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html
 */
public class HttpRequest {

	private static Logger log = Logger.getLogger(HttpRequest.class);

	List<String> headers = new ArrayList<String>();

	Method method;

	String uri;

	String version;
    
    BufferedReader reader2;
    
    int postDataI = -1;

	public HttpRequest(InputStream is) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		reader2 = reader;
        String str = reader.readLine();
		if (str != null && !str.equals("")) parseRequestLine(str);

		while (str != null && !str.equals("")) {
			str = reader.readLine();
			parseRequestHeader(str);
		}
	}

	private void parseRequestLine(String str) {
		log.info(str);
		String[] split = str.split("\\s+");
		try {
			method = Method.valueOf(split[0]);
		} catch (Exception e) {
			method = Method.UNRECOGNIZED;
		}
		uri = split[1];
		version = split[2];
	}

	private void parseRequestHeader(String str) {
		log.info(str);
		headers.add(str);
        if (str.indexOf("Content-Length:") > -1) {
            postDataI = new Integer(
                    str.substring(
                            str.indexOf("Content-Length:") + 16,
                            str.length())).intValue();
        }
	}
}
