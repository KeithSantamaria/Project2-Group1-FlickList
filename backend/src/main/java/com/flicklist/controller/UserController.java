package com.flicklist.controller;

import com.flicklist.model.User;
import com.flicklist.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping("/login")
	public ResponseEntity<User> login(@RequestBody User request){
		return ResponseEntity.ok( userService.findOneByUsernameAndPassword(request.getUsername(), request.getPassword()));
	}

	@GetMapping()
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	@PostMapping()
	public ResponseEntity<User> create(@RequestBody User request){
		return ResponseEntity.ok(userService.create(request));
	}

	@PutMapping()
	public ResponseEntity<User> update(@RequestBody User request){
		return ResponseEntity.ok(userService.update(request));
	}

	@DeleteMapping()
	public void delete(@RequestBody User request){
		//TODO do something to confirm delete
		userService.delete(request.getId());
	}
}

//@RequestParam does it like this http://localhost:8080/delete?id=60a46bd2bad8d9537d0367b7
//@RequestBody does it as JSON