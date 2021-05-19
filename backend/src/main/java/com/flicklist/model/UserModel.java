package com.flicklist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserModel {
	@Id
	private String id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;

}
