package com.flicklist.service.user;

import com.flicklist.model.User;

import java.util.List;

public interface IUserService {


	List<User> findAll();
	User findById(String id);
	User findByUsernameAndPassword(String username, String password);
	User create(User user);
	User update(User user);
	void delete(String id);
}
