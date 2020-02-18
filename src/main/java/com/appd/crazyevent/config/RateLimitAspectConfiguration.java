package com.appd.crazyevent.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.appd.crazyevent.ratelimiter.FixedWindowCounter;
import com.appd.crazyevent.ratelimiter.RateLimiterAspect;
import com.appd.crazyevent.ratelimiter.SlidingWindowLog;

@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = true)
@EnableAspectJAutoProxy
public class RateLimitAspectConfiguration {
	
	private int requestPerMin;
	private int requestPerHour;
	
	private FixedWindowCounter fixedWindowCounter = null;
	private SlidingWindowLog slidingWindowLog = null;


	public int getRequestPerMin() {
		return requestPerMin;
	}

	public void setRequestPerMin(int requestPerMin) {
		this.requestPerMin = requestPerMin;
	}

	public int getRequestPerHour() {
		return requestPerHour;
	}

	public void setRequestPerHour(int requestPerHour) {
		this.requestPerHour = requestPerHour;
	}

	@Bean
	public FixedWindowCounter fixedWindowCounter() {
		fixedWindowCounter = new FixedWindowCounter(requestPerMin);
		return fixedWindowCounter;
	}
	
	@Bean
	public SlidingWindowLog slidingWindowLog() {
		slidingWindowLog = new SlidingWindowLog(requestPerHour);
		return slidingWindowLog;
	}
	
    @Bean
    public RateLimiterAspect rateLimitAspect() {
    	return new RateLimiterAspect(fixedWindowCounter, slidingWindowLog);
    }
}
