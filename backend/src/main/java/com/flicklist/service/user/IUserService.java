package com.flicklist.service.user;

import com.flicklist.model.User;

import java.util.List;

public interface IUserService {

	User findOneByUsernameAndPassword(String username, String password);

	User create(User user);

	List<User> findAll();

	User update(User user);

	void delete(String id);
}
