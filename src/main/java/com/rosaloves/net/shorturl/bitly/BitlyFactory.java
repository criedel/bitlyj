package com.rosaloves.net.shorturl.bitly;

import com.rosaloves.net.shorturl.bitly.api.JmpApi;
import com.rosaloves.net.shorturl.bitly.auth.Authentication;
import com.rosaloves.net.shorturl.bitly.auth.UrlAuthentication;

/**
 * BitlyFactory
 *
 * $Id$
 *
 * @author Chris Lewis (Mar 1, 2009)
 */
public class BitlyFactory {
	
	/**
	 * 
	 * @param userName The bit.ly login name
	 * @param apiKey The bit.ly API key
	 * @return The Bitly implementation configured with an
	 */
	public static Bitly newInstance(String userName, String apiKey) {
		Authentication auth = new UrlAuthentication(userName, apiKey);
		return new BitlyImpl(auth);
	}
	
	public static Bitly newInstance(Authentication auth) {
		return new BitlyImpl(auth);
	}
	
	public static Bitly newJmpInstance(String userName, String apiKey) {
		Authentication auth = new UrlAuthentication(userName, apiKey);
		return new BitlyImpl(auth, new JmpApi());
	}
	
	public static Bitly newJmpInstance(Authentication auth) {
		return new BitlyImpl(auth, new JmpApi());
	}
	
}