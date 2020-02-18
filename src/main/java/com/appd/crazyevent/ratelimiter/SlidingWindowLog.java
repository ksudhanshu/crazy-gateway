/**
 * 
 */
package com.appd.crazyevent.ratelimiter;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kumar
 *
 */
public class SlidingWindowLog extends RateLimiter {

	private final Queue<Long> log = new LinkedList<>();

	  public SlidingWindowLog(int maxRequestPerHour) {
	    super(maxRequestPerHour);
	  }

	  @Override
	  boolean allow() {
	    long curTime = (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) * 60) + Calendar.getInstance().get(Calendar.MINUTE);;
	    long boundary = curTime - 60;
	    synchronized (log) {
	      while (!log.isEmpty() && log.element() <= boundary) {
	        log.poll();
	      }
	      log.add(curTime);
	      return log.size() <= maxRequestPerMin;
	    }
	  }
	}