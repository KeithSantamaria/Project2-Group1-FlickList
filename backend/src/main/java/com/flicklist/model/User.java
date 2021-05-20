package com.flicklist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data
@Document(collection = "users")
public class User {
	@Id
	private String id;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private String firstName;
	private String lastName;
	private String email;
}
