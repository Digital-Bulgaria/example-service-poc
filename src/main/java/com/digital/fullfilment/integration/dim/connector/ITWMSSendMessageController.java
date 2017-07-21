package com.digital.fullfilment.integration.dim.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * TODO move to IntegrationTests. Here is only to produce test messages.
 * @author georgi_terziev
 *
 */
@RestController
@RequestMapping("/jms")
public class ITWMSSendMessageController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private JmsTemplate jmsTemplate;

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@PostMapping("/send")
	public void send(@RequestBody String message) {
		logger.info("sending it message [{}]", message);
		// Post message to the message queue named "jmsOutQueue"
		jmsTemplate.convertAndSend("jmsInQueue", message);
	}
}