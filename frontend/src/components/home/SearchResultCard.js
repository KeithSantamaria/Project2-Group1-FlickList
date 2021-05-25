import React from 'react'
import { Link } from 'react-router-dom'

function SearchResultCard(props) {

    const baseImageUrl = "https://image.tmdb.org/t/p/original"
    return (
        <div className="flex bg-white rounded-xl shadow-xl">
            <img src={baseImageUrl + props.moviePoster}
                className=" h-40 w-26 rounded-2xl object-cover" />
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
