package com.rosaloves.net.shorturl.bitly;

import net.sf.json.JSONObject;

/**
 * Response
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 26, 2009)
 */
public interface Response {
	
	public boolean isError();
	
	public int getErrorCode();
	
	public String getErrorMessage();
	
	public boolean hasErrors();
	
	public JSONObject getJSON();
	
	public JSONObject getJSONResults();
	
	public JSONObject getJSONResult(String name);
	
}