package com.rosaloves.bitlyj;

import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.rosaloves.bitlyj.utils.Dom;


/**
 * Methods
 * 
 * $Id$
 * 
 * @author clewis Jul 18, 2010
 *
 */
public final class Methods {
	
	public static BitlyMethod<Info> info(String value) {
		ParameterMap hashMap = getUrlMethodParams(value);
		return new BitlyMethod<Info>("info", hashMap) {
			@Override
			public Info apply(Document document) {
				return parseInfo(document.getElementsByTagName("info").item(0));
			}
		};
	}
	
	public static BitlyMethod<Set<Info>> info(String ... values) {
		ParameterMap hashMap = getUrlMethodParams(values);
		return new BitlyMethod<Set<Info>>("info", hashMap) {
			@Override
			public Set<Info> apply(Document document) {
				HashSet<Info> inf = new HashSet<Info>();
				NodeList infos = document.getElementsByTagName("info");
				for(int i = 0; i < infos.getLength(); i ++) {
					inf.add(parseInfo(infos.item(i)));
				}
				return inf;
			}
		};
	}
	
	public static BitlyMethod<Url> expand(String values) {
		ParameterMap hashMap = getUrlMethodParams(values);
		return new BitlyMethod<Url>("expand", hashMap) {
			@Override
			public Url apply(Document document) {
				return parseUrl(document.getElementsByTagName("entry").item(0));
			}
		};
	}
	
	public static BitlyMethod<Set<Url>> expand(String ... values) {
		ParameterMap hashMap = getUrlMethodParams(values);
		return new BitlyMethod<Set<Url>>("expand", hashMap) {
			
			@Override
			public Set<Url> apply(Document document) {
				
				HashSet<Url> inf = new HashSet<Url>();
				
				NodeList infos = document.getElementsByTagName("entry");
				for(int i = 0; i < infos.getLength(); i ++) {
					inf.add(parseUrl(infos.item(i)));
				}
				
				return inf;
			}
		};
	}

	public static BitlyMethod<Url> shorten(String longUrl) {
		ParameterMap hashMap = new ParameterMap();
		hashMap.add("longUrl", longUrl);
		return new BitlyMethod<Url>("shorten", hashMap) {
			@Override
			public Url apply(Document document) {
				NodeList infos = document.getElementsByTagName("data");
				return parseUrl(infos.item(0));
			}
		};
	}
	
	public static BitlyMethod<UrlClicks> clicks(String string) {
		ParameterMap hashMap = new ParameterMap();
		hashMap.add(hashOrUrl(string), string);
		return new BitlyMethod<UrlClicks>("clicks", hashMap) {
			@Override
			public UrlClicks apply(Document document) {
				return parseClicks(document.getElementsByTagName("clicks").item(0));
			}
		};
	}
	
	public static BitlyMethod<Set<UrlClicks>> clicks(String ... string) {
		ParameterMap hashMap = getUrlMethodParams(string);
		return new BitlyMethod<Set<UrlClicks>>("clicks", hashMap) {
			@Override
			public Set<UrlClicks> apply(Document document) {
				HashSet<UrlClicks> clicks = new HashSet<UrlClicks>();
				NodeList nl = document.getElementsByTagName("clicks");
				for(int i = 0; i < nl.getLength(); i ++) {
					clicks.add(parseClicks(nl.item(i)));
				}
				return clicks;
			}
		};
	}
	
	/* Package-private parsing aids. */
	//TODO this is a util - move it
	static ParameterMap getUrlMethodParams(String... value) {
		ParameterMap pMap = new ParameterMap();
		for(String p : value) {
			pMap.add(hashOrUrl(p), p);			
		}
		return pMap;
	}
	
	static String hashOrUrl(String p) {
		return p.startsWith("http://") ? "shortUrl" : "hash";
	}
	
	static UrlClicks parseClicks(Node item) {
		NodeList nl = item.getChildNodes();
		long user = 0, global = 0;
		for(int i = 0; i < nl.getLength(); i++) {
			String name = nl.item(i).getNodeName();
			String value = Dom.getTextContent(nl.item(i));
			if("user_clicks".equals(name)) {
				user = Long.parseLong(value);
			} else if("global_clicks".equals(name)) {
				global = Long.parseLong(value);
			}
		}
		return new UrlClicks(Methods.parseUrl(item), user, global);
	}

	static Url parseUrl(Node nl) {
		Url url = new Url();
		NodeList il = nl.getChildNodes();
		for(int i = 0; i < il.getLength(); i ++) {
			
			Node n = il.item(i);
			String name = n.getNodeName();
			String value = Dom.getTextContent(n);
			
			if("short_url".equals(name)) {
				url.setShortUrl(value);
			} else if("long_url".equals(name)) {
				url.setLongUrl(value);
			} else if("url".equals(name)) {
				url.setShortUrl(value);
			} else if("global_hash".equals(name)) {
				url.setGlobalHash(value);
			} else if("user_hash".equals(name)) {
				url.setUserHash(value);
			} else if("hash".equals(name)) {
				url.setHash(value);
			}
		}
		return url;
	}
	
	static Info parseInfo(Node nl) {
		NodeList il = nl.getChildNodes();
		
		String title = "", createdBy = "";
		
		for(int i = 0; i < il.getLength(); i ++) {
			Node n = il.item(i);
			
			String name = n.getNodeName();
			String value = Dom.getTextContent(n);
			
			if("created_by".equals(name)) {
				createdBy = value;
			} else if("title".equals(name)) {
				title = value;
			}
			
		}
		
		return new Info(parseUrl(nl), createdBy, title);
	}
		
}
