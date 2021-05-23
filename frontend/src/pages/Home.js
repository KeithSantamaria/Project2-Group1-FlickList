import React from 'react';
import TrendingMovies from '../components/home/TrendingMovies';
import NavBar from '../components/navigation/NavBar';

function Home() {
  return (
    <div>
      <NavBar/>
      <TrendingMovies/>
    </div>

  )
}

export default Home;
