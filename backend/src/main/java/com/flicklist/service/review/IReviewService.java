package com.flicklist.service.review;

import com.flicklist.model.Review;

import java.util.List;

public interface IReviewService {

	List<Review> findAll();
	List<Review> findAllByUserId(String id);
	List<Review> findAllByMovieId(String id);
	Review findById(String id);
	Review create(Review review);
	Review update (Review review);
	long delete(Review review);
}
