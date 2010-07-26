package com.rosaloves.bitlyj;

import org.junit.Assert;
import org.junit.Test;

/**
 * UrlTest
 * 
 * $Id$
 * 
 * @author clewis Jul 26, 2010
 *
 */
public class UrlTest {
	
	private Url url = new Url("http://nonsen.se", "global", "user", "http://foo.ly/user", "http://longdomain.com/long/path/");
	
	@Test
	public void expectedUserHash() {
		Assert.assertEquals("user", url.getUserHash());
	}
	
	@Test
	public void expectedShortUrl() {
		Assert.assertEquals("http://foo.ly/user", url.getShortUrl());
	}
	
	@Test
	public void resolvedShortUrl() {
		url = new Url("http://foo.ly/", "global", "user", "", "http://longdomain.com/long/path/");
		Assert.assertEquals("http://foo.ly/user", url.getShortUrl());
	}

}
