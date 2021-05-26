package com.flicklist.controller;

import com.flicklist.model.User;
import com.flicklist.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping ("/users")
public class UserController {
	@Autowired
	private IUserService userService;

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User request) {
		User userFound = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
		return userFound == null
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(userFound);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findByUserId(@PathVariable String id) {
		User userFound = userService.findById(id);
		return userFound == null
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(userFound);
	}

	@GetMapping()
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	@PostMapping()
	public ResponseEntity<User> create(@Valid @RequestBody User request) {
		User userCreated = userService.create(request);
		return userCreated == null
				? ResponseEntity.badRequest().build()
				: ResponseEntity.ok(userCreated);
	}

	@PutMapping()
	public ResponseEntity<User> update(@Valid @RequestBody User request) {
		User userUpdated = userService.update(request);
		return userUpdated == null
				? ResponseEntity.badRequest().build()
				: ResponseEntity.ok(userUpdated);
	}

	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestBody User request) {
		long deleteCount = userService.delete(request);
		return deleteCount == 0
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok("\"deletedCount\":\"" + deleteCount + "\"");
	}
}
//@RequestParam does it like this http://localhost:8080/delete?id=60a46bd2bad8d9537d0367b7
//@RequestBody does it as JSON