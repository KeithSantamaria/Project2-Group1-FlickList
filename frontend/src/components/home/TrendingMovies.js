import React, { useEffect, useState } from 'react';
import TrendingCard from './TrendingCard';
import axios from 'axios';
import Divider from '../Divider';

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
                <Divider title="Trending This Week"/>
                <button className="text-primary font-bold text-sm opacity-75 focus:outline-none "
                    onClick={() => setExpanded(!expanded)}
                >
                    {
                        expanded
                            ? "Hide All"
                            : "View All"
                    }

                </button>
            </div>
            <div className={`flex gap-7
                                ${expanded
                    ? "flex-wrap"
                    : "overflow-hidden"
                }`}>
                {
                    trendingMovies.map((movie) => {
                        return <TrendingCard key={movie.id} movie={movie}
                            movieId={movie.id}
                            imgUrl={`${baseImageUrl}${movie.poster_path}`} />
                    })
                }
            </div>
        </div>


    )
}

export default TrendingMovies;
