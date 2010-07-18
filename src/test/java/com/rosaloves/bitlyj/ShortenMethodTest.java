package com.rosaloves.bitlyj;

import static com.rosaloves.bitlyj.Bitly.expand;
import static com.rosaloves.bitlyj.Bitly.shorten;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * ShortenMethod
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class ShortenMethodTest {
	Document doc;
	
	@Before
	public void before() {
		doc = Utils.classpathXmlIS("shorten_http_betaworks.xml");
	}
	
	@Test
	public void name() {
		assertEquals("expand", expand("j3").getName());
	}

	@Test
	public void simpleLongUrlParameter() {
		BitlyMethod<Url> url = shorten("http://betaworks.com/");
		assertTrue(url.getParameters().size() == 1);
		assertEquals("http://betaworks.com/", url.getParameters().get("longUrl"));
	}
	
	@Test
	public void applyToDocument() {
		Url url = shorten("http://betaworks.com/").apply(doc);
		
		assertEquals("1YKMfY", url.getGlobalHash());
		assertEquals("cmeH01", url.getHash());
		assertEquals("http://betaworks.com/", url.getLongUrl());
		assertEquals("http://bit.ly/cmeH01", url.getShortUrl());
	}
}
