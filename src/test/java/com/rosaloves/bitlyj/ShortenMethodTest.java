package com.rosaloves.bitlyj;

import static com.rosaloves.bitlyj.Bitly.as;
import static com.rosaloves.bitlyj.Bitly.shorten;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import com.rosaloves.bitlyj.Bitly.Provider;

/**
 * ShortenMethod
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class ShortenMethodTest {
	
	Provider bitly = as("bitlyapidemo", "R_0da49e0a9118ff35f52f629d2d71bf07");
	Document doc;
	
	@Before
	public void before() {
		doc = Utils.classpathXmlIS("shorten_http_betaworks.xml");
	}
	
	@Test
	public void name() {
		assertEquals("shorten", shorten("http://betaworks.com/").getName());
	}

	@Test
	public void simpleLongUrlParameter() {
		ParameterMap p = Utils.paramsAsMap(shorten("http://betaworks.com/"));
		assertTrue(p.size() == 1);
		assertEquals("http://betaworks.com/", p.get("longUrl").get(0));
	}
	
	@Test
	public void applyToDocument() {
		Url url = shorten("http://betaworks.com/").apply(bitly, doc).getUrl();
		
		assertEquals("1YKMfY", url.getGlobalHash());
		assertEquals("cmeH01", url.getUserHash());
		assertEquals("http://betaworks.com/", url.getLongUrl());
		assertEquals("http://bit.ly/cmeH01", url.getShortUrl());
	}
}
