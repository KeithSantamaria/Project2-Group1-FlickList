import axios from 'axios';
import React, { useState, useEffect } from 'react'
import SearchBar from './SearchBar'
import SearchResultCard from './SearchResultCard';
import Divider from '../Divider';

function SearchMovie() {

    const [query, setQuery] = useState(null);
    const [results, setResults] = useState([]);

    useEffect(() => {
        if (query != null) {
            axios.get(`http://localhost:8080/tmdb/search/${query}`)
                .then((response) => {
                    setResults(response.data.results);
                    //console.log(response.data.results);
                }).catch((error)=>{
                    console.log(error);
                });
        }
    }, [query])

    return (
        <div className="flex flex-col gap-6 font-openSans">
            <SearchBar query={query} setQuery={setQuery} />
            {query != null &&
                <div className="flex flex-col gap-4">
                    <Divider title="Results"/>
                    {results.map((movie) => {
                        return <SearchResultCard key={movie.id}
                            movieTitle={movie.title}
                            moviePoster={movie.poster_path}
                            movieSummary={movie.overview}
                            movieId={movie.id}
                            movieYear={movie.release_date.split("-")[0]} />
                    })}
                </div>
            }
        </div>

    )
}

export default SearchMovie
