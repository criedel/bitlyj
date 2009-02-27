package com.rosaloves.net.shorturl.bitly;

import org.testng.annotations.Test;

import com.rosaloves.net.shorturl.bitly.url.BitlyUrl;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlImpl;

/**
 * Test the default implementation of BitlyUrl.
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 24, 2009)
 */
public class BitlyUrlImplTest {
	
	@Test
	public void testHash() {
		BitlyUrl url = new BitlyUrlImpl("1234", "http://rosaloves.com/");
		
		assert url.getHash().equals("1234");
		assert url.getLongUrl().toString().equals("http://rosaloves.com/");
	}
	
}