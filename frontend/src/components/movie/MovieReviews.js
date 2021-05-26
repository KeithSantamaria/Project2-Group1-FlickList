import axios from 'axios';
import React, { useState, useEffect } from 'react';

import Divider from '../Divider';

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

    const addLike = (index)=>{
        let copyOfReviews = [...reviews];
        let currentReview = {...reviews[index]};
        currentReview.likes = currentReview.likes + 1;
        copyOfReviews[index] = currentReview;
        setReviews(copyOfReviews);
        axios.put("http://localhost:8080/reviews",
            {...copyOfReviews[index]})
            .then((response)=>{
                //console.log(response);
            }).catch((error)=>{
                console.log(error);
            })
    };

    const addDislike = (index)=>{
        let copyOfReviews = [...reviews];
        let currentReview = {...reviews[index]};
        currentReview.likes = currentReview.likes - 1;
        copyOfReviews[index] = currentReview;
        setReviews(copyOfReviews);
        axios.put("http://localhost:8080/reviews",
            {...copyOfReviews[index]})
            .then((response)=>{
                //console.log(response);
            }).catch((error)=>{
                console.log(error);
            })
    };

    return (
        <div className="flex flex-col gap-6 font-openSans">
            <Divider title="Reviews"/>
            <div className="flex flex-col gap-6">
                {
                    reviews.length == 0
                        ? <div className="flex justify-center">
                            No Reviews found.
                        </div>
                        : reviews.map((review, index) => {
                            return <MovieReviewCard key={review.id} review={review} reviewIndex={index} addLike={addLike} addDislike={addDislike}/>
                        })
                }
            </div>
        </div>
    )
}

export default MovieReviews
