package com.rosaloves.bitlyj;

import java.util.Set;

/**
 * Bitly
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public final class Bitly {
	
	public static Shortener as(String user, String apiKey) {
		return new SimpleShortener(user, apiKey, "http://api.bit.ly/v3/");
	}
	
	public static BitlyMethod<Info> info(String value) {
		return Methods.info(value);
	}
	
	public static BitlyMethod<Set<Info>> info(String ... value) {
		return Methods.info(value);
	}
	
	public static BitlyMethod<Url> expand(String value) {
		return Methods.expand(value);
	}
	
	public static BitlyMethod<Set<Url>> expand(String ... value) {
		return Methods.expand(value);
	}
	
	public static BitlyMethod<Url> shorten(String longUrl) {
		return Methods.shorten(longUrl);
	}
	
	public static BitlyMethod<UrlClicks> clicks(String string) {
		return Methods.clicks(string);
	}
	
	public static BitlyMethod<Set<UrlClicks>> clicks(String ... string) {
		return Methods.clicks(string);
	}

}
