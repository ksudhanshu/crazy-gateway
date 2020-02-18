/**
 * 
 */
package com.appd.crazyevent.web.rest;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appd.crazyevent.domain.Event;
import com.appd.crazyevent.service.EventService;

/**
 * @author kumar
 *
 */
@RestController
@RequestMapping("/api/crazy-gateway")
public class CrazyGatewayController {
	@Autowired
	private EventService eventService;

	private final Logger log = LoggerFactory.getLogger(CrazyGatewayController.class);

	@PostMapping(path = "/event", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> event(@RequestBody Event event) throws ExecutionException, InterruptedException {
		log.debug("Received Rest message {}", event);
		eventService.addEvent(event);
		return ResponseEntity.ok(null);
	}

}
