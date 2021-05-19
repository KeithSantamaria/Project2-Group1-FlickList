package com.flicklist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class UserModel {
	@Id
	private String id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
}
