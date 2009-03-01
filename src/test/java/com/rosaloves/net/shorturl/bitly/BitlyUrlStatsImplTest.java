package com.rosaloves.net.shorturl.bitly;

import org.testng.annotations.Test;

import com.rosaloves.net.shorturl.bitly.url.BitlyUrlStats;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlStatsImpl;

/**
 * Test the default implementation of BitlyUrlStats.
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 27, 2009)
 */
public class BitlyUrlStatsImplTest {
	
	@Test
	public void testTotalClicks() {
		BitlyUrlStats stats = new BitlyUrlStatsImpl(2);
		
		assert stats.getTotalClicks() == 2;
	}
	
}