package com.rosaloves.net.shorturl.bitly;

import java.io.IOException;
import java.net.URL;

import com.rosaloves.net.shorturl.bitly.url.BitlyUrl;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlInfo;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlStats;

/**
 * The client interface to the bit.ly API. The URL methods provided by bit.ly
 * are defined here; client code need only access an implementation. 
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 24, 2009)
 */
public interface Bitly {
	
	public static final String API_URL = "http://api.bit.ly";
	
	public static final String API_VERSION = "2.0.1";
	
	public static final String METHOD_EXPAND = "expand";
	
	public static final String METHOD_INFO = "info";
	
	public static final String METHOD_STATS = "stats";
	
	/**
	 * Shorten a URL.
	 * 
	 * @param longUrl The URL to shorten
	 * @return The shortened URL
	 */
	public BitlyUrl shorten(String longUrl) throws IOException;
	
	/**
	 * Shorten a URL using a predefined hash (keyword).
	 * 
	 * @param longUrl The URL to shorten
	 * @param keyword A specific hash/keyword to use
	 */
	public BitlyUrl shorten(String longUrl, String keyword) throws IOException;
	
	/**
	 * Expand a hash into its original long URL.
	 * 
	 * @param hash The hash of the shortened URL
	 * @return The original long URL
	 * @throws IOException
	 */
	public URL expandHash(String hash) throws IOException;
	
	/**
	 * 
	 * 
	 * @param hash
	 * @return
	 * @throws IOException
	 */
	public BitlyUrlInfo info(String hash) throws IOException;
	
	//public Collection<BitlyUrlInfo> info(String ... hashes) throws IOException;
	
	public BitlyUrlStats stats(String hash) throws IOException;
	
	//errors
	
}