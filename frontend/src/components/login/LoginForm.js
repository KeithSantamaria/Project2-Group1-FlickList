import React, {useState, useEffect} from 'react'
import axios from 'axios';
import { useSelector, useDispatch } from 'react-redux'

import * as actions from '../../redux/actions';

function LoginForm(props) {
  const [usernameInput, setUsernameInput] = useState("");
  const [passwordInput, setPasswordInput] = useState("");
  const [resp, setResp] = useState(null);

  const state = useSelector(state => state);
  const dispatch = useDispatch()

  useEffect(() => {
    console.log(state);
  }, [state])

  const handleLogin = () => {
    const loginInfo = {
      username : usernameInput,
      password : passwordInput
    };
    axios.post("http://localhost:8080/users/login", loginInfo)
    .then( res => {
      if (res.status === 200){
        setResp(res.data);
      }
    })
    .catch( error => {
      console.log("Log in failed");
    })

    if(resp !== null){
      dispatch(
        {
          type: actions.CURRENT_USER_STORED,
          payload : resp
        }
      )
    }
  }

  return (
    <div >
      <div className ="flex justify-center">
        <h1>Log in Here!</h1>
      </div>
      <div className ="flex justify-center">
        <span>Username : </span>
        <input type = "text" value = {usernameInput} onChange = {(e) => {setUsernameInput(e.target.value)}}/>
      </div>
      <div className ="flex justify-center">
        <span>Password : </span>
        <input type = "password" value ={passwordInput} onChange = {(e) => {setPasswordInput(e.target.value)}}/>
      </div>
      <div className ="flex justify-center">
        <button className = "bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" onClick = {() => {handleLogin()}}> Log in</button>
      </div>
    </div>
  )
}

export default LoginForm;
