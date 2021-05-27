package com.flicklist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

/**\
 * @ClassName User
 *
 * @Purpose The following class is a POJO that is used to store the users as documents in our mongoDb
 *
 * @Params
 * 				String id: Unique id used for MongoDb
 * 				String username: the username of the user, the more "casual" reference. Also unique
 * 				String password: used to authenticate the user. They must input password to log in as user
 * 				String firstName: optional detail that lists that first name of user.
 * 				String lastName: optional detail that lists the last name
 * 				String email: optional detail that lists the email.
 */

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
