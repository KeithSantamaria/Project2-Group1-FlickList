import * as actions from './actions.js';

export function reviewAdded(id, userId, movieId, date, rating, title, textBody) {
    return {
        type: actions.REVIEW_ADDED,
        payload: {
            id, userId, movieId, date, rating, title, textBody
        }
    }
}

export function reviewDeleted(id) {
    return {
        type: actions.REVIEW_DELETED,
        payload: {
            id
        }
    }
}