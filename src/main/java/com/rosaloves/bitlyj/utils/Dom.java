package com.rosaloves.bitlyj.utils;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Dom
 * 
 * $Id$
 * 
 * @author clewis Jul 18, 2010
 *
 */
public final class Dom {
	
	public static String getTextContent(Node n) {
		StringBuffer sb = new StringBuffer(); 
		NodeList nl = n.getChildNodes(); 
		for (int i = 0; i < nl.getLength(); i++) { 
		    Node child = nl.item(i); 
		    if (child.getNodeType() == Node.TEXT_NODE) 
		    	sb.append(child.getNodeValue()); 
		}
		return sb.toString();
	}
	
}
