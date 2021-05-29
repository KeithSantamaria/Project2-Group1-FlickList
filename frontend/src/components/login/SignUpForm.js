import React, { useState, useEffect } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { useHistory } from 'react-router-dom';
import axios from 'axios';

import * as actions from '../../redux/actions';

const SignUpForm = (props) => {
  const [usernameInput, setUsernameInput] = useState("");
  const [passwordInput, setPasswordInput] = useState("");
  const [firstNameInput, setFirstNameInput] = useState("");
  const [lastNameInput, setLastNameInput] = useState("");
  const [emailNameInput, setEmailNameInput] = useState("");

  const [signedUp, setSignedUp] = useState(false);

  const [resp, setResp] = useState(null);


  const history = useHistory();
  const state = useSelector(state => state);
  const dispatch = useDispatch()

  useEffect(() => {
    console.log(state);
  }, [state])

  useEffect(() => {
    if (resp !== null) {
      dispatch(
        {
          type: actions.CURRENT_USER_STORED,
          payload: resp
        }
      )
      history.push("/");
    }
  }, [signedUp])

  const handleSubmit = () => {
    const newUser = {
      "username": usernameInput,
      "password": passwordInput,
      "firstName": firstNameInput,
      "lastName": lastNameInput,
      "email": emailNameInput
    }
    if (usernameInput !== "" && passwordInput !== "") {
      axios.post("http://localhost:8080/users", newUser)
        .then(res => {
          if (res.status === 200) {
            setResp(res.data);
            setSignedUp(true)
          }
        })
    }
    else {
      alert("Enter a username and password!");
    }
  }

  return (
    <div className="flex flex-col p-14 gap-4">
      <h1 className="font-bold text-2xl self-center">Sign up</h1>
      <div className="flex gap-5 items-center justify-between">
        <label className="text-sm font-bold opacity-75">Username : </label>
        <input className="border p-1 rounded-sm" required type="text" value={usernameInput} onChange={(e) => { setUsernameInput(e.target.value) }} />
      </div>
      <div className="flex gap-5 items-center justify-between">
        <label className="text-sm font-bold opacity-75">Password : </label>
        <input className="border p-1 rounded-sm" required type="password" value={passwordInput} onChange={(e) => { setPasswordInput(e.target.value) }} />
      </div>
      <div className="flex gap-5 items-center justify-between">
        <label className="text-sm font-bold opacity-75">First Name : </label>
        <input className="border p-1 rounded-sm" type="text" value={firstNameInput} onChange={(e) => { setFirstNameInput(e.target.value) }} />
      </div>
      <div className="flex gap-5 items-center justify-between">
        <label className="text-sm font-bold opacity-75">Last Name : </label>
        <input className="border p-1 rounded-sm" type="text" value={lastNameInput} onChange={(e) => { setLastNameInput(e.target.value) }} />
      </div>

      <div className="flex gap-5 items-center justify-between">
        <label className="text-sm font-bold opacity-75">Email :</label>
        <input className="border p-1 rounded-sm" type="email" value={emailNameInput} onChange={(e) => { setEmailNameInput(e.target.value) }} />
      </div>
      <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" onClick={() => { handleSubmit() }}>Sign Up!</button>

    </div>
  )
}

export default SignUpForm;
