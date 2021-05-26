import React from 'react';
import { StarIcon } from '@heroicons/react/solid';

function UserReviewCard(props) {

    const { review } = props;
    const baseImgUrl = "https://image.tmdb.org/t/p/original";

    return (
        <div className="flex h-32 bg-white items-center rounded-2xl shadow-lg gap-6">
            <img className=" h-32 rounded-xl" src={`${baseImgUrl}${review.moviePoster}`}/>
            <div className="flex flex-col flex-grow p-10 gap-6">
                <div className="flex jus gap-2 justify-between">
                    <div className="flex">
                        <h1 className="font-bold">{review.rating}</h1>
                        <StarIcon className="h-5" />
                    </div>
                    <h1>{review.date}</h1>
                    <button className="bg-primary text-white px-4 py-1 rounded-full focus:outline-none">edit</button>
                </div>
                <h1 className="font-bold truncate">{review.title}</h1>
            </div>
        </div>
    )
}

export default UserReviewCard;
