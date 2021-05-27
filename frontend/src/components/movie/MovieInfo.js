import React from 'react'
import Logo from '../Logo';
import Divider from '../Divider';

function MovieInfo(props) {


    const { movie } = props;

    const baseImgUrl = "https://image.tmdb.org/t/p/original";
    const tmdbLogoUrl = "https://www.themoviedb.org/assets/2/v4/logos/v2/blue_square_2-d537fb228cf3ded904ef09b136fe3fec72548ebc1fea3fbbd1ad9e36364db38b.svg";

    function getMovieDuration(timeLenght) {
        const hours = Math.floor(timeLenght / 60);
        const minutes = timeLenght % 60;
        return hours + "h " + minutes + "m";
    }

    function getMovieYear(releaseDate) {
        return releaseDate.split("-")[0];
    }

    function getGenres(genres) {
        let finalGenres = "";
        for (let i = 0; i < genres.length; i++) {
            if (i > 1 || i === genres.length - 1) {
                finalGenres = finalGenres.concat(genres[i].name);
                break;
            } else {
                finalGenres = finalGenres.concat(genres[i].name + "/");
            }

        }
        return finalGenres;
    }

    if (props.movie == null || props.movie.poster_path == null || props.movie.backdrop_path == null) {

        return (
            <div> not found</div>
        )

    } else {
        return (

            <div className="flex flex-col gap-6">
                <img className="h-72 rounded-2xl object-cover object-top shadow-xl" 
                    src={baseImgUrl + movie.backdrop_path} 
                    alt="Not Found"/>
                <div className="flex flex-wrap gap-6 justify-center">
                    <img className=" h-80 rounded-xl shadow-xl" src={baseImgUrl + movie.poster_path} 
                        alt="Not Found"/>
                    <div className="flex p-5 flex-grow flex-col gap-4 justify-center items-center
                                        bg-white shadow-xl rounded-xl font-openSans">
                        <h1 className=" text-3xl font-bold opacity-75">{movie.title}</h1>
                        <h6 className="opacity-75">{getMovieYear(movie.release_date)}, {getGenres(movie.genres)}, {getMovieDuration(movie.runtime)}</h6>
                        <div className="flex w-full justify-around mt-5 whitespace-nowrap text-xl font-bold ">
                            <div className="flex items-center gap-6">
                                <img className=" h-12" src={tmdbLogoUrl} 
                                    alt="Not Found" />
                                <h1 className="text-3xl opacity-75">{movie.vote_average}<span className="opacity-50 text-xs">/10</span></h1>
                            </div>
                            <div className="flex items-center gap-4">
                                <Logo iconHeight="h-16" />
                                <h1 className="text-3xl opacity-75">{(movie.vote_average / 2).toFixed(1)}<span className="opacity-50 text-xs">/5</span></h1>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="flex flex-col font-openSans">
                    <Divider title="Overview"/>
                    <p className="p-7 text-lg leading-relaxed">{movie.overview}</p>
                </div>
            </div>

        )
    }

}

export default MovieInfo;
