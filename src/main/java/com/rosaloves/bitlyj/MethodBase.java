package com.rosaloves.bitlyj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import com.rosaloves.bitlyj.data.Pair;

/**
 * BitlyMethod
 * TODO: reflect 2 different things:
 * 1) call parameters
 * 2) transformation to apply
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public abstract class MethodBase<A> implements BitlyMethod<A> {
	
	private final String name;
	
	private final ParameterMap parameters;
	
	public MethodBase(String name, Pair<String, String> ... parameters) {
		this(name, Arrays.asList(parameters));
	}
	
	public MethodBase(String name, Iterable<Pair<String, String>> parameters) {
		this.name = name;
		this.parameters = new ParameterMap();
		
		for(Pair<String, String> p : parameters) {
			this.parameters.add(p.getOne(), p.getTwo());
		}
	}
	
	public String getName() {
		return name;
	}

	public Iterable<Pair<String, String>> getParameters() {
		List<Pair<String, String>> pa = new ArrayList<Pair<String,String>>();
		for(Map.Entry<String, List<String>> entry : parameters) {
			for(String value : entry.getValue()) {
				pa.add(Pair.p(entry.getKey(), value));
			}
		}
		return pa;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() 
			+ " [name=" + name + ", parameters=" + parameters + "]";
	}

	public abstract A apply(Document document);
	
}
