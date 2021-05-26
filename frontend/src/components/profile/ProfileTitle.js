import React from 'react'

function ProfileTitle(props) {
	return (
		<div className="profile flex justify-center">
				<h1 className="profile text-lg font-bold tracking-wide opacity-75" >Welcome {props.userId}</h1>
		</div>
	)
}

export default ProfileTitle;
