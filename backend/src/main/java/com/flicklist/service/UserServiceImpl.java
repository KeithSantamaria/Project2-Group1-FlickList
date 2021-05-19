package com.flicklist.service;

import com.flicklist.model.UserModel;
import com.flicklist.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;

	@Override
	public UserModel save(UserModel userModel) {
		return userRepository.save(userModel);
	}

	@Override
	public List<UserModel> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserModel update(UserModel userModel) {
		//checking if exists
		userRepository.findById(userModel.getId()).orElseThrow(
			() -> new IllegalArgumentException("Model does not exist")
		);
		return userRepository.save(userModel);
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);
	}
}
