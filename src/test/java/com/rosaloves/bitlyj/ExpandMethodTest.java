package com.rosaloves.bitlyj;

import static com.rosaloves.bitlyj.Bitly.as;
import static com.rosaloves.bitlyj.Bitly.expand;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import com.rosaloves.bitlyj.Bitly.Provider;

/**
 * ExpandMethod
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class ExpandMethodTest {
	
	Provider bitly = as("bitlyapidemo", "R_0da49e0a9118ff35f52f629d2d71bf07");
	Document doc;
	
	@Before
	public void before() {
		doc = Utils.classpathXmlIS("expand_j3.xml");
	}
	
	@Test
	public void name() {
		assertEquals("expand", expand("j3").getName());
	}

	@Test
	public void buildWithSingleHashArgument() {
		ParameterMap p = Utils.paramsAsMap(expand("j3"));
		assertTrue(p.size() == 1);
		assertEquals("j3", p.get("hash").get(0));
	}
	
	@Test
	public void buildWithMultipleHashArguments() {
		ParameterMap p = Utils.paramsAsMap(expand("j3", "a3."));
		assertTrue(p.size() == 1);
		Assert.assertEquals(2, p.get("hash").size());
	}
	
	@Test
	public void buildWithSingleUrlArgument() {
		ParameterMap p = Utils.paramsAsMap(expand("http://bit.ly/1YKMfY"));
		assertTrue(p.size() == 1);
		assertEquals("http://bit.ly/1YKMfY", p.get("shortUrl").get(0));
	}
	
	@Test
	public void buildWithMultipleUrlArguments() {
		ParameterMap p = Utils.paramsAsMap(expand("http://bit.ly/1YKMfY", "http://foo"));
		assertTrue(p.size() == 1);
		Assert.assertEquals(2, p.get("shortUrl").size());
	}
	
	@Test
	public void applyToDocument() {
		Url url = expand("j3").apply(bitly, doc);
		
		assertEquals("lLWr", url.getGlobalHash());
		assertEquals("j3", url.getUserHash());
		assertEquals("http://www.scotster.com/qf/?1152", url.getLongUrl());
	}
}
