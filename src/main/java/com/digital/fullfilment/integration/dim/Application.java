package com.digital.fullfilment.integration.dim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

/**
 * 
 * 
 * @author georgi_terziev
 */
@ComponentScan(basePackages = "com.digital.fullfilment.integration.dim")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}