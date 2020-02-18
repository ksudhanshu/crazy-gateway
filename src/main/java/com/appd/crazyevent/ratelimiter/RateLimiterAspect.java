package com.appd.crazyevent.ratelimiter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appd.crazyevent.exception.TooManyRequestException;

/**
 * Aspect for rateLimiting execution of service and repository Spring
 * components.
 */
@Aspect
public class RateLimiterAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private FixedWindowCounter fixedWindowCounter = null;
	private SlidingWindowLog slidingWindowLog = null;

	public RateLimiterAspect(FixedWindowCounter fixedWindowCounter, SlidingWindowLog slidingWindowLog) {
		this.fixedWindowCounter = fixedWindowCounter;
		this.slidingWindowLog = slidingWindowLog;
	}

	/**
	 * Pointcut that matches all Spring beans in the application's main packages.
	 * #TODO In future we can apply to rest controller and gRPC Controller instead
	 * of applying on service.
	 */
	@Pointcut("within(com.appd.crazyevent.service.EventService)")
	public void rateLimitingPointcut() {
		// Method is empty as this is just a Pointcut, the implementations are in the
		// advices.
	}

	/**
	 * Advice that rateLimit when a method is entered and exited.
	 *
	 * @param joinPoint join point for advice.
	 * @return result.
	 * @throws Throwable throws {@link IllegalArgumentException}.
	 */
	@Around("rateLimitingPointcut()")
	public Object rateLimitAround(ProceedingJoinPoint joinPoint) throws Throwable {
		if (fixedWindowCounter.allow() && slidingWindowLog.allow()) {
			return joinPoint.proceed();
		} else {
			log.debug("Exit: {}.{}() with Too many request.", joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName());
			throw new TooManyRequestException("To Many Request");

		}
	}
}
