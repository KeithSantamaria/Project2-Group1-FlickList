package com.flicklist.controller;

import com.flicklist.model.Review;
import com.flicklist.model.User;
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
		Review reviewFound = reviewService.findById(id);
		return reviewFound == null
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(reviewFound);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<Review>> findAllByUserId(@PathVariable String id){
		return ResponseEntity.ok(reviewService.findAllByUserId(id));
	}

	@GetMapping("/movie/{id}")
	public ResponseEntity<List<Review>> findAllByMovieId(@PathVariable String id){
		return ResponseEntity.ok(reviewService.findAllByMovieId(id));
	}

	@PostMapping()
	public ResponseEntity<Review> create(@Valid @RequestBody Review request){
		Review reviewCreated = reviewService.create(request);
		return reviewCreated == null
				? ResponseEntity.badRequest().build()
				: ResponseEntity.ok(reviewCreated);
	}

	@PutMapping()
	public ResponseEntity<Review> update(@Valid @RequestBody Review request){
		Review reviewUpdated = reviewService.update(request);
		return reviewUpdated == null
				? ResponseEntity.badRequest().build()
				: ResponseEntity.ok(reviewUpdated);
	}

	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestBody Review request){
		//TODO do something to confirm delete
		long deleteCount = reviewService.delete(request);
		return deleteCount == 0
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok("\"deletedCount\":\"" + deleteCount + "\"");
	}

		//@RequestBody Review request
}
