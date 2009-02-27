package com.rosaloves.net.shorturl.bitly;

public class InvalidBitlyHash extends BitlyException {
	
	private String hash;
	
	public InvalidBitlyHash(String hash) {
		super(String.format("\"%s\" is not a valid bitly hash!", hash));
		this.hash = hash;
	}
	
	public InvalidBitlyHash(String hash, String errorMessage) {
		super(String.format("%s (%s)", hash, errorMessage));
		this.hash = hash;
	}
	
}