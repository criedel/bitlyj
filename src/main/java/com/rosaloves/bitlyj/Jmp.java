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
	
	public static BitlyService as(String user, String apiKey) {
		return new BitlyService(user, apiKey, "http://api.j.mp/v3/");
	}
	
}
