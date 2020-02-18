/**
 * 
 */
package com.appd.crazyevent.ratelimiter;

/**
 * @author kumar
 *
 */
public abstract class RateLimiter {

	/**
	 * Max Request per Min
	 */
	protected final int maxRequestPerMin;

	protected RateLimiter(int maxRequestPerMin) {
		this.maxRequestPerMin = maxRequestPerMin;
	}

	abstract boolean allow();
}
