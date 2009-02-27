package com.rosaloves.net.shorturl.bitly;

import static java.lang.String.format;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.tapestry5.json.JSONObject;

/**
 * Bitly
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 5, 2009)
 * @deprecated Experimental and tightly coupled.
 */
public class Bitly {
	
	public static String API_URL = "http://api.bit.ly";
	
	private ExceptionFactory exceptions = new ExceptionFactory();
	
	private String login;
	
	private String apiKey;
	
	public Bitly(String login, String apiKey) {
		this.login = login;
		this.apiKey = apiKey;
	}
	
	public JSONObject call(String command, Object ... args) throws IOException {
		
		StringBuilder sb = new StringBuilder(Bitly.API_URL);
		sb.append(format("/%s?version=%s&login=%s&apiKey=%s", command, "2.0.1",
			this.login, this.apiKey));
		
		for(int i = 0; i < args.length; i++)
			sb.append(format("&%s=%s", args[i], args[++i]));
		
		URL url = new URL(sb.toString());
		//if(command.equals("shorten")) throw new RuntimeException(url.toString());
		sb.setLength(0);
		
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(url.openStream()));
		
		String line = null;
		while((line = reader.readLine()) != null)
			sb.append(line);
		
		reader.close();
		
		JSONObject json = new JSONObject(sb.toString());
		
		int errorCode = Integer.parseInt(json.get("errorCode").toString());
		
		if(errorCode != 0) {
			throw exceptions.getException(errorCode, json);
		}
		
		return json;
		
	}
	
	private static class ExceptionFactory {
		
		public BitlyException getException(int errorCode, JSONObject response) {
			if(errorCode == 1204)
				return new InvalidBitlyHash("<unknown>", "TODO");
			else
				return new BitlyException(errorCode, response.get("errorMessage").toString());
		}
		
	}
	
}