package com.flicklist.controller;

import com.flicklist.model.Review;
import com.flicklist.service.review.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/reviews")
public class ReviewController {
	@Autowired
	private IReviewService reviewService;

	@GetMapping()
	public ResponseEntity<List<Review>> findAll(){
		return ResponseEntity.ok(reviewService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Review> findById(@PathVariable String id){
		return ResponseEntity.ok(reviewService.findById(id));
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<Review>> findAllByUserId(@PathVariable String id){
		return ResponseEntity.ok(reviewService.findAllByUserId(id));
	}

	@GetMapping("/movie/{id}")
	public ResponseEntity<List<Review>> findAllByMovie(@PathVariable String id){
		return ResponseEntity.ok(reviewService.findAllByMovieId(id));
	}

	@PostMapping()
	public ResponseEntity<Review> create(@Valid @RequestBody Review request){
		return ResponseEntity.ok(reviewService.create(request));
	}

	@PutMapping()
	public ResponseEntity<Review> update(@Valid @RequestBody Review request){
		return ResponseEntity.ok(reviewService.update(request));
	}

	@DeleteMapping()
	public void delete(@RequestBody Review request){
		//TODO do something to confirm delete
		reviewService.delete(request.getId());
	}

		//@RequestBody Review request
}
