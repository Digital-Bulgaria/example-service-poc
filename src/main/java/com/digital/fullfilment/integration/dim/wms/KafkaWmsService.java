package com.digital.fullfilment.integration.dim.wms;

import org.springframework.stereotype.Service;

@Service
public interface KafkaWmsService {

	void onKafkaMessage(String message);

	void sendKafkaMessage(String message);

}
