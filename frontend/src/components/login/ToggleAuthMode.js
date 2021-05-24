import React from 'react'

function ToggleAuthMode(props) {

  return (
    <div className ="flex justify-center">
      <button className = "bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" onClick = {() => props.setAuthMode(true)}>Log in</button>
      <button className = "bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" onClick = {() => props.setAuthMode(false)}>Sign up</button>
    </div>
  )
}

export default ToggleAuthMode;
