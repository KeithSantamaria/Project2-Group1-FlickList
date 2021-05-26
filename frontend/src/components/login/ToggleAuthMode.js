import React from 'react'

function ToggleAuthMode(props) {

  return (
    <div className ="auth flex justify-center">
      <button className = "auth bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" onClick = {() => props.setAuthMode(true)}>Log in</button>
      <button className = "auth bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" onClick = {() => props.setAuthMode(false)}>Sign up</button>
    </div>
  )
}

export default ToggleAuthMode;
