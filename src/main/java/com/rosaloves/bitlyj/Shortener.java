package com.rosaloves.bitlyj;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.rosaloves.bitlyj.utils.Dom;

/**
 * Shortener
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class Shortener {
	
	private final String user;
	
	private final String apiKey;
	
	private final String endPoint;

	Shortener(String user, String apiKey, String endPoint) {
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
	
	@Override
	public String toString() {
		return "Shortener [endPoint=" + endPoint + "]";
	}

	protected String getUrlForCall(BitlyMethod<?> m) {
		StringBuilder sb = new StringBuilder(endPoint)
			.append(m.getName() + "?")
			.append("&login=").append(user)
			.append("&apiKey=").append(apiKey)
			.append("&format=xml");
		for(Map.Entry<String, List<String>> entry : m.getParameters()) {
			
			for(String value : entry.getValue()) {
				try {
					sb.append("&" + entry.getKey() + "=" + URLEncoder.encode(value, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}				
			}
			

		}
		return sb.toString();
	}
	
	private Document filterErrorResponse(Document doc) {
		Node statusCode = doc.getElementsByTagName("status_code").item(0);
		Node statusText = doc.getElementsByTagName("status_txt").item(0);
		
		if(statusCode == null || statusText == null) {
			throw new BitlyException("Unexpected response (no status and/or message)!");
		}
		
		int code = Integer.parseInt(Dom.getTextContent(statusCode));
		if(code == 200)
			return doc;
		else {
			throw new BitlyException(Dom.getTextContent(statusText));
		}
	}
	
	private Document fetchUrl(String url) {
		try {
			HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
			if(openConnection.getResponseCode() == 200)
				return DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().parse(openConnection.getInputStream());
			else
				throw new BitlyException("Transport error! "
						+ openConnection.getResponseCode() + " "
						+ openConnection.getResponseMessage());
		} catch (IOException e) {
			throw new BitlyException("Transport I/O error!", e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
