package com.rosaloves.bitlyj;

/**
 * Url
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class Url {
	
	private String globalHash;
	
	private String hash;
	
	private String shortUrl;
	
	private String longUrl;

	public String getHash() {
		return hash;
	}

	public String getGlobalHash() {
		return globalHash;
	}

	public void setGlobalHash(String globalHash) {
		this.globalHash = globalHash;
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

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "Url [globalHash=" + globalHash + ", hash=" + hash
				+ ", longUrl=" + longUrl + ", shortUrl=" + shortUrl + "]";
	}
	
}
