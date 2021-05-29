package com.flicklist.controller;

import com.flicklist.model.User;
import com.flicklist.service.user.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName ReviewController
 *
 * @Purpose The following class is used to handle all requests concerning reviews. Each end point will be clarified below
 */

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping ("/users")
public class UserController {
	@Autowired
	private IUserService userService;


	/**
	 * @FunctionName login
	 * @param request : contains the username and password of a user
	 * @return if request is valid it will return the user with the same username and password fields. Otherwise returns
	 * null
	 */
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User request) {
		User userFound = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
		log.info("login attempted");
		if(userFound != null){
			log.info("user found: " + userFound);
		}
		else{
			log.info("user not found!");
		}

		return userFound == null
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(userFound);

	}

	/**
	 * @FunctionName findByUserId
	 * @param id : the unique id associated with a particular user
	 * @return returns the response object that contains a single user associated with the unique id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> findByUserId(@PathVariable String id) {
		User userFound = userService.findById(id);
		return userFound == null
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(userFound);
	}

	/**
	 * @FunctionName findAll
	 * @return returns the response object that contains all users
	 */
	@GetMapping()
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	/**
	 * @FunctionName create
	 * @param request : should contain all of the valid info to create a user
	 * @return returns the newly created user
	 */
	@PostMapping()
	public ResponseEntity<User> create(@Valid @RequestBody User request) {
		User userCreated = userService.create(request);
		log.info("attempting to create user");
		log.info("user created: " + userCreated);
		return userCreated == null
				? ResponseEntity.badRequest().build()
				: ResponseEntity.ok(userCreated);
	}

	/**
	 * @FunctionName update
	 * @param request : should contain an object that is a valid user
	 * @return returns the response object that contains the newly user
	 */
	@PutMapping()
	public ResponseEntity<User> update(@Valid @RequestBody User request) {
		User userUpdated = userService.update(request);
		log.info("attempting to update user");
		log.info("user updated: " + userUpdated);
		return userUpdated == null
				? ResponseEntity.badRequest().build()
				: ResponseEntity.ok(userUpdated);
	}

	/**
	 * @FunctionName delete
	 * @param request : should contain an object that is a valid user
	 * @return returns a confirmation
	 */
	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestBody User request) {
		long deleteCount = userService.delete(request);
		log.info("attempting to delete user");
		log.info("users deleted: " + deleteCount);
		return deleteCount == 0
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok("\"deletedCount\":\"" + deleteCount + "\"");
	}
}


//@RequestParam does it like this http://localhost:8080/delete?id=60a46bd2bad8d9537d0367b7
//@RequestBody does it as JSON