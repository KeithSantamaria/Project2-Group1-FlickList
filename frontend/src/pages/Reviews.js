import React from 'react'
import { useParams } from 'react-router';

function Reviews() {
  const {userId} = useParams();
  return (
    <div>
      <p>{userId}</p>
    </div>
  )
}

export default Reviews;
