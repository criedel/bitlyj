package com.rosaloves.net.shorturl.bitly;

import java.io.IOException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.rosaloves.net.shorturl.bitly.auth.InlineAuthentication;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlInfo;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlStats;

/**
 * BitlyImplTest
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 24, 2009)
 */
public class BitlyImplTest {
	
	public static final String HT_LONG_URL = "http://rosaloves.com/stories/view/13";
	
	public static final String HT_SHORT_NAME = "hopetransfusion";
	
	public static final String HT_HASH = "fB05";
	
	private IBitly bitly;
	
	@BeforeSuite
	public void setUp() {
		bitly  = new BitlyImpl(new InlineAuthentication(
			"bitlyapidemo", "R_0da49e0a9118ff35f52f629d2d71bf07"));
	}
	
	@Test
	public void testExpand() throws IOException {
		URL url = bitly.expandHash(HT_SHORT_NAME);
		Assert.assertEquals(HT_LONG_URL, url.toString());
	}
	
	@Test
	public void testInfo() throws IOException {
		BitlyUrlInfo info = bitly.info(HT_SHORT_NAME);
		Assert.assertEquals(HT_HASH, info.getBitlyUrl().getHash());
		Assert.assertEquals(HT_LONG_URL, info.getUrl().toString());
	}
	
	@Test
	public void testStats() throws IOException {
		BitlyUrlStats stats = bitly.stats(HT_HASH);
		Assert.assertTrue(stats.getTotalClicks() > 0, String.format(
			"Expected > 0 clicks for hash: %s!", HT_HASH));
	}
	
}