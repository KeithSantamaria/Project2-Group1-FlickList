import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";

import Home from '../pages/Home';
import Login from '../pages/Login';
import Movie from "../pages/Movie";
import Profile from '../pages/Profile';
import Reviews from "../pages/Reviews";


const Routes = () => {
  return(
    <Router>
      <Switch>
        <Route path = "/" exact> 
          <Home/>
        </Route>
        <Route path = "/profile/:userId">
          <Profile/>
        </Route>
        <Route path = "/reviews/:userId">
          <Reviews/>
        </Route>
        <Route path = "/movie/:movieId">
          <Movie/>
        </Route>
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