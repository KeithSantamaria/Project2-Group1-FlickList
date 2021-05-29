import React from 'react';
import Divider from '../Divider';
function ProfileTitle(props) {
	return (
		<div>
			<Divider title={`Welcome ${props.userId}`}/>
		</div>
	)
}

export default ProfileTitle;
