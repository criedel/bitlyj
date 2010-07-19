package com.rosaloves.bitlyj;

/**
 * Jmp
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class Jmp {
	
	public static Shortener as(String user, String apiKey) {
		return new SimpleShortener(user, apiKey, "http://api.j.mp/v3/");
	}
	
}
