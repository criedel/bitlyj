package com.rosaloves.bitlyj;

import com.rosaloves.bitlyj.Bitly.Provider;

/**
 * Jmp
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class Jmp {
	
	public static Provider as(String user, String apiKey) {
		return new SimpleProvider(user, apiKey, "http://api.j.mp/v3/");
	}
	
}
