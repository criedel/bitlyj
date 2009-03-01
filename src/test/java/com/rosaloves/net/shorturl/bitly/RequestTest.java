package com.rosaloves.net.shorturl.bitly;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * RequestTest
 *
 * $Id$
 *
 * @author Chris Lewis (Feb 25, 2009)
 */
public class RequestTest {
	
	@Test
	public void testAddParameters() {
		Request request = new Request();
		
		try {
			request.addParameters(1, 2);
			request.addParameters(1);
			Assert.fail("1 argument is invalid and should have failed!");
		} catch(IllegalArgumentException iaex) {
			assert true;
		}
		
		try {
			request.addParameters(1, 2);
			request.addParameters(1, 2, 3, 4);
			request.addParameters(1, 2, 3);
			Assert.fail("3 arguments are invalid and should have failed!");
		} catch(IllegalArgumentException iaex) {
			assert true;
		}

	}
	
}