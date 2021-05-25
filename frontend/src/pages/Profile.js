import React, {useState} from 'react'
import { useParams } from 'react-router';
import { useSelector, useDispatch } from 'react-redux';

import Navbar from '../components/navigation/NavBar';
import ProfileTitle from '../components/profile/ProfileTitle';
import ProfileAccountDetails from '../components/profile/ProfileAccountDetails';

function Profile() {
  //TODO use axios to fetch sanitized user data
  const {userId} = useParams();

  const [testUser, setTestUser] = useState(
      {
        userName : "UserName",
        firstName : "First",
        lastName: "Name",
        email : "email.@email.com",
        id: "testId"
      }
    )


  return (
    <div>
      <Navbar/>
      <div>
        <ProfileTitle userId = {testUser.userName}/>
        <ProfileAccountDetails userInfo = {testUser} setUserInfo = {setTestUser}/>
      </div>
    </div>
  )
}

export default Profile;
