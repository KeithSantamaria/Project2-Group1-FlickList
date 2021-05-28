package com.flicklist.service.user;

import com.flicklist.model.User;
import com.flicklist.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 *
 * @Purpose The following class is used to communicate with the tmdb api
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * @FunctionName findByUsernameAndPassword
	 * @param username : the input for the username
	 * @param password : the input for the password
	 * @return searches for a user with the credentials
	 */
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		//TODO make sure username is unique
		return userRepository.findByUsernameAndPassword(username,password);

	}

	/**
	 * @FunctionName findAll
	 *
	 * @return returns all users in the database
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * @FunctionName findById
	 * @param id : unique id for user
	 *
	 * @return returns a user with the id
	 */
	@Override
	public User findById(String id) {
		return userRepository.findById(id).orElse(null);
	}

	/**
	 * @FunctionName create
	 * @param user: should be a valid user
	 * @return writes a new user to the db
	 */
	@Override
	public User create(User user) {
		if (user.getId() == null) {
			try{
				return userRepository.save(user);
			}catch(Exception exception){
				//Exception when  username or email already exists
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * @FunctionName update
	 * @param user: should be a valid user
	 * @return updates the user to the db
	 */
	@Override
	public User update(User user){
		if(user.getId() == null){
			return null;
		}else{
			try{
				return userRepository.save(user);
			}catch(Exception exception){
				//Exception when  username or email already exists
				return null;
			}
		}
	}

	/**
	 * @FunctionName delete
	 * @param user: should be a valid user
	 * @return deletes the user from the db
	 */
	@Override
	public long delete(User user) {
		return userRepository.removeById(user.getId());
	}
}
