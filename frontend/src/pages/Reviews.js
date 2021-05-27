import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router';
import NavBar from '../components/navigation/NavBar';
import Divider from '../components/Divider'
import UserReviewCard from '../components/review/UserReviewCard';
import axios from 'axios';

function Reviews() {
  const { userId } = useParams();
  const [reviews, setReviews] = useState([]);

  useEffect(() => {
    axios.get(`http://localhost:8080/reviews/user/${userId}`)
      .then((response) => {
        setReviews(response.data);
      })
  }, []);// eslint-disable-line react-hooks/exhaustive-deps

  return (
    <div>
      <NavBar />
      <div className="flex justify-center my-10 font-openSans">
        <div className="flex flex-col flex-grow max-w-screen-lg gap-6 px-20">
          <Divider title="My Reviews" />
          <div className="flex flex-col-reverse gap-6">
            {
              reviews.length === 0
                ? "No Reviews have been made"
                : reviews.map((review,index) => {
                  return <UserReviewCard key={index} review={review} currentReviewIndex={index} reviews={reviews} setReviews={setReviews} />
                })
            }
          </div>
        </div>
      </div>
    </div>
  )
}

export default Reviews;
