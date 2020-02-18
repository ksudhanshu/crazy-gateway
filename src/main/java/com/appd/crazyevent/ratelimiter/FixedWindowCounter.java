/**
 * 
 */
package com.appd.crazyevent.ratelimiter;

import java.time.Instant;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kumar
 *
 */
public class FixedWindowCounter extends RateLimiter {

	private final ConcurrentMap<Long, AtomicInteger> windows = new ConcurrentHashMap<>();

	public FixedWindowCounter(int maxRequestPerSec) {
		super(maxRequestPerSec);
	}

	@Override
	boolean allow() {
		long windowKey = Calendar.getInstance().get(Calendar.MINUTE);
		windows.putIfAbsent(windowKey, new AtomicInteger(0));
		return windows.get(windowKey).incrementAndGet() <= maxRequestPerMin;
	}
}