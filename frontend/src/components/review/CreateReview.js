import React, { useState } from 'react'
import { reviewAdded } from '../../redux/actioncreators/reviewCreators.js';
import axios from 'axios';

export default function CreateReview(props) {

    const [review, setReview] = useState({});

    const saveReview = (event) => {
        axios.post('http:localhost:8080/reviews', {...review}).then(response => { reviewAdded(response); });
    }

    return (
            <div>
                <h3>rating:</h3>
                {/* <input type='hidden' name='user' value={props.userInfo.id}/> */}
                <fieldset>
                    <input className="review" onChange={e => setReview({ ...review, rating: e.target.value})} type="radio" id="onestar" name="rating" value="1"/>
                    <label className="review" for="onestar">one star</label>
                    <input className="review" onChange={e => setReview({ ...review, rating: e.target.value})} type="radio" id="twostar" name="rating" value="2"/>
                    <label className="review" for="twostar">two stars</label>
                    <input className="review" onChange={e => setReview({ ...review, rating: e.target.value})}type="radio" id="threestar" name="rating" value="3"/>
                    <label className="review" for="threestar">three stars</label>
                    <input className="review" onChange={e => setReview({ ...review, rating: e.target.value})} type="radio" id="fourstar" name="rating" value="4"/>
                    <label className="review" for="fourstar">four stars</label>
                    <input className="review" onChange={e => setReview({ ...review, rating: e.target.value})} type="radio" id="fivestar" name="rating" value="5"/>
                    <label className="review" for="fivestar">five stars</label>
                </fieldset>
                <fieldset>
                    <label className="review" for='review-title'>Title</label>
                    <input className="review" onChange={e => setReview({ ...review, title: e.target.value})} type='text' name='title' id='review-title-input' placeholder="give your review a title" />
                    <label className="review" for='review-body'>Text</label>
                    <textarea className="review" onChange={e => setReview({ ...review, textBody: e.target.value})} name='textBody' id='review-body-input'/>
                </fieldset> 
                <button onClick = {saveReview}>Save</button>
            </div>
    );
}

