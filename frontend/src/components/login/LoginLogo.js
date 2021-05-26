import React from 'react'
import { FilmIcon } from '@heroicons/react/solid';

function LoginLogo(props) {
	return (
		<div>
			<FilmIcon className={`text-primary ${props.iconHeight}`}></FilmIcon>
			<h1 className={`font-openSans font-extrabold
				py-4 px-1
				text-primary ${props.textSize}`}>
			</h1>
		</div>
	)
}

export default LoginLogo;