package com.rosaloves.bitlyj;

/**
 * UrlClicks
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class UrlClicks {

	private final long userClicks;
	
	private final long globalClicks;
	
	private final Url url;

	/**
	 * @param userClicks
	 * @param globalClicks
	 */
	public UrlClicks(Url url, long userClicks, long globalClicks) {
		super();
		this.url = url;
		this.userClicks = userClicks;
		this.globalClicks = globalClicks;
	}

	public Url getUrl() {
		return url;
	}

	public long getUserClicks() {
		return userClicks;
	}

	public long getGlobalClicks() {
		return globalClicks;
	}

	@Override
	public String toString() {
		return "UrlClicks [globalClicks=" + globalClicks 
				+ ", userClicks=" + userClicks + ", url=" + url + "]";
	}

	
}
