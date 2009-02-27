package com.rosaloves.net.shorturl.bitly.auth;

import com.rosaloves.net.shorturl.bitly.Request;

/**
 * An interface abstracting any authentication method that must decorate
 * the request with credentials.
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 25, 2009)
 */
public interface Authentication {
	
	public Request decorateRequest(Request request);
	
}