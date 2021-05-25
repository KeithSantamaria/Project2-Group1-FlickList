import React from 'react'
import {CollectionIcon} from '@heroicons/react/solid';


// HOW TO USE
//{iconHeight} send a height in tailwind css format to make icon appear
//{textSize} send a text size in tailwind css format to change the logo text size

function Logo(props) {
    return (
        <div className="flex items-center">
            <CollectionIcon className={`text-primary ${props.iconHeight}`}></CollectionIcon>
            <h1 className={`font-openSans font-extrabold
                py-4 px-1
                text-primary ${props.textSize}`}>
                    Flick.
            </h1>
        </div>
    )
}

export default Logo;
