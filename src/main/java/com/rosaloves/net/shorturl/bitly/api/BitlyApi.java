package com.rosaloves.net.shorturl.bitly.api;

/**
 * BitlyApi
 * 
 * $Id$
 * 
 * @author clewis Oct 6, 2009
 *
 */
public class BitlyApi implements Api {
	
	public static final String URL = "http://bit.ly";
	
	public static final String API_URL = "http://api.bit.ly";
	
	public static final String API_VERSION = "2.0.1";
	
	public String getUrl() {
		return URL;
	}
	
	public String getEndPoint() {
		return API_URL;
	}
	
	public String getVersion() {
		return API_VERSION;
	}
	
}
