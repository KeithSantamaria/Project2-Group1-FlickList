package com.flicklist.service.review;

import com.flicklist.model.Review;
import com.flicklist.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
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
		if (review.getId() == null) {
			review.setDate(createDate());
			return reviewRepository.save(review);
		} else {
			return null;
		}
	}

	@Override
	public Review update(Review review) {
		if (review.getId() == null) {
			return null;
		} else {
			return reviewRepository.save(review);
		}
	}

	@Override
	public long delete(Review review) {
		return reviewRepository.removeById(review.getId());
	}


	private String createDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(new Date());
	}
}
