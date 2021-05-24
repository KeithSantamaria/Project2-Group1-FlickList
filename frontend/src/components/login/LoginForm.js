import React, {useState} from 'react'
import axios from 'axios';

function LoginForm(props) {
  const [usernameInput, setUsernameInput] = useState("");
  const [passwordInput, setPasswordInput] = useState("");
  const [respData, setRespData] = useState(null);

  const handleLogin = () => {
    const loginInfo = {
      username : usernameInput,
      password : passwordInput
    };
    axios.post("http://localhost:8080/users/login", loginInfo)
    .then( res => {
      if (res.status === 200){
        console.log(res.data);
      }
    })
    .catch( error => {
      console.log("Log in failed");
    })
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
