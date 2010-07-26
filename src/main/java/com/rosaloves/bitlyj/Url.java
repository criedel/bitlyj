package com.rosaloves.bitlyj;

/**
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 * 
 */
public class Url {
	
	private String globalHash;

	private String userHash;

	private String shortUrl;

	private String longUrl;
	
	Url() {}
	
	Url(String globalHash, String userHash, String shortUrl, String longUrl) {
		super();
		this.globalHash = globalHash;
		this.userHash = userHash;
		this.shortUrl = shortUrl;
		this.longUrl = longUrl;
	}

	public String getGlobalHash() {
		return globalHash;
	}

	public String getUserHash() {
		return userHash;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	@Override
	public String toString() {
		return "Url [globalHash=" + globalHash + ", longUrl=" + longUrl
				+ ", shortUrl=" + shortUrl + ", userHash=" + userHash + "]";
	}

}
