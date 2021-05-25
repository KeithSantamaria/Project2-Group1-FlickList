import React from 'react'
import { reviewAdded } from '../../redux/actioncreators/reviewCreators.js';

export default function CreateReview(props) {

    const saveReview = (event) => {
        event.preventDefault();
        var form = event.target;
        var formData = new FormData(form);
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                const responseData = JSON.parse(this.responseText);
                console.log(responseData);
                reviewAdded(responseData['id'], responseData['userId'], responseData['movieId'], responseData['date'], responseData['rating'], responseData['title'], responseData['textBody']);
            } 
        };
        xhr.open('POST', form.getAttribute('action'));
        xhr.setRequestHeader("accept","application/json");
        xhr.send(formData);
    }

    return (
        <form onSubmit={saveReview} method='post' action=''>
            <h3>rating:</h3>
            {/* <input type='hidden' name='user' value={props.userInfo.id}/> */}
            <fieldset>
                <input className="review" type="radio" id="onestar" name="rating" value="1"/>
                <label className="review" for="onestar">one star</label>
                <input className="review" type="radio" id="twostar" name="rating" value="2"/>
                <label className="review" for="twostar">two stars</label>
                <input className="review" type="radio" id="threestar" name="rating" value="3"/>
                <label className="review" for="threestar">three stars</label>
                <input className="review" type="radio" id="fourstar" name="rating" value="4"/>
                <label className="review" for="fourstar">four stars</label>
                <input className="review" type="radio" id="fivestar" name="rating" value="5"/>
                <label className="review" for="fivestar">five stars</label>
            </fieldset>
            <fieldset>
                <label className="review" for='review-title'>Title</label>
                <input className="review" type='text' name='title' id='review-title' placeholder="give your review a title" />
                <label className="review" for='review-body'>Text</label>
                <textarea className="review" name='textBody' id='review-body'/>
            </fieldset> 
        </form>
    );
}