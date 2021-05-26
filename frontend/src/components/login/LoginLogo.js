import React from 'react'
import { CollectionIcon } from '@heroicons/react/solid';

function LoginLogo(props) {
	return (
		<div>
			<CollectionIcon className={`text-primary ${props.iconHeight}`}></CollectionIcon>
			<h1 className={`font-openSans font-extrabold
				py-4 px-1
				text-primary ${props.textSize}`}>
				Flick.
			</h1>
		</div>
	)
}

export default LoginLogo;