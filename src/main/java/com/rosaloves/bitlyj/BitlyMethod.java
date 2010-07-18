package com.rosaloves.bitlyj;

import java.util.Collections;
import java.util.Map;

import org.w3c.dom.Document;

/**
 * BitlyMethod
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public abstract class BitlyMethod<A> {
	
	private final String name;
	
	private final Map<String, String> parameters;
	
	public BitlyMethod(String name, Map<String, String> parameters) {
		this.name = name;
		this.parameters = Collections.unmodifiableMap(parameters);
	}
	
	public String getName() {
		return name;
	}

	Map<String, String> getParameters() {
		return parameters;
	}

	@Override
	public String toString() {
		return "BitlyMethod [name=" + name + ", parameters=" + parameters + "]";
	}

	public abstract A apply(Document document);
	
}
