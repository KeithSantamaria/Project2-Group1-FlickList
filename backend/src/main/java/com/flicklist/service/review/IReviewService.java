package com.flicklist.service.review;

import com.flicklist.model.Review;

import java.util.List;

public interface IReviewService {

	List<Review> getAll();
	List<Review> getAllByUserId(String id);
	List<Review> getAllByMovieId(String id);
	Review create(Review review);
	Review update (Review review);
	void delete(String id);
}
