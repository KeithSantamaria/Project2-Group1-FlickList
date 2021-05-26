import React, {useState} from 'react'

import LoginLogo from '../components/login/LoginLogo';
import LoginForm from '../components/login/LoginForm';
import SignUpForm from '../components/login/SignUpForm';
import ToggleAuthMode from '../components/login/ToggleAuthMode';

function Login() {
  const [authMode, setAuthMode] = useState(true);

  return (
    <div >
      <div className ="flex justify-center">
        <h1>Welcome to FlickList</h1>
      </div>
      <div className ="flex justify-center">
        <LoginLogo textSize="text-x3" iconHeight="h-36"/>
      </div>
        <ToggleAuthMode setAuthMode = {setAuthMode}/>
        {
          authMode ? (
            <LoginForm/>
          ):
          (
            <SignUpForm/>
          )
        }

    </div>
  )
}

export default Login;
