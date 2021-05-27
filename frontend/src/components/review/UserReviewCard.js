import React, { useState } from 'react';
import { StarIcon } from '@heroicons/react/solid';
import axios from 'axios';
import { Link } from 'react-router-dom';
import RatingStarSelector from '../movie/RatingStarSelector';

function UserReviewCard(props) {

    const { review, currentReviewIndex, reviews, setReviews } = props;
    const [isEditing, setIsEditing] = useState(false);
    const baseImgUrl = "https://image.tmdb.org/t/p/original";



    const [rating, setRating] = useState(review.rating);
    const [title, setTitle] = useState(review.title);
    const [textBody, setTextBody] = useState(review.textBody);



    const updateReview = () => {
        let newReviews = [...reviews];
        const updatedReview = {
            ...review,
            rating,
            title,
            textBody
        };
        newReviews[currentReviewIndex] = updatedReview;
        setReviews(newReviews);
        setIsEditing(false);
        axios.put("http://localhost:8080/reviews", {
            ...updatedReview
        }).then((response) => {
            //console.log(response.data);
        }).catch((error) => {
            console.log(error);
        });
    }


    if (isEditing) {

        return (
            <div className="flex bg-white items-start rounded-2xl shadow-lg gap-6">
                <Link to={`/movie/${review.movieId}`}>
                    <img alt="Not Found" className=" h-32 rounded-xl" src={`${baseImgUrl}${review.moviePoster}`} />
                </Link>
                <div className="flex flex-col flex-grow p-5 gap-6">
                    <div className="flex jus gap-2 justify-between">
                        <input type="text"
                            className=" bg-gray-100 rounded-xl p-2 w-80
                                focus:outline-none font-bold"
                            defaultValue={review.title}
                            onChange={(event) => {
                                setTitle(event.target.value);
                            }}></input>
                        <RatingStarSelector currentRating={rating} setCurrentRating={setRating} />
                    </div>
                    <textarea className="h-32 bg-gray-100 rounded-xl p-2 focus:outline-none"
                        defaultValue={review.textBody}
                        onChange={() => {
                            setTextBody(review.textBody);
                        }}>

                    </textarea>
                    <div className="flex justify-end px-4 gap-4">
                        <button className="focus:outline-none 
                            bg-primary rounded-full px-4 py-1 text-white
                            hover:shadow-lg"
                            onClick={() => {
                                updateReview();
                            }}>
                            Update
                        </button>
                        <button className="focus:outline-none 
                            border border-primary px-4 py-1 rounded-full text-primary
                            hover:border-opacity-0 hover:bg-secondary hover:text-white
                            hover:shadow-lg"
                            onClick={() => {
                                setIsEditing(false);
                            }}>
                            Cancel
                        </button>
                    </div>

                </div>
            </div>
        )
    }


    return (
        <div className="flex h-32 bg-white items-center rounded-2xl shadow-lg gap-6">
            <Link to={`/movie/${review.movieId}`}>
                <img alt="Not Found" className=" h-32 rounded-xl" src={`${baseImgUrl}${review.moviePoster}`} />
            </Link>
            <div className="flex flex-col flex-grow p-8 gap-6">
                <div className="flex jus gap-2 justify-between">
                    <h1 className="font-bold truncate w-80">{review.title}</h1>
                    <div className="flex gap-1 items-center">
                        {
                            [
                                ...Array(review.rating)
                            ].map((value, index) => {
                                return <StarIcon key={index} className="h-8 text-primary " />
                            })
                        }
                    </div>
                    <button className="bg-primary text-white px-4 py-1 rounded-full focus:outline-none hover:shadow-lg"
                        onClick={() => setIsEditing(true)}
                    >
                        edit
                    </button>
                </div>
                <h1 className=" opacity-40 font-bold">{review.date}</h1>
            </div>
        </div>
    )
}

export default UserReviewCard;
