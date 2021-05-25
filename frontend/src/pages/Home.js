import React, {useEffect} from 'react';
import TrendingMovies from '../components/home/TrendingMovies';
import NavBar from '../components/navigation/NavBar';
import { useSelector, useDispatch } from 'react-redux';

function Home() {
  const dispatch = useDispatch()

  return (
    <div>
      <NavBar/>
      <TrendingMovies/>
    </div>

  )
}

export default Home;
