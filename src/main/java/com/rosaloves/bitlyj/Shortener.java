package com.rosaloves.bitlyj;

/**
 * Shortener
 * 
 * $Id$
 * 
 * @author clewis Jul 19, 2010
 *
 */
public interface Shortener {

	public abstract <A> A call(BitlyMethod<A> m);

}