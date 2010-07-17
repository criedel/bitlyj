package com.rosaloves.bitlyj;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
 * BitlyService
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class BitlyService {
	
	private final String user;
	
	private final String apiKey;
	
	private final String endPoint;

	BitlyService(String user, String apiKey, String endPoint) {
		super();
		this.user = user;
		this.apiKey = apiKey;
		this.endPoint = endPoint;
	}
	
	public <A> A call(BitlyMethod<A> m) {
		String endPoint = getUrlForCall(m);
		Document response = filterErrorResponse(fetchUrl(endPoint));
		return m.apply(response);
	}
	
	protected String getUrlForCall(BitlyMethod<?> m) {
		StringBuilder sb = new StringBuilder(endPoint)
			.append(m.getName() + "?")
			.append("&login=").append(user).append("&apiKey=").append(apiKey)
			.append("&format=xml");
		for(Map.Entry<String, String> entry : m.getParameters().entrySet()) {
			try {
				sb.append("&" + entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		return sb.toString();
	}
	
	private Document filterErrorResponse(Document doc) {
		int code = Integer.parseInt(doc.getElementsByTagName("status_code").item(0).getTextContent());
		if(code == 200)
			return doc;
		else {
			throw new BitlyException(doc.getElementsByTagName("status_txt").item(0).getTextContent());
		}
	}
	
	private Document fetchUrl(String url) {
		try {
			HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
			if(openConnection.getResponseCode() == 200)
				return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(openConnection.getInputStream());
			else
				throw new BitlyException("Transport error! " + openConnection.getResponseCode() + " " + openConnection.getResponseMessage());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
