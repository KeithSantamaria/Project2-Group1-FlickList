import axios from 'axios';
import React, { useState, useEffect } from 'react';

import Divider from '../Divider';
import CreateReview from './CreateReview';
import { useSelector } from 'react-redux';
import MovieReviewCard from './MovieReviewCard';

function MovieReviews(props) {

    const [reviews, setReviews] = useState([]);
    const [hasReviewed,setHasReviewed] = useState(false);
    const { movieId,movieTitle,moviePoster } = props;
    const user = useSelector(state=>state.currentUser);

    useEffect(() => {
        axios.get(`http://localhost:8080/reviews/movie/${movieId}`)
            .then((response) => {
                setReviews(response.data);
            })
            .catch((error)=>{
                console.log(error);
            });
        
        
    }, []);// eslint-disable-line react-hooks/exhaustive-deps

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

    useEffect(()=>{
        if(reviews.length > 0){
            for(let i = reviews.length -1; i > -1; i--){
                if(reviews[i].userId === user.id){
                    setHasReviewed(true);
                    break;
                }
            }
        }
    
    },[reviews, user.id]);
    
    return (
        <div className="flex flex-col gap-6 font-openSans">
            <Divider title="Reviews"/>
            {
                !hasReviewed &&
                    <CreateReview movieId={movieId} setReviews={setReviews} reviews={reviews} movieTitle={movieTitle} moviePoster={moviePoster} userId={user.id}/>
            }
            <div className="flex flex-col-reverse gap-6">
                {
                    reviews.length === 0
                        ? <div className="flex justify-center">
                            No Reviews found.
                        </div>
                        : reviews.map((review, index) => {
                            return <MovieReviewCard key={index} review={review} reviewIndex={index} addLike={addLike} addDislike={addDislike}/>
                        })
                }
            </div>
        </div>
    )
}

export default MovieReviews
