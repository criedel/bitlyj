package com.rosaloves.net.shorturl.bitly.url;

import java.net.URL;

/**
 * A BitlyUrl is a URL shortend by the bit.ly service.
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 24, 2009)
 */
public interface BitlyUrl {
	
	/**
	 * 
	 * @return The URL hash, as assigned by bit.ly.
	 */
	public String getHash();
	
	/**
	 * 
	 * @return The URL to which this object points.
	 */
	public URL getLongUrl();
	
}