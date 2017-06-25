package com.slowe.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("test")
	public String testLogLevel() {
		LOGGER.debug("Logger Level: DEBUG");
		LOGGER.info("Logger Level: INFO");
		LOGGER.error("Logger Levle: ERROR");
		return "";
	}
}
