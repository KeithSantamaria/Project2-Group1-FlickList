package com.flicklist.controller;

import com.flicklist.model.Review;
import com.flicklist.service.review.IReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName ReviewController
 *
 * @Purpose The following class is used to handle all requests concerning reviews. Each end point will be clarified below
 */


@Slf4j
@RequestMapping ("/reviews")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ReviewController {
	@Autowired
	private IReviewService reviewService;

	/**
	 * @FunctionName findAll
	 *
	 * @return returns the response object that contains all reviews
	 */
	@GetMapping()
	public ResponseEntity<List<Review>> findAll(){
		return ResponseEntity.ok(reviewService.findAll());
	}


	/**
	 * @FunctionName findById
	 * @param id : the unique id associated with a particular review
	 * @return returns the response object that contains a single review associated with the unique id
	 */
	@GetMapping("{id}")
	public ResponseEntity<Review> findById(@PathVariable String id){
		Review reviewFound = reviewService.findById(id);
		return reviewFound == null
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(reviewFound);
	}

	/**
	 * @FunctionName findAllByUserId
	 * @param id : the unique id associated with a particular user
	 * @return returns the response object that contains all reviews associated with a particular user
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Review>> findAllByUserId(@PathVariable String id){
		return ResponseEntity.ok(reviewService.findAllByUserId(id));
	}

	/**
	 * @FunctionName findAllByMovieID
	 * @param id : the unique id associated with a particular movie
	 * @return returns the response object that contains all reviews associated with a particular movie
	 */
	@GetMapping("/movie/{id}")
	public ResponseEntity<List<Review>> findAllByMovieId(@PathVariable String id){
		return ResponseEntity.ok(reviewService.findAllByMovieId(id));
	}

	/**
	 * @FunctionName create
	 * @param request : used to determine if it is a valid review, and if it is creates a review based on that info
	 * @return return the response object that contains the newly create review to send back to the client
	 */
	@PostMapping()
	public ResponseEntity<Review> create(@Valid @RequestBody Review request){
		Review reviewCreated = reviewService.create(request);
		log.info("attempting to create review");
		log.info("review created: " + reviewCreated);
		return reviewCreated == null
				? ResponseEntity.badRequest().build()
				: ResponseEntity.ok(reviewCreated);
	}

	/**
	 * @FunctionName update
	 * @param request : used to determine if it is a valid, existing review, and if it is, it will update the review
	 * @return returns the response object that contains the newly updated review
	 */
	@PutMapping()
	public ResponseEntity<Review> update(@Valid @RequestBody Review request){
		Review reviewUpdated = reviewService.update(request);
		log.info("attempting to update review");
		log.info("review updated: " + reviewUpdated);
		return reviewUpdated == null
				? ResponseEntity.badRequest().build()
				: ResponseEntity.ok(reviewUpdated);
	}

	/**
	 * @FunctionName delete
	 * @param request : used to determine if it is a valid, existing review, and if it is, it will delete the review
	 * @return returns a count confirming the delete review
	 */
	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestBody Review request){
		long deleteCount = reviewService.delete(request);
		log.info("attempting to delete review");
		log.info("reviews deleted: " + deleteCount);
		return deleteCount == 0
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok("\"deletedCount\":\"" + deleteCount + "\"");
	}

		//@RequestBody Review request
}
