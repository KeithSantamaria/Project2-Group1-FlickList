import React from 'react'
import { Link } from 'react-router-dom';



function TrendingCard(props) {

    const {movie} = props;
    return (
        <div className="flex-shrink-0 flex flex-col w-48 
                        font-openSans">
            <Link to={`/movie/${props.movieId}`} className=" object-cover m-2 overflow-hidden rounded-xl hover:shadow-2xl transform hover:scale-105" >
                <img src={props.imgUrl} alt="Movie Poster" />
            </Link>

            <Link to={`/movie/${props.movieId}`}>
                <h1 className=" pl-2 pt-3 font-bold text-left   overflow-hidden hover:text-primary">{movie.title}</h1>
            </Link>
            <h1 className=" pl-2 font-bold text-gray-500 text-xs">{movie.release_date.split("-")[0]}</h1>

        </div>

    )
}

export default TrendingCard;
