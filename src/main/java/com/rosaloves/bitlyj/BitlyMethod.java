package com.rosaloves.bitlyj;

import java.util.Collections;
import java.util.HashMap;
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
	
	protected BitlyMethod(String name, String ... parameters) {
		this.name = name;
		
		//if(parameters.length % 2 != 0)
		
		Map<String, String> p = new HashMap<String, String>();
		for(int i = 0; i < parameters.length; i += 2)
			p.put(parameters[i], parameters[i + 1]);
		
		this.parameters = p;
	}
	
	public String getName() {
		return name;
	}

	/* Subject to change - maps dont support duplicate keys */
	Map<String, String> getParameters() {
		return parameters;
	}

	@Override
	public String toString() {
		return "BitlyMethod [name=" + name + ", parameters=" + parameters + "]";
	}

	public abstract A apply(Document document);
	
}
