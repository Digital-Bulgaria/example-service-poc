package com.digital.fullfilment.integration.dim;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.digital.fullfilment.integration.dim.wms.WMSService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
@ActiveProfiles(profiles = "test")
public class WMSReceiveTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired(required = false)
	private JmsTemplate jmsTemplate;

	@Autowired
	private WMSService wmsService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/* ... tests */

	@Test
	public void testSendCreateBookMessage() {
		// send message
		logger.info("sending a test message");
		jmsTemplate.convertAndSend("jmsInQueue", "test message");

		// verify
		// verify(wmsService on message called
	}
}