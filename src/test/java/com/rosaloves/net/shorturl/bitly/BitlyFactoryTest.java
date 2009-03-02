package com.rosaloves.net.shorturl.bitly;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * BitlyFactoryTest. Not much to test at the moment.
 *
 * $Id$
 *
 * @author Chris Lewis (Mar 1, 2009)
 */
public class BitlyFactoryTest {
	
	@Test
	public void testNewInstance() {
		Bitly bitly = BitlyFactory.newInstance("bitlyapidemo",
			"R_0da49e0a9118ff35f52f629d2d71bf07");
		Assert.assertNotNull(bitly); //wow
	}
	
}