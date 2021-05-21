package com.flicklist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data
@Document(collection = "users")
public class User {

	@Id
	private String id;
	@NotEmpty
	@Indexed(unique = true)
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	@Indexed(unique = true)
	private String email;
}
