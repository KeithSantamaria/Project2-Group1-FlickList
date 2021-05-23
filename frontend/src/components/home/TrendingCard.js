import React from 'react'
function TrendingCard(props) {

    const logo = "https://image.tmdb.org/t/p/original/wigZBAmNrIhxp2FNGOROUAeHvdh.jpg";

    return (
        <div className=" group flex-shrink-0 flex flex-col justify-between 
                        bg-white w-48 h-80 rounded-xl
                        font-openSans 
                        hover:shadow-2xl">
            <img className=" h-60 object-cover object-top rounded-t-xl" src={props.imgUrl} alt="Movie Poster" />
            <h1 className="font-bold text-left mx-4 whitespace-nowrap overflow-hidden">{props.name}</h1>
            <a href={`/movie/${props.movieId}`} className="mx-3 mb-3 p-2 rounded-full 
                                    border border-primary text-center 
                                    text-primary text-xs opacity-75
                                    group-hover:bg-primary group-hover:text-white" >
                More
            </a>
        </div>

    )
}

export default TrendingCard;
