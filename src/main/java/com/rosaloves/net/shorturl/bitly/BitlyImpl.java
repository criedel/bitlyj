package com.rosaloves.net.shorturl.bitly;

import java.io.IOException;
import java.net.URL;

import org.apache.tapestry5.json.JSONObject;

import com.rosaloves.net.shorturl.bitly.auth.Authentication;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrl;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlImpl;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlInfo;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlInfoImpl;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlStats;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlStatsImpl;

/**
 * BitlyImpl
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 24, 2009)
 */
public class BitlyImpl implements IBitly {
	
	private RESTTransport transport;
	
	BitlyImpl(Authentication auth) {
		transport = new RESTTransport(auth);
	}
	
	public URL expandHash(String hash) throws IOException {
		
		Response resp = transport.call(BitlyImpl.METHOD_EXPAND, "hash", hash);
		
		return new URL(resp.getJSONResult(hash).getString("longUrl"));
		
	}

	public BitlyUrlInfo info(String hash) throws IOException {
		
		Response resp = transport.call(IBitly.METHOD_INFO, "hash", hash);
		
		JSONObject json = resp.getJSONResult(hash);
		
		return new BitlyUrlInfoImpl(new BitlyUrlImpl(json.getString("hash"), json.getString("longUrl")));
		
	}

	public BitlyUrl shorten(String longUrl, String keyword) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public BitlyUrl shorten(String longUrl) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public BitlyUrlStats stats(String hash) throws IOException {
		
		Response resp = transport.call(IBitly.METHOD_STATS, "hash", hash);
		JSONObject results = resp.getJSONResults();
		
		BitlyUrlStats stats = new BitlyUrlStatsImpl(results.getInt("clicks"));
		
		return stats;
	}
	
}