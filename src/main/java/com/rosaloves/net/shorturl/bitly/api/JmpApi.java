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
	
	private static String API_URL = "http://api.j.mp";
	
	@Override
	public String getEndPoint() {
		return API_URL;
	}
	
}
