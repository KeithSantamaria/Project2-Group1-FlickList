import React from 'react';
import TrendingMovies from '../components/home/TrendingMovies';
import NavBar from '../components/navigation/NavBar';
import SearchMovie from '../components/home/SearchMovie';

function Home() {

  return (
    <div>
      <NavBar />
      <div className="flex justify-center my-10">
        <div className="flex flex-col flex-grow max-w-screen-lg gap-6 px-20">
          <SearchMovie />
          <TrendingMovies />
        </div>
      </div>
    </div>

  )
}

export default Home;
