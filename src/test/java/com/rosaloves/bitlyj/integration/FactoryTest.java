package com.rosaloves.bitlyj.integration;

import static com.rosaloves.bitlyj.Bitly.as;
import static com.rosaloves.bitlyj.Bitly.expand;
import static com.rosaloves.bitlyj.Bitly.info;
import static com.rosaloves.bitlyj.Bitly.shorten;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.rosaloves.bitlyj.BitlyShortener;
import com.rosaloves.bitlyj.Url;

/**
 * Factory
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class FactoryTest {
	
	BitlyShortener bitly = as("bitlyapidemo", "R_0da49e0a9118ff35f52f629d2d71bf07");
	
	@Test
	public void testShorten() {
		Url url = bitly.call(shorten("http://www.scotster.com/qf/?1152"));
		assertEquals("lLWr", url.getGlobalHash());
		assertEquals("http://www.scotster.com/qf/?1152", url.getLongUrl());
		
	}
	
	@Test
	public void testExpand() {
		Set<Url> urls = bitly.call(expand("j3"));
		assertTrue(urls.size() == 1);
		
		Url url = urls.iterator().next();
		assertEquals("lLWr", url.getGlobalHash());
		assertEquals("j3", url.getHash());
		assertEquals("http://www.scotster.com/qf/?1152", url.getLongUrl());
		
	}
	
	@Test
	public void testInfo() {
		Url url = bitly.call(info("j3")).iterator().next().getUrl();
		assertEquals("lLWr", url.getGlobalHash());
		assertEquals("j3", url.getHash());
	}
	
}
