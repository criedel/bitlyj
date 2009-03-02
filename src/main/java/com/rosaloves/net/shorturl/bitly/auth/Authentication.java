package com.rosaloves.net.shorturl.bitly.auth;

import com.rosaloves.net.shorturl.bitly.Request;

/**
 * An interface abstracting the authentication method used against the bit.ly
 * service. The only assumption is that authentication must be done via a 
 * request that supports the notion of "parameters" and "headers." bit.ly
 * allows 2 ways to authenticate: 1) Basic HTTP and 2) URL parameters. Each
 * of these ways require that the authenticator add credentials to the
 * outgoing HTTP request.
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 25, 2009)
 */
public interface Authentication {
	
	/**
	 * Add authentication credentials to the outgoing request.
	 * 
	 * @param request The outgoing request
	 * @return The instance passed in (for chaining)
	 */
	public Request decorateRequest(Request request);
	
}