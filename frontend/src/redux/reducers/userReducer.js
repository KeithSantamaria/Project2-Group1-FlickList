import * as actions from '../actions.js';

export default function reviewReducer( state = [], action) {
  if (action.type === actions.CURRENT_USER_STORED) {
    return [...state, action.payload] 
  }
}