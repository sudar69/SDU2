package com.sudar.java.http;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sudar.java.marshaller.LoadXmlToObject;
import com.sudar.java.marshaller.MarshallerToXML;
import com.sudar.java.model.Menu;


/**
 * HttpResponse class defines the HTTP Response Status Line (method, URI, version) 
 * and Headers http://www.w3.org/Protocols/rfc2616/rfc2616-sec6.html
 */
public class HttpResponse {

	private static Logger log = Logger.getLogger(HttpResponse.class);

	public static final String VERSION = "HTTP/1.0";

	List<String> headers = new ArrayList<String>();

	byte[] body;

	public HttpResponse(HttpRequest req) throws IOException {
		if (req.method != null) 
		switch (req.method) {
			case HEAD:
				fillHeaders(Status._200);
				break;
			case GET:
				try {
					fillHeaders(Status._200);
					// TODO fix dir bug http://localhost:8080/src/test
					headers.add(ContentType.HTML.toString());
					Map gets = splitQuery(new URL("http://127.0.0.1" + req.uri));
					log.info(gets);
					if (req.uri.equals("/") ) {
						MarshallerToXML XML = new MarshallerToXML();
						Menu catalog = new Menu();
						fillResponse(XML.marshaller(catalog, "index.xsl"));
					} else if (gets != null && gets.get("action") != null && gets.get("action").equals("create")) {
						MarshallerToXML XML = new MarshallerToXML();
						Menu catalog = new Menu();
						fillResponse(XML.marshaller(catalog, "index.xsl"));
					} else if (gets != null && gets.get("action") != null && gets.get("action").equals("openfunc")) {
						LoadXmlToObject ob = new LoadXmlToObject();					
						MarshallerToXML XML = new MarshallerToXML();
						//ob.saveXML();
						fillResponse(XML.marshaller(ob.loadFunctionsList(), "functionsList.xsl"));
					} else {
						log.info("File not found:" + req.uri);
						fillHeaders(Status._404);
						fillResponse(Status._404.toString());
					}
					

					/*File file = new File("." + req.uri);
					if (file.isDirectory()) {
						headers.add(ContentType.HTML.toString());
						StringBuilder result = new StringBuilder("<html><head><title>Index of ");
						result.append(req.uri);
						result.append("</title></head><body><h1>Index of ");
						result.append(req.uri);
						result.append("</h1><hr><pre>");

						// TODO add Parent Directory
						File[] files = file.listFiles();
						for (File subfile : files) {
							result.append(" <a href=\"" + subfile.getPath() + "\">" + subfile.getPath() + "</a>\n");
						}
						result.append("<hr></pre></body></html>");
						fillResponse(result.toString());
					} else if (file.exists()) {
						setContentType(req.uri, headers);
						fillResponse(getBytes(file));
					} else {
						log.info("File not found:" + req.uri);
						fillHeaders(Status._404);
						fillResponse(Status._404.toString());
					}*/
				} catch (Exception e) {
					log.error("Response Error", e);
					fillHeaders(Status._400);
					fillResponse(Status._400.toString());
				}

				break;
            case POST:
				try {
                    fillHeaders(Status._200);
                    StringBuilder result = new StringBuilder("<html><head><title>Index of ");
                    log.info("Post start");
                    
                    String postData = "";
                    // read the post data
                    if (req.postDataI > 0) {
                        char[] charArray = new char[req.postDataI];
                        req.reader2.read(charArray, 0, req.postDataI);
                        postData = new String(charArray);
                    }
                    log.info("PostData:" + postData);
                    result.append("<hr></pre></body></html>");
						fillResponse(result.toString());
				} catch (Exception e) {
					log.error("Response Error", e);
					log.info(Status._400.toString());
					fillHeaders(Status._400);
					fillResponse(Status._400.toString());
				}
                break;
			case UNRECOGNIZED:
				fillHeaders(Status._400);
				fillResponse(Status._400.toString());
				break;
			default:
				fillHeaders(Status._501);
				fillResponse(Status._501.toString());
		}

	}

	private byte[] getBytes(File file) throws IOException {
		int length = (int) file.length();
		byte[] array = new byte[length];
		InputStream in = new FileInputStream(file);
		int offset = 0;
		while (offset < length) {
			int count = in.read(array, offset, (length - offset));
			offset += count;
		}
		in.close();
		return array;
	}

	private void fillHeaders(Status status) {
		headers.add(HttpResponse.VERSION + " " + status.toString());
		headers.add("Connection: close");
		headers.add("Server: SimpleWebServer");
	}

	private void fillResponse(String response) {
		body = response.getBytes();
	}

	private void fillResponse(byte[] response) {
		body = response;
	}

	public void write(OutputStream os) throws IOException {
		DataOutputStream output = new DataOutputStream(os);
		for (String header : headers) {
			output.writeBytes(header + "\r\n");
		}
		output.writeBytes("\r\n");
		if (body != null) {
			output.write(body);
		}
		output.writeBytes("\r\n");
		output.flush();
	}

	private void setContentType(String uri, List<String> list) {
		try {
			String ext = uri.substring(uri.indexOf(".") + 1);
			list.add(ContentType.valueOf(ext.toUpperCase()).toString());
		} catch (Exception e) {
			log.error("ContentType not found: " + e, e);
		}
	}
	
	public static Map<String, String> splitQuery(URL url) throws UnsupportedEncodingException {
	    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
	    String query = url.getQuery();
	    if (query != null) {
		    String[] pairs = query.split("&");
		    for (String pair : pairs) {
		        int idx = pair.indexOf("=");
		        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
		    }
		    return query_pairs;
	    } else {
	    	return null;
	    }
	}
}
