package com.swapnixi.feedbackhub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FeedbackhubApplicationTests {

	Logger logger = LoggerFactory.getLogger(FeedbackhubApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("Test is Executed...!");
		assertEquals(true, true);
	}

}
