package com.flicklist.repository;

import com.flicklist.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {
	@Query("{'$and':[ {'username':?0}, {'password':?1} ] }")
	UserModel findByUsernameAndPassword(String username, String password);
}
