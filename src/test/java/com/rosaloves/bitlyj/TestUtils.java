package com.rosaloves.bitlyj;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
 * TestUtils
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class TestUtils {
	public static Document classpathXmlIS(String path) {
		try {
			
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ClassLoader.getSystemResourceAsStream(path));
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
