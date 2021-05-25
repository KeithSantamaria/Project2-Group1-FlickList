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

        <div className="flex flex-col gap-4">
            <div className="font-openSans flex justify-between">
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
            <div className={`flex gap-8
                                ${expanded
                    ? "flex-wrap"
                    : "overflow-hidden"
                }`}>
                {trendingMovies.map((movie) => {
                    return <TrendingCard key={movie.id} name={movie.title}
                        movieId={movie.id}
                        imgUrl={`${baseImageUrl}${movie.poster_path}`} />
                })}
            </div>
        </div>


    )
}

export default TrendingMovies;
