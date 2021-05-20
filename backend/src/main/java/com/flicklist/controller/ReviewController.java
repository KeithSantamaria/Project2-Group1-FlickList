package com.flicklist.controller;

import com.flicklist.model.Review;
import com.flicklist.service.review.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/reviews")
public class ReviewController {
	@Autowired
	private IReviewService reviewService;

	@GetMapping()
	public ResponseEntity<List<Review>> getAll(){
		return ResponseEntity.ok(reviewService.getAll());
	}

	@GetMapping("/user/(id)")
	public ResponseEntity<List<Review>> getAllByUserId(@PathVariable String id){
		return ResponseEntity.ok(reviewService.getAllByUserId(id));
	}

	@GetMapping("/movie/(id)")
	public ResponseEntity<List<Review>> getAllByMovie(@PathVariable String id){
		return ResponseEntity.ok(reviewService.getAllByMovieId(id));
	}

	@PostMapping()
	public ResponseEntity<Review> create(@RequestBody Review request){
		return ResponseEntity.ok(reviewService.create(request));
	}

	@PutMapping()
	public ResponseEntity<Review> update(@RequestBody Review request){
		return ResponseEntity.ok(reviewService.update(request));
	}

	@DeleteMapping()
	public void delete(@RequestBody Review request){
		//TODO do something to confirm delete
		reviewService.delete(request.getId());
	}

		//@RequestBody Review request
}
