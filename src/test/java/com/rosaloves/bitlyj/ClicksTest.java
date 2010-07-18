package com.rosaloves.bitlyj;

import static com.rosaloves.bitlyj.Bitly.clicks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * ClicksTest
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class ClicksTest {
	Document doc;
	
	@Before
	public void before() {
		doc = Utils.classpathXmlIS("clicks_http_tcrn.xml");
	}
	
	@Test
	public void name() {
		assertEquals("clicks", clicks("http://tcrn.ch/a4MSUH").getName());
	}

	@Test
	public void buildWithSingleHashArgument() {
		BitlyMethod<Set<UrlClicks>> url = clicks("t");
		assertTrue(url.getParameters().size() == 1);
		assertEquals("t", url.getParameters().get("hash"));
	}
	
	@Test
	public void buildWithSingleUrlArgument() {
		BitlyMethod<Set<UrlClicks>> url = clicks("http://tcrn.ch/a4MSUH");
		assertTrue(url.getParameters().size() == 1);
		assertEquals("http://tcrn.ch/a4MSUH", url.getParameters().get("shortUrl"));
	}
	
	@Test
	public void clickResultSums() {
		UrlClicks clicks = new UrlClicks(new Url(), 1, 2);
		assertEquals(1, clicks.getUserClicks());
		assertEquals(2, clicks.getGlobalClicks());
		assertEquals(3, clicks.getTotalClicks());
	}
	
	@Test
	public void clickResultParsing() {
		UrlClicks clicks = clicks("http://tcrn.ch/a4MSUH").apply(doc).iterator().next();
		
		assertEquals(0, clicks.getUserClicks());
		assertEquals(1105, clicks.getGlobalClicks());
		assertEquals(1105, clicks.getTotalClicks());
	}
	
	@Test
	public void urlResultParsing() {
		Url url = clicks("http://tcrn.ch/a4MSUH").apply(doc).iterator().next().getUrl();
		
		assertEquals("http://tcrn.ch/a4MSUH", url.getShortUrl());
		assertEquals("bWw49z", url.getGlobalHash());
		assertEquals("a4MSUH", url.getUserHash());
	}
}
