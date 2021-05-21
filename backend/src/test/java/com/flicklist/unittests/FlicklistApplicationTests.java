
package com.flicklist.unittests;


import com.flicklist.controller.ReviewController;
import com.flicklist.controller.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FlicklistApplicationTests {

	@Autowired
	private UserController userController;

	@Autowired
	private ReviewController reviewController;

	@Test
	void contextLoads() {
	}

	@Test
	private void testCreation() throws Exception{
		Assertions.assertNotNull(userController);
		Assertions.assertNotNull(reviewController);
	}
}
