package com.flicklist.unittests.servicetests;

import com.flicklist.model.Review;
import com.flicklist.repository.ReviewRepository;
import com.flicklist.repository.UserRepository;
import com.flicklist.service.review.ReviewService;
import com.flicklist.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.util.AssertionErrors.*;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTests {

	@Mock
	private ReviewRepository reviewRepository;

	@Autowired
	@InjectMocks
	private ReviewService reviewService;

	private Review testReview;
	private List<Review> reviews;

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
		assertEquals("Expected to fetch 3 reviews ",expectedCount,fetchedReviews.size());
	}

	@Test
	public void shouldFindById(){
		testReview.setId("60a6c78bc1b41e59f7bd5d37");
		Mockito.when(reviewRepository.findById(testReview.getId())).thenReturn(java.util.Optional.of(testReview));
		Review createdReview = reviewService.findById(testReview.getId());
		assertEquals("Should be the same review", testReview, createdReview);
	}

	@Test
	public void shouldCreateAReview(){
		Mockito.when(reviewRepository.save(testReview)).thenReturn(testReview);
		Review createdReview = reviewService.create(testReview);
		assertEquals("Expected equal Reviews", testReview, createdReview);
	}

	@Test
	public void shouldFailToCreateAReview(){
		testReview.setId("testId");
		testReview.setDate("2021-04-12");
		Review createdReview = reviewService.create(testReview);
		assertNotEquals("Should fail to create", testReview, createdReview);
	}

	@Test
	public void shouldFailToUpdateReview(){
		Review createdUser = reviewService.update(testReview);
		assertNull("Should be null", createdUser);
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

		assertTrue("Should have update", isCorrectParams);
	}

	@Test
	public void shouldDelete(){
		long testSize = 3;
		String id = "test";
		testReview.setId(id);
		Mockito.when(reviewRepository.removeById(id)).thenReturn( testSize -1);
		long newSizeAfterDelete = reviewService.delete(testReview);
		assertEquals("Should have been one less document", (long)2 , newSizeAfterDelete);
	}

	@Test
	public void shouldAllByMovieId(){
		reviews.add(new Review());
		reviews.add(new Review());
		reviews.add(new Review());

		Mockito.when(reviewRepository.findByMovieId("movieId")).thenReturn(reviews);
		List<Review> createdReview = reviewService.findAllByMovieId("movieId");
		assertEquals("Should fetch 3 reviews", 3, createdReview.size());
	}

	@Test
	public void shouldAllByUserId(){
		reviews.add(new Review());
		reviews.add(new Review());
		reviews.add(new Review());

		Mockito.when(reviewRepository.findByUserId("userId")).thenReturn(reviews);
		List<Review> createdReview = reviewService.findAllByUserId("userId");
		assertEquals("Should fetch 3 reviews", 3, createdReview.size());
	}

}
