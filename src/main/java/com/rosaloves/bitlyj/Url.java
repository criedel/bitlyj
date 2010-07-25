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

	public String getGlobalHash() {
		return globalHash;
	}

	public void setGlobalHash(String globalHash) {
		this.globalHash = globalHash;
	}

	public String getUserHash() {
		return userHash;
	}

	public void setUserHash(String userHash) {
		this.userHash = userHash;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	@Override
	public String toString() {
		return "Url [globalHash=" + globalHash + ", longUrl=" + longUrl
				+ ", shortUrl=" + shortUrl + ", userHash=" + userHash + "]";
	}

}
