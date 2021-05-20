package com.flicklist.service.review;

import com.flicklist.model.Review;
import com.flicklist.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements IReviewService{

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	@Override
	public Review findById(String id) {
		return reviewRepository.findById(id).orElse(null);
	}

	@Override
	public List<Review> findAllByMovieId(String id) {
		return reviewRepository.findByMovieId(id);
	}

	@Override
	public List<Review> findAllByUserId(String id) {
		return reviewRepository.findByUserId(id);
	}

	@Override
	public Review create(Review review) {
		review.setDate(createDate());
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


	private String createDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(new Date());
	}
}
