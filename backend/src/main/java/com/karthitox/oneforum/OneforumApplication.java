package com.karthitox.oneforum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneforumApplication {

	private static final Logger log = LoggerFactory.getLogger(OneforumApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OneforumApplication.class, args);
		log.debug("testd");
	}

}
