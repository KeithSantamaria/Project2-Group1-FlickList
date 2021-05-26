import React from 'react'
import { FilmIcon } from '@heroicons/react/solid';
import { Link } from 'react-router-dom';


// HOW TO USE
//{iconHeight} send a height in tailwind css format to make icon appear
//{textSize} send a text size in tailwind css format to change the logo text size

function Logo(props) {
    return (
        <Link to="/" className="flex items-center">
            <FilmIcon className={`text-primary ${props.iconHeight}`}></FilmIcon>
            <h1 className={`font-openSans font-extrabold
                py-4 px-1
                text-primary ${props.textSize}`}>
                FlickList
            </h1>
        </Link>
    )
}

export default Logo;
