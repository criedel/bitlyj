package com.rosaloves.net.shorturl.bitly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import net.sf.json.JSONObject;

import com.rosaloves.net.shorturl.bitly.api.Api;
import com.rosaloves.net.shorturl.bitly.auth.Authentication;

/**
 * RESTTransport
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 25, 2009)
 */
public class RESTTransport {
	
	private Authentication auth;
	
	private Api api;
	
	RESTTransport(Authentication auth, Api api) {
		this.auth = auth;
		this.api = api;
	}
	
	public Response call(String method, Object ... args) throws IOException {
		
		Request request = auth.decorateRequest(new Request());
		
		request.addParameters("version", api.getVersion());
		request.addParameters(args);
		
		URLConnection urlCon = assembleRequestUrl(method, request)
			.openConnection();
		
		for(String header : request.getHeaders().keySet())
			urlCon.setRequestProperty(header, request.getHeader(header));
		
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(urlCon.getInputStream()));
		
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = reader.readLine()) != null)
			sb.append(line);
		
		reader.close();
		
		Response resp = parseResponse(sb.toString());
		
		return resp;
	}
	
	URL assembleRequestUrl(String method, Request request) throws MalformedURLException {
		
		StringBuilder sb = new StringBuilder(api.getEndPoint() + "/" + method + "?");
		Iterator<String> keyIterator = request.getParameters().keySet().iterator();
		
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			sb.append(String.format("%s=%s", key, request.getParameter(key)));
			if(keyIterator.hasNext()) sb.append('&');
		}
		
		return new URL(sb.toString());
	}
	
	Response parseResponse(String responseBody) {
		Response resp = new ResponseImpl(JSONObject.fromObject(responseBody));
		
		if(resp.isError()) throw new BitlyException(resp.getErrorCode(),
			resp.getErrorMessage()); //TODO add call args
		
		return resp;
	}
	
}