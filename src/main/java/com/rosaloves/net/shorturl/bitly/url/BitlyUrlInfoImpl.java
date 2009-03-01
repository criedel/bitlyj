package com.rosaloves.net.shorturl.bitly.url;

import java.net.URL;

/**
 * BitlyUrlInfoImpl
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 24, 2009)
 */
public class BitlyUrlInfoImpl implements BitlyUrlInfo {

	private BitlyUrl url;
	
	/**
	 * 
	 */
	public BitlyUrlInfoImpl(BitlyUrl url) {
		this.url = url;
	}

	public BitlyUrl getBitlyUrl() {
		// TODO Auto-generated method stub
		return url;
	}
	
	public URL getUrl() {
		return url.getLongUrl();
	}

}
