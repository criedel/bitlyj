package com.rosaloves.net.shorturl.bitly;

import net.sf.json.JSONObject;

/**
 * ResponseImpl
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 26, 2009)
 */
public class ResponseImpl implements Response {

	private JSONObject json;
	
	private JSONObject results;
	
	private int errorCode;
	
	private String errorMessage;
	
	ResponseImpl(JSONObject json) {
		this.json = json;
		
		errorCode = json.getInt("errorCode");
		errorMessage = json.getString("errorMessage");
		results = json.getJSONObject("results");
	}
	
	public JSONObject getJSON() {
		return this.json;
	}
	
	public JSONObject getJSONResults() {
		return this.results;
	}
	
	public JSONObject getJSONResult(String name) {
		return this.results.getJSONObject(name);
	}

	public boolean hasErrors() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isError() {
		return this.errorCode != 0;
	}
	
	public int getErrorCode() {
		return this.errorCode;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
}