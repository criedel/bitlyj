package com.rosaloves.bitlyj;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Clicks
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class Clicks extends BitlyMethod<Set<UrlClicks>> {
	
	public Clicks(Map<String, String> parameters) {
		super("clicks", parameters);
	}

	@Override
	public Set<UrlClicks> apply(Document document) {
		NodeList nl = document.getElementsByTagName("clicks");
		HashSet<UrlClicks> clicks = new HashSet<UrlClicks>();
		
		for(int i = 0; i < nl.getLength(); i++) {
			clicks.add(parseClicks(nl.item(i)));
		}
		
		return clicks;
	}

	/**
	 * @param item
	 * @return
	 */
	private UrlClicks parseClicks(Node item) {
		NodeList nl = item.getChildNodes();
		long user = 0, global = 0;
		for(int i = 0; i < nl.getLength(); i++) {
			String name = nl.item(i).getNodeName();
			String value = nl.item(i).getTextContent();
			if("user_clicks".equals(name)) {
				user = Long.parseLong(value);
			} else if("global_clicks".equals(name)) {
				global = Long.parseLong(value);
			}
		}
		return new UrlClicks(Bitly.Methods.parseUrl(item), user, global);
	}

}
