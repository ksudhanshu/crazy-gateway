package com.appd.crazyevent.domain;

import java.time.ZonedDateTime;

/**
 * @author kumar
 *
 */
public class Event {

	public enum EventType {
		EventType1, EventType2, EventType3, EventType4
	}

	private EventType eventType;
	private long eventId;
	private ZonedDateTime eventTime;
	private String source;
	private String data;

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public ZonedDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(ZonedDateTime eventTime) {
		this.eventTime = eventTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Event [eventType=" + eventType + ", eventId=" + eventId + ", eventTime=" + eventTime + ", source="
				+ source + ", data=" + data + "]";
	}

}
