import React, { useEffect, useState } from 'react';
import TrendingCard from './TrendingCard';
import axios from 'axios';

function TrendingMovies() {


    const [trendingMovies, setTrendingMovies] = useState([]);
    const [expanded, setExpanded] = useState(false);
    const baseImageUrl = "https://image.tmdb.org/t/p/original"
    useEffect(() => {
        axios.get("http://localhost:8080/tmdb/trending")
            .then((response) => {
                setTrendingMovies(response.data.results);
            }).catch((err) => {
                console.log(err);
            });
    }, []);



    return (
        <div className=" flex justify-center">
            <div className="flex-grow max-w-screen-lg p-10">
                <div className="font-openSans flex justify-between items-end px-10 py-5">
                    <h1 className="text-lg font-bold tracking-wide opacity-75">Trending This Week</h1>
                    <button className="text-primary font-bold text-sm opacity-75"
                        onClick={() => setExpanded(!expanded)}
                    >   
                    {
                        expanded
                        ? "Hide All"
                        : "View All"
                    }

                    </button>
                </div>
                <div className={`flex gap-6 px-10 pb-10
                                ${expanded
                        ? "flex-wrap"
                        : "overflow-hidden"
                    }`}>
                    {trendingMovies.map((movie) => {
                        return <TrendingCard key={movie.id} name={movie.title}
                                movieId={movie.id} 
                                imgUrl={`${baseImageUrl}${movie.poster_path}`}/>
                    })}
                </div>
            </div>
        </div>


    )
}

export default TrendingMovies;
