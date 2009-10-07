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
	
	private String userHash = "";
	
	private URL longUrl;
	
	private URL shortUrl;
	
	public BitlyUrlImpl(String baseUrl, String hash, String userHash, String longUrl) {
		
		try {
			this.longUrl = new URL(longUrl);
			this.shortUrl = new URL(baseUrl + "/"
				+ (userHash.length() == 0 ? hash : userHash));
		} catch (MalformedURLException e) {
			throw new RuntimeException(e); // won't happen
		}
		
		this.hash = hash;
		this.userHash = userHash;
	}
	
	public String getHash() {
		return hash;
	}
	
	public String getUserHash() {
		return userHash;
	}
	
	public URL getLongUrl() {
		return longUrl;
	}
	
	public URL getShortUrl() {
		return this.shortUrl;
	}

}
