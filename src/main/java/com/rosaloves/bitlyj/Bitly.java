package com.rosaloves.bitlyj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Bitly
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class Bitly {
	
	public static BitlyService as(String user, String apiKey) {
		return new BitlyService(user, apiKey, "http://api.bit.ly/v3/");
	}
	
	public static BitlyMethod<Set<Info>> info(String value) {
		return Methods.info(value);
	}
	
	public static BitlyMethod<Set<Url>> expand(String value) {
		return Methods.expand(value);
	}
	
	public static BitlyMethod<Url> shorten(String longUrl) {
		return Methods.shorten(longUrl);
	}

	public static class Methods {
		
		public static BitlyMethod<Set<Info>> info(String value) {
			HashMap<String, String> hashMap = getUrlMethodParams(value);
			return new BitlyMethod<Set<Info>>("info", hashMap) {
				@Override
				public Set<Info> apply(Document document) {
					
					HashSet<Info> inf = new HashSet<Info>();
					
					NodeList infos = document.getElementsByTagName("info");
					for(int i = 0; i < infos.getLength(); i ++) {
						inf.add(new Info(parseInfo(infos.item(i))));
					}
					
					return inf;
				}
			};
		}
		
		public static BitlyMethod<Set<Url>> expand(String values) {
			HashMap<String, String> hashMap = getUrlMethodParams(values);
			return new BitlyMethod<Set<Url>>("expand", hashMap) {
				@Override
				public Set<Url> apply(Document document) {
					
					HashSet<Url> inf = new HashSet<Url>();
					
					NodeList infos = document.getElementsByTagName("entry");
					for(int i = 0; i < infos.getLength(); i ++) {
						inf.add(parseInfo(infos.item(i)));
					}
					
					return inf;
				}
			};
		}
		
		public static BitlyMethod<Url> shorten(String longUrl) {
			HashMap<String, String> hashMap = new HashMap<String, String>();
			hashMap.put("longUrl", longUrl);
			return new BitlyMethod<Url>("shorten", hashMap) {
				@Override
				public Url apply(Document document) {
					NodeList infos = document.getElementsByTagName("data");
					return parseInfo(infos.item(0));
				}
			};
		}
		
		private static HashMap<String, String> getUrlMethodParams(String... value) {
			HashMap<String, String> hashMap = new HashMap<String, String>();
			
			for(String p : value) {
				String name = p.startsWith("http://") ? "shortUrl" : "hash";
				hashMap.put(name, p);			
			}
			return hashMap;
		}
		
		private static Url parseInfo(Node nl) {
			Url url = new Url();
			NodeList il = nl.getChildNodes();
			for(int i = 0; i < il.getLength(); i ++) {
				
				Node n = il.item(i);
				String name = n.getNodeName();
				String value = n.getTextContent();
				
				if("short_url".equals(name)) {
					url.setShortUrl(value);
				} else if("long_url".equals(name)) {
					url.setLongUrl(value);
				} else if("url".equals(name)) {
					url.setShortUrl(value);
				} else if("global_hash".equals(name)) {
					url.setGlobalHash(value);
				} else if("hash".equals(name)) {
					url.setHash(value);
				} //user_hash
			}
			return url;
		}
		
	}

}
