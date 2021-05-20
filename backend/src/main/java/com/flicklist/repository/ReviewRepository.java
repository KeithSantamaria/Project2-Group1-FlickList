package com.flicklist.repository;

import com.flicklist.model.Review;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review,String>{
	List<Review> findByUserId(String id);
	List<Review> findByMovieId(String id);
}
