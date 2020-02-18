package com.appd.crazyevent.service;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appd.crazyevent.domain.Event;
import com.appd.crazyevent.kafka.CrazyEventKafkaProducer;

/**
 * @author kumar
 *
 */
@Service
public class EventService {

	private final Logger log = LoggerFactory.getLogger(EventService.class);

	@Autowired
	private CrazyEventKafkaProducer crazyEventKafkaProducer;
	/**
	 * This method is used to add the event to sync.
	 * @param event
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	public void addEvent(Event event) throws ExecutionException, InterruptedException {
		log.debug("Received message {}", event);
		crazyEventKafkaProducer.publish(event.getEventType().name(), event.toString());
	}
}
