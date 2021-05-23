import { createStore } from 'redux';
import reviewReducer from './reviewReducer';


const store = createStore(reviewReducer);

export default store;