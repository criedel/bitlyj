package com.rosaloves.net.shorturl.bitly;

/**
 * BitlyException
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 26, 2009)
 */
public class BitlyException extends RuntimeException {

	private int errorCode;

	public BitlyException() {
		super();
	}
	
	public BitlyException(Object errorMessage) {
		super(errorMessage.toString());
	}
	
	public BitlyException(int errorCode, Object errorMessage) {
		super(String.format("%s (%d)", errorMessage, errorCode));
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
}