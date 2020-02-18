/**
 * 
 */
package com.appd.crazyevent.exception;

/**
 * @author kumar
 *
 */
public class TooManyRequestException extends RuntimeException {

	public TooManyRequestException() {
		super();

	}

	public TooManyRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public TooManyRequestException(String message, Throwable cause) {
		super(message, cause);

	}

	public TooManyRequestException(String message) {
		super(message);

	}

	public TooManyRequestException(Throwable cause) {
		super(cause);

	}

}
