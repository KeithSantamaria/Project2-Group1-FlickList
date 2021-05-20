package com.flicklist.unittests.servicetests;

import com.flicklist.model.User;
import com.flicklist.repository.UserRepository;
import com.flicklist.service.user.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTests {
	User testUser;
	private final UserRepository userRepository = Mockito.mock(UserRepository.class);
	UserService userService = new UserService(userRepository);

	@Test void shouldFindByUserNameAndPassword(){
		String username = "correctUser";
		String password ="123";
		testUser = new User();
		testUser.setUsername(username);
		testUser.setPassword(password);
		List<User> users = new ArrayList<>();
		users.add(testUser);
		Mockito.when(userRepository.findByUsernameAndPassword(username, password)).thenReturn(users);
		User createdUser =  userService.findByUsernameAndPassword(username,password);
		Assert.assertEquals("User did not match.",createdUser , testUser);
	}

	@Test
	public void shouldNotFindByUserNameAndPassword(){
		String username = "wrongUser";
		String password ="123";
		List<User> users = new ArrayList<>();
		Mockito.when(userRepository.findByUsernameAndPassword(username, password)).thenReturn(users);
		User createdUser =  userService.findByUsernameAndPassword(username,password);
		Assert.assertNull("Log in should have failed.", createdUser);
	}

	@Test
	public void shouldFindAll(){
		List<User> userList= new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		userList.add(new User());

		Mockito.when(userRepository.findAll()).thenReturn(userList);
		List<User> testUsers = userService.findAll();
		int expectedCount = 3;
		Assert.assertEquals("Expected to fetch 3 users", expectedCount, testUsers.size());
	}

	@Test
	public void shouldCreateAUser(){
		testUser = new User();
		Mockito.when(userRepository.save(testUser)).thenReturn(testUser);
		User createdUser = userService.create(testUser);
		Assert.assertEquals("Expected equal Users", testUser, createdUser);
	}

	@Test
	public void shouldFailToCreateUser(){
		testUser = new User();
		testUser.setId("testId");
		Mockito.when(userRepository.save(testUser)).thenReturn(testUser);
		User createdUser = userService.create(testUser);
		Assert.assertNotEquals("Should have detected that user already exists", testUser, createdUser);
	}

	@Test
	public void shouldFailUpdateUser(){
		testUser = new User();
		Mockito.when(userRepository.save(testUser)).thenReturn(null);
		User createdUser = userService.update(testUser);
		Assert.assertEquals("Should be null", null , createdUser);
	}

	@Test
	public void shouldUpdateUser(){
		testUser = new User();
		testUser.setId("testId");
		testUser.setPassword("123123");
		User changedUser = new User();
		changedUser.setId("testId");
		changedUser.setPassword("123456");
		Mockito.when(userRepository.save(testUser)).thenReturn(changedUser);
		User createdUser = userService.update(testUser);
		boolean isCorrectParams = true;
		if ( !createdUser.getId().equals(testUser.getId()) ){
			isCorrectParams = false;
		}
		if( !changedUser.getPassword().equals("123456")){
			isCorrectParams = false;
		}
		Assert.assertEquals("Should have update", true, isCorrectParams);
	}

	@Test
	public void shouldDelete(){
		long testSize = 3;
		String id = "test";
		User testUser = new User();
		testUser.setId(id);
		Mockito.when(userRepository.removeById(id)).thenReturn(testSize -1);
		long newSizeAfterDelete = userService.delete(testUser);
		Assert.assertEquals("Should have been one less document", 2, newSizeAfterDelete);
	}

	@Test
	public void shouldFindUserById(){
		User testUser = new User();
		testUser.setId("60a53ecb08b0404363e43845");
		Mockito.when(userRepository.findById(testUser.getId())).thenReturn(java.util.Optional.of(testUser));
		User createdUser = userService.findById(testUser.getId());
		Assert.assertEquals("Should be the same user", testUser, createdUser);
	}
}
