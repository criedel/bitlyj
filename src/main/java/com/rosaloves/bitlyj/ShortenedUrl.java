package com.rosaloves.bitlyj;

/**
 * ShortenedUrl
 * 
 * $Id$
 * 
 * @author clewis Jul 26, 2010
 *
 */
public class ShortenedUrl {
	
	private final Url url;
	
	private final boolean newHash;
	
	ShortenedUrl(Url url, boolean newHash) {
		super();
		this.url = url;
		this.newHash = newHash;
	}

	public Url getUrl() {
		return url;
	}

	public boolean isNewHash() {
		return newHash;
	}

	@Override
	public String toString() {
		return "ShortenedUrl [newHash=" + newHash + ", url=" + url + "]";
	}
	
}
