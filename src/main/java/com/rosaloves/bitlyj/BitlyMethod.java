package com.rosaloves.bitlyj;

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
	
	private final ParameterMap parameters;
	
	public BitlyMethod(String name, ParameterMap parameters) {
		this.name = name;
		this.parameters = parameters;
	}
	
	protected BitlyMethod(String name, String ... parameters) {
		this.name = name;
		
		//if(parameters.length % 2 != 0)
		
		ParameterMap p = new ParameterMap();
		for(int i = 0; i < parameters.length; i += 2)
			p.add(parameters[i], parameters[i + 1]);
		
		this.parameters = p;
	}
	
	public String getName() {
		return name;
	}

	/* Subject to change - maps dont support duplicate keys */
	ParameterMap getParameters() {
		return parameters;
	}

	@Override
	public String toString() {
		return "BitlyMethod [name=" + name + ", parameters=" + parameters + "]";
	}

	public abstract A apply(Document document);
	
}
