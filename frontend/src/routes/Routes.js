import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";

const Routes = () => {

  return(
    <Router>
      <Switch>
        <Route path = "/" exact> 
          <p>Base Route</p>
        </Route>
        <Route path = "/login">
          <p>login and signin here</p>
        </Route>
        <Route path = "*">
          <p>Sorry page not found :(</p>
        </Route>
      </Switch>
    </Router>
  )
}

export default Routes;