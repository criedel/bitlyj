package com.rosaloves.bitlyj;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Factory
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class InfoMethod {
	
	@Test
	public void infoMethodName() {
		Assert.assertEquals("info", Bitly.info("somehash").getName());
	}

	@Test
	public void infoMethodWithSingleHashArgument() {
		BitlyMethod<Set<Info>> info = Bitly.info("abc");
		Assert.assertTrue(info.getParameters().size() == 1);
		Assert.assertEquals("abc", info.getParameters().get("hash"));
	}
	
	@Test
	public void infoMethodWithSingleUrlArgument() {
		BitlyMethod<Set<Info>> info = Bitly.info("http://shortened.com");
		Assert.assertTrue(info.getParameters().size() == 1);
		Assert.assertEquals("http://shortened.com", info.getParameters().get("shortUrl"));
	}
	
}
