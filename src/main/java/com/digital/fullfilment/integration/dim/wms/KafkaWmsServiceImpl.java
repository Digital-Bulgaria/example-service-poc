package com.digital.fullfilment.integration.dim.wms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaWmsServiceImpl implements KafkaWmsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(id = "foo", topics = "topic1", group = "group1")
	public void onKafkaMessage(@Payload String message) {
		logger.info("Received Kafka Message: {}", message);
	}

	public void sendKafkaMessage(String message) {
		logger.info("Sending Kafka Message: {}", message);

		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic1", "testKeys", message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			public void onSuccess(SendResult<String, String> result) {
				logger.info("Successully sent to Kafka topic");
			}

			public void onFailure(Throwable ex) {
				logger.error("Failed to send to Kafka topic", ex);
			}
		});
	}

}