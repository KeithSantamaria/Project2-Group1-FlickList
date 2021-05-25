import React, {useEffect} from 'react'
import {Route, Redirect} from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';

function AuthRoute(props) {
  const state = useSelector(state => state);
  const dispatch = useDispatch()

  const Child = props.childComponent;
  useEffect(() => {
    console.log(state);
    console.log(state.currentUser);
    if(state.currentUser === {}){
      console.log("Should redirect");
    }
  },[state]);

  if(state.currentUser !== undefined){
    if (props.exact === true){
      return (
        <Route path = {props.path} exact>
          <Child/>
        </Route>
      )
    }
    else{
      return (
        <Route path = {props.path}>
          <Child/>
        </Route>
      )
    }
  }
  else{
    return <Redirect to = '/login' />
  }

}

export default AuthRoute;
