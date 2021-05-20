package com.flicklist.repository;

import com.flicklist.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
	//@Query("{'$and':[ {'username':?0}, {'password':?1} ] }")
	List<User> findByUsernameAndPassword(String username, String password);
	long removeById(String id);
}
