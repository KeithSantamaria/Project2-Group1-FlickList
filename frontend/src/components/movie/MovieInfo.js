import React from 'react'
import Logo from '../Logo';

function MovieInfo(props) {

    const movieBannerUrl = "https://image.tmdb.org/t/p/original/6ELCZlTA5lGUops70hKdB83WJxH.jpg";
    const moviePosterUrl = "https://image.tmdb.org/t/p/original/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg";
    const tmdbLogoUrl = "https://www.themoviedb.org/assets/2/v4/logos/v2/blue_square_2-d537fb228cf3ded904ef09b136fe3fec72548ebc1fea3fbbd1ad9e36364db38b.svg";

    const movieTitle = "Mortal Kombat";
    const movieRating = "PG-13";
    const movieYear = "2021";
    const movieGenres = "Action/Fantasy/Adventure";
    const movieDuration = "2h 21m";

    return (
        <div className="flex justify-center mt-6 font-openSans">
            <div className="flex flex-col gap-6 max-w-screen-lg px-20">
                <img className="h-72 w-full rounded-2xl object-cover shadow-xl" src={movieBannerUrl}/>
                <div className="flex flex-wrap gap-6 justify-center">
                    <img className=" h-80 rounded-xl shadow-xl" src={moviePosterUrl}/>
                    <div className="flex p-6 flex-grow flex-col gap-2 justify-center items-center
                                    bg-white shadow-xl rounded-xl">
                        <h1 className=" text-3xl font-bold">{movieTitle}</h1>
                        <div className="flex gap-3">
                            <h6 className="border border-gray-400 rounded px-1">{movieRating}</h6>
                            <h6>{movieYear}, {movieGenres}, {movieDuration}</h6> 
                        </div>
                        <div className="flex w-full justify-around mt-5 whitespace-nowrap text-xl font-bold ">
                            <div className="flex items-center gap-6">
                                <img src={tmdbLogoUrl}/>
                                <h1>76 %</h1>
                            </div>
                            <div className="flex items-center gap-4">
                                <Logo iconHeight="h-16"/>
                                <h1>4.5</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default MovieInfo;
