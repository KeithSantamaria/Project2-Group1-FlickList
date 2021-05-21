package com.flicklist.unittests.servicetests;

import com.flicklist.model.User;
import com.flicklist.repository.UserRepository;
import com.flicklist.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.util.AssertionErrors.*;
public class UserServiceTests {
	User testUser;
	List<User> users;
	private final UserRepository userRepository = Mockito.mock(UserRepository.class);
	UserService userService = new UserService(userRepository);

	@BeforeEach
	void  shouldRunBeforeEach(){
		testUser = new User();
		users= new ArrayList<>();
	}

	@Test
	void shouldFindByUserNameAndPassword(){
		String username = "correctUser";
		String password ="123";
		testUser.setUsername(username);
		testUser.setPassword(password);
		List<User> users = new ArrayList<>();
		users.add(testUser);
		Mockito.when(userRepository.findByUsernameAndPassword(username, password)).thenReturn(testUser);
		User createdUser =  userService.findByUsernameAndPassword(username,password);
		assertEquals("User did not match.",createdUser , testUser);
	}

	@Test
	public void shouldNotFindByUserNameAndPassword(){
		String username = "wrongUser";
		String password ="123";
		Mockito.when(userRepository.findByUsernameAndPassword(username, password)).thenReturn(null);
		User createdUser =  userService.findByUsernameAndPassword(username,password);
		assertNull("Log in should have failed.", createdUser);
	}

	@Test
	public void shouldFindAll(){
		users.add(new User());
		users.add(new User());
		users.add(new User());

		Mockito.when(userRepository.findAll()).thenReturn(users);
		List<User> testUsers = userService.findAll();
		int expectedCount = 3;
		assertEquals("Expected to fetch 3 users", expectedCount, testUsers.size());
	}

	@Test
	public void shouldCreateAUser(){
		Mockito.when(userRepository.save(testUser)).thenReturn(testUser);
		User createdUser = userService.create(testUser);
		assertEquals("Expected equal Users", testUser, createdUser);
	}

	@Test
	public void shouldFailToCreateUser(){
		testUser.setId("testId");
		Mockito.when(userRepository.save(testUser)).thenReturn(testUser);
		User createdUser = userService.create(testUser);
		assertNotEquals("Should have detected that user already exists", testUser, createdUser);
	}

	@Test
	public void shouldFailToUpdateUser(){
		Mockito.when(userRepository.save(testUser)).thenReturn(null);
		User createdUser = userService.update(testUser);
		assertNull("Should be null",createdUser);
	}

	@Test
	public void shouldUpdateUser(){
		testUser.setId("testId");
		testUser.setUsername("Keith");
		testUser.setPassword("123123");
		testUser.setFirstName("Keith");
		testUser.setLastName("Santamaria");
		testUser.setEmail("keith.santamaria@revature.net");

		User changedUser = testUser;
		changedUser.setPassword("123456");
		Mockito.when(userRepository.save(testUser)).thenReturn(changedUser);
		User createdUser = userService.update(testUser);
		boolean isCorrectParams = createdUser.getId().equals("testId");
		//we are doing to following solely get
		if( !changedUser.getUsername().equals("Keith")){
			isCorrectParams = false;
		}
		if( !changedUser.getPassword().equals("123456")){
			isCorrectParams = false;
		}
		if( !changedUser.getFirstName().equals("Keith")){
			isCorrectParams = false;
		}
		if( !changedUser.getLastName().equals("Santamaria")){
			isCorrectParams = false;
		}
		if ( !changedUser.getEmail().equals("keith.santamaria@revature.net")){
			isCorrectParams = false;
		}

		assertTrue("Should have update",isCorrectParams);
	}

	@Test
	public void shouldDelete(){
		long testSize = 3;
		String id = "test";
		testUser.setId(id);
		Mockito.when(userRepository.removeById(id)).thenReturn(testSize -1);
		long newSizeAfterDelete = userService.delete(testUser);
		assertEquals("Should have been one less document", (long)2, newSizeAfterDelete);
	}

	@Test
	public void shouldFindUserById(){
		testUser.setId("60a53ecb08b0404363e43845");
		Mockito.when(userRepository.findById(testUser.getId())).thenReturn(java.util.Optional.of(testUser));
		User createdUser = userService.findById(testUser.getId());
		assertEquals("Should be the same user", testUser, createdUser);
	}
}
