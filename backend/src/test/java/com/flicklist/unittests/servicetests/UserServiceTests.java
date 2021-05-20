package com.flicklist.unittests.servicetests;

import com.flicklist.service.user.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTests {
	UserService userService;
	@BeforeClass
	public static void init(){
	}

	@Before
	public void shouldRunBeforeEachTest(){
		userService = new UserService();
	}


	@Test
	public void shouldFindAll(){

	}
}
