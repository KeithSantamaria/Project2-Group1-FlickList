import React from 'react';
import { Link } from 'react-router-dom';
function SearchResultCard(props) {

    const baseImageUrl = "https://image.tmdb.org/t/p/original"
    return (
        <div className="flex bg-white rounded-2xl shadow-xl">

            {
                props.moviePoster != null
                && <img src={baseImageUrl + props.moviePoster}
                    className=" h-40 w-28 rounded-l-2xl object-fill"
                    alt="Img not found" />

            }

            <div className="flex flex-col h-40 p-3 gap-1">
                <div className="flex items-center gap-3"> 
                    <Link to={`/movie/${props.movieId}`}
                        className=" flex items-center gap-3 text-xl font-extrabold hover:text-primary">
                        {props.movieTitle}
                    </Link>
                    <h6 className=" text-base font-bold opacity-60">{`(${props.movieYear})`}</h6>
                </div>

                <p className="overflow-ellipsis overflow-hidden text-sm">{props.movieSummary}</p>
            </div>

        </div>
    )
}

export default SearchResultCard
