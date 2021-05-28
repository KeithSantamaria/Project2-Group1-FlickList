package com.flicklist.service.review;

import com.flicklist.model.Review;
import com.flicklist.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ReviewService
 *
 * @Purpose The following class is used to communicate with the db regarding the Reviews
 */
@Service
public class ReviewService implements IReviewService{

	@Autowired
	private ReviewRepository reviewRepository;

	/**
	 * @FunctionName findAll
	 *
	 * @return returns a list of all reviews from the database
	 */
	@Override
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	/**
	 * @FunctionName findById
	 * @param id : id of the review
	 * @return returns the review associated with id
	 */
	@Override
	public Review findById(String id) {
		return reviewRepository.findById(id).orElse(null);
	}

	/**
	 * @FunctionName findAllByMovieId
	 * @param id : id of a movie
	 * @return returns a list of reviews that are about a movie
	 */
	@Override
	public List<Review> findAllByMovieId(String id) {
		return reviewRepository.findByMovieId(id);
	}

	/**
	 * @FunctionName findAllByUserId
	 * @param id : id of a user
	 * @return returns a list of reviews written by a user
	 */
	@Override
	public List<Review> findAllByUserId(String id) {
		return reviewRepository.findByUserId(id);
	}

	/**
	 * @FunctionName create
	 * @param review: a review object to be written to the db
	 * @return writes the review to the db
	 */
	@Override
	public Review create(Review review) {
		if (review.getId() == null) {
			review.setDate(createDate());
			return reviewRepository.save(review);
		} else {
			return null;
		}
	}

	/**
	 * @FunctionName update
	 * @param review : should contain a valid, existing review object
	 * @return writes the review to the db
	 */
	@Override
	public Review update(Review review) {
		if (review.getId() == null) {
			return null;
		} else {
			return reviewRepository.save(review);
		}
	}

	/**
	 * @FunctionName delete
	 * @param review : should contain a valid, existing review object
	 * @return deletes the review
	 */
	@Override
	public long delete(Review review) {
		return reviewRepository.removeById(review.getId());
	}

	/**
	 * @FunctionName createDate
	 * @return creates a timestamp of a certain format (yyyy-mm-dd)
	 */
	private String createDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(new Date());
	}
}
