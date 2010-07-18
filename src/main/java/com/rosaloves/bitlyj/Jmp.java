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
	
	public static BitlyShortener as(String user, String apiKey) {
		return new BitlyShortener(user, apiKey, "http://api.j.mp/v3/");
	}
	
}
