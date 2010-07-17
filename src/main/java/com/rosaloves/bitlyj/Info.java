package com.rosaloves.bitlyj;

/**
 * Info
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class Info {
	
	private final Url url;
	
	public Info(Url url) {
		super();
		this.url = url;
	}

	public Url getUrl() {
		return url;
	}

	public String getLongUrl() {
		return url.getLongUrl();
	}

	@Override
	public String toString() {
		return "Info [url=" + url + "]";
	}

}
