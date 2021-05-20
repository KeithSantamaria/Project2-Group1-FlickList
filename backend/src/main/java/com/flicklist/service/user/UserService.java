package com.flicklist.service.user;

import com.flicklist.model.User;
import com.flicklist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findOneByUsernameAndPassword(String username, String password) {
		//TODO make sure username is unique
		return userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User update(User user) {
		//checking if exists
		userRepository.findById(user.getId()).orElse(null);
		return userRepository.save(user);
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);
	}
}
