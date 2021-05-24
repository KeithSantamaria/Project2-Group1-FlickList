import { createStore } from 'redux';
import reviewReducer from './reducers/reviewReducer';
import userReducer from './reducers/userReducer';

const store = createStore(userReducer);

export default store;