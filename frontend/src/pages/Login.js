import React, { useState } from 'react'

import LoginLogo from '../components/login/LoginLogo';
import LoginForm from '../components/login/LoginForm';
import SignUpForm from '../components/login/SignUpForm';
import ToggleAuthMode from '../components/login/ToggleAuthMode';

function Login() {
  const [authMode, setAuthMode] = useState(true);

  return (
    <div className="flex justify-center h-screen">
      <div className="flex flex-col flex-grow max-w-screen-lg items-center justify-center font-openSans ">
        <div className="flex items-center">
          <div className="flex bg-white rounded-md shadow-2xl z-10">
            {
              authMode ? (
                <LoginForm />
              ) :
                (
                  <SignUpForm />
                )
            }
          </div>
          <div className="relative flex flex-col items-center bg-primary right-10 rounded-2xl shadow-lg px-20 py-32">
            <LoginLogo textSize="text-3xl" iconHeight="h-32" />
            <h1 className="text-white text-3xl">Welcome to FlickList</h1>

            <ToggleAuthMode setAuthMode={setAuthMode} />
          </div>
        </div>
      </div>
    </div>
  )
}

export default Login;
