package com.rosaloves.net.shorturl.bitly;

import java.io.IOException;
import java.net.URL;

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
	
	private IBitly bitly;
	
	@BeforeSuite
	public void dook() {
		bitly  = new BitlyImpl(new InlineAuthentication(
			"rosaloves", "TODO"));
	}
	
	@Test
	public void testExpand() throws IOException {
		URL url = bitly.expandHash("hopetransfusion");
		System.out.println("BitlyImplTest.testExpand() -- " + url);
	}
	
	@Test
	public void testInfo() throws IOException {
		BitlyUrlInfo info = bitly.info("hopetransfusion");
		System.out.println("BitlyImplTest.testInfo() -- " + info.getBitlyUrl().getHash());
	}
	
	@Test
	public void testStats() throws IOException {
		BitlyUrlStats stats = bitly.stats("hopetransfusion");
		System.out.println("BitlyImplTest.testStats() -- " + stats.getTotalClicks());
	}
	
}