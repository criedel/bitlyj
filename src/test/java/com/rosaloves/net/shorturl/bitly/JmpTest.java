package com.rosaloves.net.shorturl.bitly;

import java.io.IOException;
import java.net.URL;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.rosaloves.net.shorturl.bitly.url.BitlyUrlInfo;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlStats;

/**
 * JmpTest
 * 
 * $Id$
 * 
 * @author clewis Oct 6, 2009
 *
 */
public class JmpTest {
	
	public static final String FFTP_HASH = "liFDO";
	
	public static final String FFTP_URL = "http://rosaloves.com/stories/foodforthepanti";
	
	private Bitly jmp;
	
	@BeforeSuite
	public void setUp() {
		jmp = BitlyFactory.newInstance("bitlyapidemo",
			"R_0da49e0a9118ff35f52f629d2d71bf07");
	}
	
	@Test
	public void testExpand() throws IOException {
		URL url = jmp.expandHash(FFTP_HASH);
		assertEquals(FFTP_URL, url.toString());
	}
	
	@Test
	public void testInfo() throws IOException {
		BitlyUrlInfo info = jmp.info(FFTP_HASH);
		assertEquals(FFTP_HASH, info.getBitlyUrl().getHash());
		assertEquals(FFTP_URL, info.getUrl().toString());
	}
	
	@Test
	public void testStats() throws IOException {
		BitlyUrlStats stats = jmp.stats(FFTP_HASH);
		assertTrue(stats.getTotalClicks() > 0, String.format(
			"Expected > 0 clicks for hash: %s!", FFTP_HASH));
	}
	
}
