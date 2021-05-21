package com.flicklist.unittests.controllertests;


import com.flicklist.controller.ReviewController;
import com.flicklist.controller.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerCreationTests {
    @Autowired
    private UserController userController;

    @Autowired
    private ReviewController reviewController;

    @Test
    private void testCreation() throws Exception{
        Assertions.assertNotNull(userController);
        Assertions.assertNotNull(reviewController);
    }
}
