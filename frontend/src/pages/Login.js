import React, {useState} from 'react'

import Logo from '../components/Logo';
import LoginForm from '../components/login/LoginForm';
import SignUpForm from '../components/login/SignUpForm';
import ToggleAuthMode from '../components/login/ToggleAuthMode';

function Login() {
  const [authMode, setAuthMode] = useState(true);

  return (
    <div >
      <div className ="flex justify-center">
        <span>Welcome to</span>
        <Logo textSize="text-x3" iconHeight="h-36"/>
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
