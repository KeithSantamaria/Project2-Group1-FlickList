import React, { useState, useEffect } from 'react'
import axios from 'axios';
import { useParams } from 'react-router';
import { useSelector, useDispatch } from 'react-redux';

import * as actions from '../redux/actions';
import Navbar from '../components/navigation/NavBar';
import ProfileTitle from '../components/profile/ProfileTitle';
import ProfileAccountDetails from '../components/profile/ProfileAccountDetails';

function Profile() {
  //TODO use axios to fetch sanitized user data
  const { userId } = useParams();

  const state = useSelector(state => state);
  const dispatch = useDispatch()

  const [updateFlag, setUpdateFlag] = useState(false);
  const [currentUser, setCurrentUser] = useState(state.currentUser)
  const [resp, setResp] = useState(currentUser);

  useEffect(() => {
    console.log(currentUser);
    if (updateFlag) {
      axios.put("http://localhost:8080/users", currentUser)
        .then(res => {
          if (res.status === 200) {
            setResp(res.data);
          }
        })
        .catch(error => {
          console.log("Could not update: ", error)
        })
      dispatch(
        {
          type: actions.CURRENT_USER_STORED,
          payload: resp
        }
      )
      setCurrentUser(state.currentUser);
      setUpdateFlag(false);
    }
  }, [currentUser])

  return (
    <div>
      <Navbar />
      <div className="flex justify-center my-10 font-openSans">
        <div className="flex flex-col flex-grow max-w-screen-lg gap-6 px-20">
          <ProfileTitle userId={currentUser.username} />
          <ProfileAccountDetails userInfo={currentUser} setUserInfo={setCurrentUser} setUpdate={setUpdateFlag} />
        </div>
      </div>
    </div>
  )
}

export default Profile;
