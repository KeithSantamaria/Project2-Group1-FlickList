import React, {useState, useEffect} from 'react'
import { useSelector, useDispatch } from 'react-redux'
import {useHistory} from 'react-router-dom';
import axios from 'axios';

import * as actions from '../../redux/actions';

const SignUpForm = (props) => {
  const [usernameInput, setUsernameInput] = useState("");
  const [passwordInput, setPasswordInput] = useState("");
  const [firstNameInput, setFirstNameInput] = useState("");
  const [lastNameInput, setLastNameInput] = useState("");
  const [emailNameInput, setEmailNameInput] = useState("");

  const [resp, setResp] = useState(null);


  const history = useHistory();
  const state = useSelector(state => state);
  const dispatch = useDispatch()

  useEffect(() => {
    console.log(state);
  }, [state])

  const handleSubmit = () => {
    const newUser = {
      "username": usernameInput,
      "password": passwordInput,
      "firstName": firstNameInput,
      "lastName": lastNameInput,
      "email": emailNameInput
    }
    if ( usernameInput !== "" && passwordInput !== ""){
      axios.post("http://localhost:8080/users", newUser)
      .then( res => {
        if (res.status === 200){
          setResp(res.data);
        }
      })
      dispatch(
        {
          type: actions.CURRENT_USER_STORED,
          payload : resp
        }
      )
    }
    else{
      alert("Enter a username and password!");
    }
  }

  return (
    <div>
      <div className ="flex justify-center">
        <h1>Sign up</h1>
      </div>

      <form >
        <div className ="flex justify-center">
          <h2>Required: </h2>
        </div>

        <div className ="flex justify-center">
          <span>Username : </span>
          <input required type = "text" value = {usernameInput} onChange = {(e) => {setUsernameInput(e.target.value)}}/>

          <span>Password : </span>
          <input required type = "password" value ={passwordInput} onChange = {(e) => {setPasswordInput(e.target.value)}}/>
        </div>

        <div className ="flex justify-center">
          <h2> Optional: </h2>
        </div>

        <div className ="flex justify-center">
          <span>First Name : </span>
          <input type = "text" value = {firstNameInput} onChange = {(e) => {setFirstNameInput(e.target.value)}}/>
        
          <span>Last Name : </span>
          <input type = "text" value = {lastNameInput} onChange = {(e) => {setLastNameInput(e.target.value)}}/>

          <span>Email :</span>
          <input type = "email" value = {emailNameInput} onChange = { (e) => {setEmailNameInput(e.target.value)}}/>
        </div>

      </form>
      <div className ="flex justify-center">
        <button className = "bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" onClick = {() => {handleSubmit()}}>Sign Up!</button>
      </div>
    </div>
  )
}

export default SignUpForm;
