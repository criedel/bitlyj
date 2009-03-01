package com.rosaloves.net.shorturl.bitly.url;

/**
 * BitlyUrlStatsImpl
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 27, 2009)
 */
public class BitlyUrlStatsImpl implements BitlyUrlStats {

	private int totalClicks;
	
	//TODO pkg private
	public BitlyUrlStatsImpl(int totalClicks) {
		this.totalClicks = totalClicks;
	}
	
	public int getTotalClicks() {
		return totalClicks;
	}

}