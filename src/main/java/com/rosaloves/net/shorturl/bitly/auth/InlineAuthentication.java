package com.rosaloves.net.shorturl.bitly.auth;

import com.rosaloves.net.shorturl.bitly.Request;

/**
 * An implementation of Authentication that authenticates requests "inline"
 * via request parameters in the URL. Instances are immutable, so a single
 * instance may be safely used across client instances, threads, etc.
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 25, 2009)
 */
public class InlineAuthentication implements Authentication {
	
	private String userName;

	private String apiKey;
	
	/**
	 * Constructor.
	 * 
	 * @param userName The bit.ly login name
	 * @param apiKey The bit.ly API key
	 */
	public InlineAuthentication(String userName, String apiKey) {
		this.userName = userName;
		this.apiKey = apiKey;
	}
	
	public Request decorateRequest(Request request) {
		request.addParameters("login", userName, "apiKey", apiKey);
		return request;
	}
	
}