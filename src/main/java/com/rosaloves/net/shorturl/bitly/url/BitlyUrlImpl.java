package com.rosaloves.net.shorturl.bitly.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * BitlyUrlImpl
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 24, 2009)
 */
public class BitlyUrlImpl implements BitlyUrl {
	
	private String hash;
	
	private URL longUrl;
	
	public BitlyUrlImpl(String hash, String longUrl) {
		
		try {
			this.longUrl = new URL(longUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		this.hash = hash;
	}
	
	public String getHash() {
		return hash;
	}
	
	public URL getLongUrl() {
		return longUrl;
	}

}
