import axios from 'axios';
import React, { useState, useEffect } from 'react'

import MovieReviewCard from './MovieReviewCard';

function MovieReviews(props) {

    const [reviews, setReviews] = useState([]);
    const { movieId } = props;

    useEffect(() => {
        axios.get(`http://localhost:8080/reviews/movie/${movieId}`)
            .then((response) => {
                setReviews(response.data);
            })
    }, []);

    return (
        <div className="flex flex-col gap-6 font-openSans">
            <div className="flex items-center">
                <h1 className="px-2 text-2xl font-bold">Reviews</h1>
                <div className=" flex-grow h-2 bg-gradient-to-l from-primary rounded-full"></div>
            </div>


            <div className="flex flex-col gap-6">
                {
                    reviews.length == 0
                        ? <div className="flex justify-center">
                            No Reviews found.
                        </div>
                        : reviews.map((review) => {
                            return <MovieReviewCard key={review.id} review={review} />
                        })
                }
            </div>
        </div>
    )
}

export default MovieReviews
