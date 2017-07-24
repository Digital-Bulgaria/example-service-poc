package com.digital.fullfilment.integration.dim.wms;

import org.springframework.stereotype.Service;

@Service
public interface JmsWmsService {

	void onWMSMessage(String message);

	void sendWMSMessage(String message);

}
