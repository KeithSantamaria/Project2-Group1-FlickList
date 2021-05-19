package com.flicklist.controller;

import com.flicklist.model.UserModel;
import com.flicklist.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping("/login")
	public ResponseEntity<UserModel> login(@RequestBody UserModel request){
		return ResponseEntity.ok( userService.findOneByUsernameAndPassword(request.getUsername(), request.getPassword()));
	}

	@GetMapping("/findall")
	public ResponseEntity<List<UserModel>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	@PostMapping("/save")
	public ResponseEntity<UserModel> save(@RequestBody UserModel request){
		return ResponseEntity.ok(userService.save(request));
	}

	@PutMapping("/update")
	public ResponseEntity<UserModel> update(@RequestBody UserModel request){
		return ResponseEntity.ok(userService.update(request));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<UserModel> delete(@RequestBody UserModel request){
		userService.delete(request.getId());
		return ResponseEntity.ok().build();
	}
}

//@RequestParam does it like this http://localhost:8080/delete?id=60a46bd2bad8d9537d0367b7
//@RequestBody does it as JSON