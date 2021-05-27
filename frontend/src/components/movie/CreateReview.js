import React, { useState } from 'react'
import { reviewAdded } from '../../redux/actioncreators/reviewCreators.js';
import axios from 'axios';
import RatingStarSelector from './RatingStarSelector.js';



export default function CreateReview(props) {

    const [rating, setRating] = useState(0);
    const [title, setTitle] = useState(null);
    const [textBody, setTextBody] = useState(null);
    const { movieId, movieTitle, moviePoster, reviews, setReviews, userId } = props;
    

    const saveReview = () => {
        const currentReview = {
            userId,
            movieId,
            movieTitle,
            moviePoster,
            rating,
            title,
            textBody
        };

        setReviews([
            ...reviews,
            currentReview
        ]);

        axios.post("http://localhost:8080/reviews",
            {
                ...currentReview
            })
            .then((response) => {
                reviewAdded(response);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    return (
        <div className=" flex flex-col gap-6 p-10">
            <div className="flex justify-between">
                <h1 className="self-center font-bold text-xl">What did you think of the movie?</h1>
                <div className="flex gap-6">
                    <RatingStarSelector currentRating={rating} setCurrentRating={setRating} />
                </div>
            </div>
            <input className="p-3 rounded-xl focus:outline-none" type="text" placeholder="Title"
                onChange={(event) => {
                    setTitle(event.target.value);
                }}>
            </input>
            <textarea placeholder="Your review helps others find greate movies. Share you honest experience."
                className=" h-56 p-3 rounded-xl focus:outline-none"
                onChange={(event) => {
                    setTextBody(event.target.value);
                }}>
            </textarea>
            <div className="flex justify-end">
                <button className="bg-primary text-white rounded-full 
                    hover:shadow-xl focus:outline-none px-5 py-2"
                    onClick={() => {
                        saveReview();
                    }}>
                    Submit
                </button>
            </div>

        </div>
    );
}

