/**
 * 
 */
package com.appd.crazyevent.ratelimiter;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author kumar
 *
 */
public class SlidingWindowLogTest {

	@Test
	public void testAllow() {
		SlidingWindowLog slidingWindowLog = new SlidingWindowLog(5);
		boolean allow = false;;
		for(int i=0; i<=4 ; i++) {
			allow = slidingWindowLog.allow();
		}
		Assert.assertTrue("Allow should be true", allow);
	}

	@Test
	public void testAllowFalse() {
		SlidingWindowLog slidingWindowLog = new SlidingWindowLog(5);
		boolean allow = false;;
		for(int i=0; i<=8 ; i++) {
			allow = slidingWindowLog.allow();
		}
		Assert.assertFalse("Allow should be false", allow);
	}

}
