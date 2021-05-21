import React from 'react'
import { useParams } from 'react-router';

function Movie() {
  const {movieId} = useParams();
  return (
    <div>
      <p>{movieId}</p>
    </div>
  )
}

export default Movie;
