import React from 'react';
import { Link } from 'react-router-dom';

import {PhotographIcon} from '@heroicons/react/solid';

function SearchResultCard(props) {

    const baseImageUrl = "https://image.tmdb.org/t/p/original"
    return (
        <div className="flex bg-white rounded-2xl shadow-xl">

            {
                props.moviePoster != null
                    ? <img src={baseImageUrl + props.moviePoster}
                    className=" h-40 w-28 rounded-l-2xl object-fill" />
                    : <div className=" flex flex-col justify-center h-40 w-28 border-2 rounded-l-2xl">
                        <PhotographIcon className="h-10"/>
                    </div>
            }
            
            <div className="flex flex-col h-40 p-8 gap-3 font-openSans">
                <Link to={`/movie/${props.movieId}`}
                    className="text-2xl hover:text-primary">
                    {props.movieTitle}
                </Link>
                <p className="overflow-ellipsis overflow-hidden">{props.movieSummary}</p>
            </div>

        </div>
    )
}

export default SearchResultCard
