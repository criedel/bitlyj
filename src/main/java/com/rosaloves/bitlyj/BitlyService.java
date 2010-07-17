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
	
	private static final String endPoint = "http://api.bit.ly/v3/";

	public BitlyService(String user, String apiKey) {
		super();
		this.user = user;
		this.apiKey = apiKey;
	}
	

	/**
	 * @param m
	 */
	public <A> A call(BitlyMethod<A> m) {
		String endPoint = getUrlForCall(m);
		return m.apply(fetchUrl(endPoint));
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
		System.out.println("BitlyService.getUrlForCall() " + sb);
		return sb.toString();
	}
	
	private Document fetchUrl(String url) {
		try {
			HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
			System.out.println("BitlyService.fetchUrl() " + openConnection.getResponseCode());
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(openConnection.getInputStream());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
