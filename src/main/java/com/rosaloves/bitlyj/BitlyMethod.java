package com.rosaloves.bitlyj;

import org.w3c.dom.Document;

import com.rosaloves.bitlyj.Bitly.Provider;
import com.rosaloves.bitlyj.data.Pair;

/**
 * A method invokable via a Provider.
 * 
 * $Id$
 * 
 * @author clewis Jul 19, 2010
 *
 * @param <A>
 */
public interface BitlyMethod<A> {

	public String getName();

	public Iterable<Pair<String, String>> getParameters();

	public A apply(Provider provider, Document document);
	
}