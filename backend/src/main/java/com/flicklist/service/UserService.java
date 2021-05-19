package com.flicklist.service;

import com.flicklist.model.UserModel;

import java.util.List;

public interface UserService {

	UserModel findOneByUsernameAndPassword(String username, String password);

	UserModel save(UserModel userModel);

	List<UserModel> findAll();

	UserModel update( UserModel userModel);

	void delete(String id);
}
