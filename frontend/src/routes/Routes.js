import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";
import { useSelector, useDispatch } from 'react-redux';

import Home from '../pages/Home';
import Login from '../pages/Login';
import Movie from "../pages/Movie";
import Profile from '../pages/Profile';
import Reviews from "../pages/Reviews";

import AuthRoute from './AuthRoute';

const Routes = () => {
  const state = useSelector(state => state);
  const dispatch = useDispatch()

  return(
    <Router>
      <Switch>
        <AuthRoute path = "/" exact = {true} childComponent = {Home} />
        <AuthRoute path = "/profile/:userId" childComponent = {Profile} />
        <AuthRoute path = "/reviews/:userId" childComponent = {Reviews} />
        <AuthRoute path = "/movie/:movieId" childComponent ={Movie} />
        <Route path = "/login">
          <Login/>
        </Route>
        <Route path = "*">
          <Redirect to ="/login"/>
        </Route>
      </Switch>
    </Router>
  )
}

export default Routes;

        
{/* <Route path = "/profile/:userId">
<Profile/>
</Route>
<Route path = "/reviews/:userId">
<Reviews/>
</Route>
<Route path = "/movie/:movieId">
<Movie/>
</Route> */}