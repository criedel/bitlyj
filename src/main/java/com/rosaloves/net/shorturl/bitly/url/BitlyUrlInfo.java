package com.rosaloves.net.shorturl.bitly.url;

import java.net.URL;

/**
 * BitlyUrlInfo
 *
 * TODO This interface is currently lacking useful members.
 * TODO calais
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 24, 2009)
 */
public interface BitlyUrlInfo {
	
	/**
	 * A convenience method to get the long URL of the bit.ly URL.
	 * 
	 * @return The long URL.
	 */
	public URL getUrl();
	
	/**
	 * Get the bit.ly URL.
	 * 
	 * @return The bit.ly URL.
	 */
	public BitlyUrl getBitlyUrl();
	
}