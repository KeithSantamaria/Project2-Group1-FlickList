import React from 'react';
import TrendingMovies from '../components/home/TrendingMovies';
import NavBar from '../components/navigation/NavBar';

function Home() {
  return (
    <div>
      <NavBar/>
      <div>
        <TrendingMovies/>
      </div>
    </div>

  )
}

export default Home;
