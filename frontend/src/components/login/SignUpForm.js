import React, {useState} from 'react'
import {useHistory} from 'react-router-dom';
import axios from 'axios';

function SignUpForm() {
  const [usernameInput, setUsernameInput] = useState("");
  const [passwordInput, setPasswordInput] = useState("");
  const [firstNameInput, setFirstNameInput] = useState("");
  const [lastNameInput, setLastNameInput] = useState("");
  const [emailNameInput, setEmailNameInput] = useState("");

  const history = useHistory();

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
          console.log(res.data);
        }
      })
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
        <div className ="flex justify-center">
          <button className = "bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" onClick = {() => {handleSubmit()}}>Sign Up!</button>
        </div>
      </form>

    </div>
  )
}

export default SignUpForm;
