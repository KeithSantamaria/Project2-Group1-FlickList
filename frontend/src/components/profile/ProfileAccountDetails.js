import React, {useState, useEffect} from 'react'

import AccountDetailRow from './AccountDetailRow';

function ProfileAccountDetails(props) {
  const [changedFirst,setFirstName] = useState(props.userInfo.firstName);
  const [changedLast,setLastName] = useState("");
  const [changedEmail,setEmail] = useState("");

  const handleUpdateProfile = () => {
    const newProfile = {
      userName : props.userInfo.userName,
      firstName : changedFirst,
      lastName: changedLast,
      email : changedEmail,
      id: props.userInfo.id
    }

    props.setUserInfo(newProfile)
  }

  useEffect(() => {
    console.log(props.userInfo)
  }, [props.userInfo])

  return (
    <div className="flex justify-center">
      <div>
        <table>
          <tbody>
            <AccountDetailRow title = "ID" entry = {props.userInfo.id} />
            <AccountDetailRow title = "Password" entry = "*****"/>
            <AccountDetailRow title = "First Name" entry = {changedFirst} isEditable = {true} setEntry = {setFirstName}/>
            <AccountDetailRow title = "Last Name" entry = {changedLast} isEditable = {true} setEntry = {setLastName}/>
            <AccountDetailRow title = "Email" entry = {changedEmail} isEditable = {true} setEntry = {setEmail}/>
          </tbody>
        </table>
        <button onClick = {() => {handleUpdateProfile()}}>Confirm Changes</button>
      </div>
    </div>
  )
}

export default ProfileAccountDetails;
