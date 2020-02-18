package com.appd.crazyevent.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to Crazy Gateway.
 * <p>
 * Properties are configured in the {@code application.yml} file. See
 * {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
	private int requestPerMin;
	private int requestPerHour;

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

}
