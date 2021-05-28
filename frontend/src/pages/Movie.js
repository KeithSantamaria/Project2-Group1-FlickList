import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router';
import NavBar from '../components/navigation/NavBar';
import MovieInfo from '../components/movie/MovieInfo';
import axios from 'axios';
import MovieReviews from '../components/movie/MovieReviews';

function Movie() {
  const { movieId } = useParams();
  const [movie, setMovie] = useState({});
  const [reviews, setReviews] = useState([]);

  useEffect(() => {
    axios.get(`http://localhost:8080/tmdb/movie/${movieId}`)
      .then((response) => {
        setMovie(response.data);
      }).catch((error) => {
        console.log(error);
      });
    axios.get(`http://localhost:8080/reviews/movie/${movieId}`)
      .then((response) => {
        setReviews(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [])// eslint-disable-line react-hooks/exhaustive-deps

  return (
    <div>
      <NavBar />
      <div className="flex justify-center my-10">
        <div className="flex flex-col flex-grow max-w-screen-lg gap-6 px-20">
          <MovieInfo movie={movie} reviews={reviews} />
          <MovieReviews movie={movie} reviews={reviews} setReviews={setReviews} />
        </div>
      </div>
    </div>
  )
}

export default Movie;
