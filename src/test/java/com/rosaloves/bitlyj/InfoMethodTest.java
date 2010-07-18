package com.rosaloves.bitlyj;

import static com.rosaloves.bitlyj.Bitly.as;
import static com.rosaloves.bitlyj.Bitly.info;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * Factory
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class InfoMethodTest {
	
	Document doc;
	
	@Before
	public void before() {
		doc = Utils.classpathXmlIS("info_http_tcrn.xml");
	}
	
	@Test
	public void name() {
		assertEquals("http://api.bit.ly/v3/info?&login=bitlyapidemo&apiKey=R_0da49e0a9118ff35f52f629d2d71bf07&format=xml&hash=j3", as("bitlyapidemo", "R_0da49e0a9118ff35f52f629d2d71bf07").getUrlForCall(Bitly.info("j3")));
		Assert.assertEquals("info", info("somehash").getName());
	}

	@Test
	public void buildWithSingleHashArgument() {
		BitlyMethod<Set<Info>> info = info("abc");
		Assert.assertTrue(info.getParameters().size() == 1);
		Assert.assertEquals("abc", info.getParameters().get("hash"));
	}
	
	@Test
	public void buildWithSingleUrlArgument() {
		BitlyMethod<Set<Info>> info = info("http://shortened.com");
		Assert.assertTrue(info.getParameters().size() == 1);
		Assert.assertEquals("http://shortened.com", info.getParameters().get("shortUrl"));
	}
	
	@Test
	public void infoResultParsing() {
		Info info = info("http://tcrn.ch/a4MSUH").apply(doc).iterator().next();
		assertEquals("j3h14h", info.getCreatedBy());
		assertEquals("Windows Mobile Finally Checks Out Foursquare", info.getTitle());
	}
	
	@Test
	public void urlResultParsing() {
		Url url = info("http://tcrn.ch/a4MSUH").apply(doc).iterator().next().getUrl();
		assertEquals("http://tcrn.ch/a4MSUH", url.getShortUrl());
		assertEquals("bWw49z", url.getGlobalHash());
		assertEquals("a4MSUH", url.getUserHash());
	}
	
}
