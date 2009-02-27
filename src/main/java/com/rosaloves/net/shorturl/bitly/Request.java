package com.rosaloves.net.shorturl.bitly;

import java.util.HashMap;
import java.util.Map;

/**
 * A HTTP request to the bit.ly API. This is basically a value bag that collects
 * name/value pairs representing request parameters and headers.
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 25, 2009)
 */
public class Request {
	
	private Map<String, String> headers = new HashMap<String, String>();
	
	private Map<String, String> parameters = new HashMap<String, String>();
	
	/**
	 * Add a HTTP header to this request.
	 *  
	 * @param name The header name
	 * @param value The header value
	 */
	public void addHeader(String name, Object value) {
		headers.put(name, value.toString());
	}
	
	/**
	 * Add parameters to the request.
	 * 
	 * @param parameters The parameters to add
	 * @throws IllegalArgumentException if the parameters are not evenly balanced.
	 */
	public void addParameters(Object ...parameters) {
		if(parameters.length % 2 != 0)
			throw new IllegalArgumentException("Unbalanced parameters!");
		
		for(int i = 0; i < parameters.length; i++)
			this.parameters.put(parameters[i].toString(), parameters[++i].toString());
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}
	
	public String getHeader(String header) {
		//TODO execption?
		return this.headers.get(header);
	}
	
	public String getParameter(String param) {
		//TODO execption?
		return this.parameters.get(param);
	}
	
}