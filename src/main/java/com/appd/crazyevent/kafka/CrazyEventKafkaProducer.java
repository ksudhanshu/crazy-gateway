package com.appd.crazyevent.kafka;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.appd.crazyevent.config.KafkaProperties;
import com.appd.crazyevent.domain.Event;

@Service
public class CrazyEventKafkaProducer {
	private final Logger log = LoggerFactory.getLogger(CrazyEventKafkaProducer.class);

	private final KafkaProperties kafkaProperties;
	private KafkaProducer<String, String> producer;
	private ExecutorService sseExecutorService = Executors.newCachedThreadPool();

	public CrazyEventKafkaProducer(KafkaProperties kafkaProperties) {
		this.kafkaProperties = kafkaProperties;
		this.producer = new KafkaProducer<>(kafkaProperties.getProducerProps());
	}

	public void publish(String topic, String event) throws ExecutionException, InterruptedException {
		log.debug("Event send to Kafka topic {} with the message : {}", topic, event.toString());
		RecordMetadata metadata = producer.send(new ProducerRecord<>(topic, event)).get();
	}

}
