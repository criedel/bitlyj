package com.rosaloves.bitlyj;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.rosaloves.bitlyj.data.Pair;

/**
 * TestUtils
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class Utils {
	
	public static Document classpathXmlIS(String path) {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(ClassLoader.getSystemResourceAsStream(path));
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ParameterMap pairsToParameterMap(Iterable<Pair<String, String>> pairs) {
		ParameterMap parameters = new ParameterMap();
		for(Pair<String, String> p : pairs) {
			parameters.add(p.getOne(), p.getTwo());
		}
		return parameters;
	}
	
	public static <A> ParameterMap paramsAsMap(BitlyMethod<A> method) {
		return pairsToParameterMap(method.getParameters());
	}
	
}
