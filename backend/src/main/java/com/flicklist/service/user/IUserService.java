package com.flicklist.service.user;

import com.flicklist.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {


	List<User> findAll();
	User findById(String id);
	User findByUsernameAndPassword(String username, String password);
	User create(User user);
	User update(User user);
	long delete(User user);
}
