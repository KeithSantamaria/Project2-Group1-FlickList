import React from 'react';
import TrendingCard from './TrendingCard';

function TrendingMovies() {
    return (
        <div className="mx-3 my-6 px-10">
            <div className="flex justify-between mb-5 items-end font-openSans">
                <h1 className="text-lg font-bold tracking-wide">Trending This Week</h1>
                <a className="text-primary font-bold text-sm opacity-75"
                    href="test">View All</a>
            </div>
            <div className="flex">
                <TrendingCard/>
            </div>
        </div>

    )
}

export default TrendingMovies;
