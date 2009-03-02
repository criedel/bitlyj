package com.rosaloves.net.shorturl.bitly.url;

import java.net.MalformedURLException;
import java.net.URL;

import com.rosaloves.net.shorturl.bitly.Bitly;

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
	
	public BitlyUrlImpl(String hash, String userHash, String longUrl) {
		
		try {
			this.longUrl = new URL(longUrl);
			this.shortUrl = new URL(Bitly.URL + "/"
				+ (userHash.length() == 0 ? hash : userHash));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e); //FIXME!
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
