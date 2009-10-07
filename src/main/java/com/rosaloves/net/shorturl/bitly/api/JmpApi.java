package com.rosaloves.net.shorturl.bitly.api;

/**
 * JmpApi
 * 
 * $Id$
 * 
 * @author clewis Oct 6, 2009
 *
 */
public class JmpApi extends BitlyApi {
	
	public static final String URL = "http://j.mp";
	
	private static String API_URL = "http://api.j.mp";
	
	@Override
	public String getUrl() {
		return URL;
	}
	
	@Override
	public String getEndPoint() {
		return API_URL;
	}
	
}
