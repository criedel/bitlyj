package com.rosaloves.bitlyj;

import static com.rosaloves.bitlyj.Bitly.as;
import static com.rosaloves.bitlyj.Methods.info;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import com.rosaloves.bitlyj.Bitly.Provider;

/**
 * Factory
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class InfoMethodTest {
	
	Provider bitly = as("bitlyapidemo", "R_0da49e0a9118ff35f52f629d2d71bf07");
	Document doc;
	
	@Before
	public void before() {
		doc = Utils.classpathXmlIS("info_http_tcrn.xml");
	}
	
	@Test
	public void name() {
		Assert.assertEquals("info", info("somehash").getName());
	}

	@Test
	public void buildWithSingleHashArgument() {
		ParameterMap p = Utils.paramsAsMap(info("abc"));
		Assert.assertTrue(p.size() == 1);
		Assert.assertEquals("abc", p.get("hash").get(0));
	}
	
	@Test
	public void buildWithMultipleHashArguments() {
		ParameterMap p = Utils.paramsAsMap(info("j3", "a3."));
		Assert.assertEquals(2, p.get("hash").size());
	}
	
	@Test
	public void buildWithSingleUrlArgument() {
		ParameterMap p = Utils.paramsAsMap(info("http://shortened.com"));
		Assert.assertTrue(p.size() == 1);
		Assert.assertEquals("http://shortened.com", p.get("shortUrl").get(0));
	}
	
	@Test
	public void buildWithMultipleUrlArguments() {
		ParameterMap p = Utils.paramsAsMap(info("http://shortened.com", "http://foo.com"));
		Assert.assertEquals(2, p.get("shortUrl").size());
	}
	
	@Test
	public void infoResultParsing() {
		UrlInfo info = info("http://tcrn.ch/a4MSUH").apply(bitly, doc);
		assertEquals("j3h14h", info.getCreatedBy());
		assertEquals("Windows Mobile Finally Checks Out Foursquare", info.getTitle());
	}
	
	@Test
	public void urlResultParsing() {
		Url url = info("http://tcrn.ch/a4MSUH").apply(bitly, doc).getUrl();
		assertEquals("http://tcrn.ch/a4MSUH", url.getShortUrl());
		assertEquals("bWw49z", url.getGlobalHash());
		assertEquals("a4MSUH", url.getUserHash());
	}
	
}
