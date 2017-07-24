package com.digital.fullfilment.integration.dim.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.fullfilment.integration.dim.wms.KafkaWmsService;

/**
 * 
 * TODO
 * 
 * @author daniel_dimitrov
 *
 */
@RestController
@RequestMapping("/kafka")
public class ItWmsSendKafkaMessageController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private KafkaWmsService kafkaWmsServiceImpl;

	@PostMapping("/send")
	public void send(@RequestBody String message) {
		kafkaWmsServiceImpl.sendKafkaMessage(message);
	}
}