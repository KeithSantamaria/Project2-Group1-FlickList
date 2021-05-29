package com.flicklist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**\
 * @ClassName Reviews
 *
 * @Purpose The following class is a POJO that is used to store the reviews as documents in our mongoDb
 *
 * @Params
 *
 * 				String id: Unique id used for MongoDb
 * 				String userId: references the unique Id of a user to show that the user created said review
 * 				String reviewerName: tied with userId. It is used to correctly show the user's name the reivew card client side
 * 				String movieId: references the unique movie id from the tmdb api
 * 				String moviePoster: contains info used for rendering the movie Poster	from the tmdb api
 * 				String date: the timestamp used when the review is created
 * 				int rating: the numbered rating from 1-5
 * 				String title: Optional. Used to give the review a title if the user gives more details
 * 				String textBody: Optional. used to give the review an actual body of text
 * 				int likes: used to store the number of likes
 * 				int dislikes: used to store the number of dislikes
 *
 */

@Data
@Document(collection = "reviews")
public class Review {
	@Id
	private String id;
	@NotEmpty
	private String userId;
	@NotEmpty
	private String reviewerName;
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

	private int likes;
	private int dislikes;
}
