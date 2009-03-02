package com.rosaloves.net.shorturl.bitly;

import org.testng.annotations.Test;

import com.rosaloves.net.shorturl.bitly.url.BitlyUrl;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlImpl;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlInfo;
import com.rosaloves.net.shorturl.bitly.url.BitlyUrlInfoImpl;

/**
 * Test the default implementation of BitlyUrlInfo.
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 24, 2009)
 */
public class BitlyUrlInfoImplTest {
	
	@Test
	public void testBitlyUrl() {
		BitlyUrl url = new BitlyUrlImpl("1234", "4321", "http://rosaloves.com/");
		BitlyUrlInfo info = new BitlyUrlInfoImpl(url);
		
		assert info.getBitlyUrl().getHash().equals("1234");
		assert info.getBitlyUrl().getLongUrl().toString().equals("http://rosaloves.com/");
	}
	
}