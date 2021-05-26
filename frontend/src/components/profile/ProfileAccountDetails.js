import React, {useState} from 'react'

import AccountDetailRow from './AccountDetailRow';

function ProfileAccountDetails(props) {
  const [changedFirst,setFirstName] = useState(props.userInfo.firstName);
  const [changedLast,setLastName] = useState(props.userInfo.lastName);
  const [changedEmail,setEmail] = useState(props.userInfo.email);


  const handleUpdateProfile = () => {
    const newProfile = {
      id: props.userInfo.id,
      username : props.userInfo.username,
      firstName : changedFirst,
      lastName: changedLast,
      email : changedEmail,
      password: props.userInfo.password
    }
    console.log(newProfile);
    props.setUserInfo(newProfile)
    props.setUpdate(true);
  }

  return (
    <div className="profile flex justify-center">
      <div className="content-wrapper">
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
