package com.flicklist.unittests.servicetests;

import com.flicklist.model.Review;
import com.flicklist.repository.ReviewRepository;
import com.flicklist.service.review.ReviewService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ReviewServiceTests {
	Review testReview;
	List<Review> reviews;

	private final ReviewRepository reviewRepository = Mockito.mock(ReviewRepository.class);
	private final ReviewService reviewService = new ReviewService(reviewRepository);

	@BeforeEach
	public void shouldRunBeforeEach(){
		testReview = new Review();
		reviews = new ArrayList<>();
	}

	@Test
	public void shouldFindAll(){
		reviews.add(new Review());
		reviews.add(new Review());
		reviews.add(new Review());

		Mockito.when(reviewRepository.findAll()).thenReturn(reviews);
		List<Review> fetchedReviews = reviewService.findAll();
		int expectedCount = 3;
		Assert.assertEquals("Expected to fetch 3 reviews ",expectedCount,fetchedReviews.size());
	}

	@Test
	public void shouldFindById(){
		testReview.setId("60a6c78bc1b41e59f7bd5d37");
		Mockito.when(reviewRepository.findById(testReview.getId())).thenReturn(java.util.Optional.of(testReview));
		Review createdReview = reviewService.findById(testReview.getId());
		Assert.assertEquals("Should be the same review", testReview, createdReview);
	}

	@Test
	public void shouldCreateAReview(){
		Mockito.when(reviewRepository.save(testReview)).thenReturn(testReview);
		Review createdReview = reviewService.create(testReview);
		Assert.assertEquals("Expected equal Reviews", testReview, createdReview);
	}

	@Test
	public void shouldFailToCreateAReview(){
		testReview.setId("testId");
		testReview.setDate("2021-04-12");
		Mockito.when(reviewRepository.save(testReview)).thenReturn(testReview);
		Review createdReview = reviewService.create(testReview);
		Assert.assertNotEquals("Should fail to create", testReview, createdReview);
	}

	@Test
	public void shouldFailToUpdateReview(){
		Mockito.when(reviewRepository.save(testReview)).thenReturn(null);
		Review createdUser = reviewService.update(testReview);
		Assert.assertNull("Should be null", createdUser);
	}

	@Test
	public void shouldUpdateReview(){
		testReview.setId("testId");
		testReview.setUserId("userId");
		testReview.setMovieId("Bee movie");
		testReview.setDate("4-12-21");
		testReview.setRating(3);
		testReview.setTitle("This Review");
		testReview.setTextBody("This is the review body.");
		testReview.setLikes(69);
		testReview.setDislikes(420);

		Review createdReview = testReview;
		createdReview.setRating(4);
		Mockito.when(reviewRepository.save(testReview)).thenReturn(createdReview);
		Review changedReview = reviewService.update(testReview);
		boolean isCorrectParams = createdReview.getId().equals("testId");
		if( !changedReview.getUserId().equals("userId")){
			isCorrectParams = false;
		}
		if( !changedReview.getMovieId().equals("Bee movie")){
			isCorrectParams = false;
		}
		if( !changedReview.getDate().equals("4-12-21")){
			isCorrectParams = false;
		}
		if( changedReview.getRating() != 4 ){
			isCorrectParams = false;
		}
		if( !changedReview.getTitle().equals("This Review")){
			isCorrectParams = false;
		}
		if( !changedReview.getTextBody().equals("This is the review body.")){
			isCorrectParams = false;
		}
		if( changedReview.getLikes() != 69 ){
			isCorrectParams = false;
		}
		if( changedReview.getDislikes() != 420 ){
			isCorrectParams = false;
		}

		Assert.assertTrue("Should have update", isCorrectParams);
	}

	@Test
	public void shouldDelete(){
		long testSize = 3;
		String id = "test";
		testReview.setId(id);
		Mockito.when(reviewRepository.removeById(id)).thenReturn( testSize -1);
		long newSizeAfterDelete = reviewService.delete(testReview);
		Assert.assertEquals("Should have been one less document", 2 , newSizeAfterDelete);
	}

	@Test
	public void shouldAllByMovieId(){
		reviews.add(new Review());
		reviews.add(new Review());
		reviews.add(new Review());

		Mockito.when(reviewRepository.findByMovieId("movieId")).thenReturn(reviews);
		List<Review> createdReview = reviewService.findAllByMovieId("movieId");
		Assert.assertEquals("Should fetch 3 reviews", 3, createdReview.size());
	}

	@Test
	public void shouldAllByUserId(){
		reviews.add(new Review());
		reviews.add(new Review());
		reviews.add(new Review());

		Mockito.when(reviewRepository.findByUserId("userId")).thenReturn(reviews);
		List<Review> createdReview = reviewService.findAllByUserId("userId");
		Assert.assertEquals("Should fetch 3 reviews", 3, createdReview.size());
	}

}
