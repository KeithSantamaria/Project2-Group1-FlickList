package com.flicklist.service.review;

import com.flicklist.model.Review;
import com.flicklist.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements IReviewService{
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public List<Review> getAll() {
		return reviewRepository.findAll();
	}

	@Override
	public List<Review> getAllByMovieId(String id) {
		return reviewRepository.findByMovieId(id);
	}

	@Override
	public List<Review> getAllByUserId(String id) {
		return reviewRepository.findByUserId(id);
	}

	@Override
	public Review create(Review review) {
		return reviewRepository.save(review);
	}

	@Override
	public Review update(Review review) {
		reviewRepository.findById(review.getId()).orElse(null);
		return reviewRepository.save(review);
	}

	@Override
	public void delete(String id) {
		reviewRepository.deleteById(id);
	}
}
