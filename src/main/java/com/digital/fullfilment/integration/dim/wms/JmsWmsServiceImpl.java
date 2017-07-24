package com.digital.fullfilment.integration.dim.wms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsWmsServiceImpl implements JmsWmsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private JmsTemplate jmsTemplate;

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@JmsListener(destination = "jmsInQueue" )
	public void onWMSMessage(String message) {
		logger.info("Received [{}]",  message);
	}

	public void sendWMSMessage(String message) {
		logger.info("sendWMSMessage {}", message);
		jmsTemplate.convertAndSend("jmsOutQueue", message);
	}

}

