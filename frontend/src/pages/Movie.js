import React from 'react'
import { useParams } from 'react-router';
import NavBar from '../components/navigation/NavBar';
import MovieInfo from '../components/movie/MovieInfo';

function Movie() {
  const {movieId} = useParams();
  return (
    <div>
      <NavBar/>
      <MovieInfo/>
    </div>
  )
}

export default Movie;
