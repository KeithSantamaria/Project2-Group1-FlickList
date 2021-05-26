package com.flicklist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@Document(collection = "reviews")
public class Review {
	@Id
	private String id;
	@NotEmpty
	private String userId;
	@NotEmpty
	private String movieId;
	private String moviePoster;
	private String movieTitle;
	private String date;
	@Positive
	@Min(value = 1, message = "Rating must be greater than 0")
	@Max(value = 5, message = "Rating must be less or equal to than 5")
	private int rating;

	private String title;
	private String textBody;

	//TODO both likes and dislikes should be 0 if title and textBody are empty
	private int likes;
	private int dislikes;
}
