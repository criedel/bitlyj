package com.rosaloves.bitlyj;

/**
 * BitlyException
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class BitlyException extends RuntimeException {

	private static final long serialVersionUID = 8300631062123036696L;
	
	BitlyException(String message) {
		super(message);
	}
	
}
