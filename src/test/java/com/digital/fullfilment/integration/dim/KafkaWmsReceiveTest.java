package com.digital.fullfilment.integration.dim;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.digital.fullfilment.integration.dim.wms.KafkaWmsService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
//@ActiveProfiles(profiles = "test")
public class KafkaWmsReceiveTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KafkaWmsService kafkaWmsServiceImpl;

//	@Test
	public void testSendToKafkaTopic() {
		kafkaWmsServiceImpl.sendKafkaMessage("JUnit Test Message");
	}

}
