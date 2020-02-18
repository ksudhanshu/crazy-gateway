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
public class FixedWindowCounterTest {

	/**
	 * Test method for {@link com.appd.crazyevent.ratelimiter.FixedWindowCounter#allow()}.
	 */
	@Test
	public void testAllow() {
		FixedWindowCounter fixedWindowCounter = new FixedWindowCounter(5);
		boolean allow = false;;
		for(int i=0; i<=4 ; i++) {
			allow = fixedWindowCounter.allow();
		}
		Assert.assertTrue("Allow should be true", allow);
	}

	@Test
	public void testAllowFalse() {
		FixedWindowCounter fixedWindowCounter = new FixedWindowCounter(5);
		boolean allow = false;;
		for(int i=0; i<=8 ; i++) {
			allow = fixedWindowCounter.allow();
		}
		Assert.assertFalse("Allow should be false", allow);
	}
	
	@Test
	public void testAllowTrue_After_1Min() throws InterruptedException {
		FixedWindowCounter fixedWindowCounter = new FixedWindowCounter(5);
		boolean allow = false;;
		for(int i=0; i<=8 ; i++) {
			allow = fixedWindowCounter.allow();
			if (i==5) {
				Thread.sleep(60*1000);
			}
		}
		Assert.assertTrue("Allow should be true", allow);
	}
	
}
