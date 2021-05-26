import React, { useState } from 'react'
import { StarIcon, ThumbUpIcon, ThumbDownIcon } from '@heroicons/react/solid';


function MovieReviewCard(props) {


    const { review, reviewIndex, addLike, addDislike } = props

    const [hasLiked,setHasLiked] = useState(false);


    const user = "Keith Santamaria";

    if (review == null) {

        return (
            <div>
                Review not found
            </div>
        )

    } else {
        return (
            <div className="relative h-44 bg-white mt-10 ml-10 rounded-2xl shadow-md">
                <div className="absolute flex justify-center items-center h-20 w-20 
                            bg-primary -inset-8 rounded-3xl overflow-y-auto
                            text-white shadow-2xl z-10">
                    <StarIcon className="h-9" />
                    <h1 className="text-3xl ">{review.rating}</h1>
                </div>
                <div className="flex flex-col p-4 gap-5">
                    <h1 className="ml-16 text-xl font-bold truncate">{review.title}</h1>
                    <p className="h-14 text-sm overflow-ellipsis overflow-hidden">{review.textBody}</p>
                    <div className="flex justify-between">
                        <div className="flex gap-4">
                            <p className="text-xs px-2opacity-50">{review.date}</p>
                            <p className="text-xs px-2opacity-50">by "{user}"</p>
                        </div>
                        <div className="flex h-7 gap-3 text-gray-500">
                            <p className=" self-center">{review.likes}</p>
                            <button className={`self-start focus:outline-none 
                                ${
                                    hasLiked
                                    ? "opacity-50 cursor-default"
                                    : "hover:text-primary"
                                }`}
                                onClick={()=>{
                                    addLike(reviewIndex);
                                    setHasLiked(true);
                                }}>
                                <ThumbUpIcon className="h-6 " />
                            </button>
                            <button className={`self-end focus:outline-none  
                                ${
                                    hasLiked
                                    ? "opacity-50 cursor-default"
                                    : "hover:text-secondary"
                                }`}
                                onClick={()=>{
                                    addDislike(reviewIndex);
                                    setHasLiked(true);
                                }}>
                                <ThumbDownIcon className="h-6 " />
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        )
    }


}

export default MovieReviewCard;
