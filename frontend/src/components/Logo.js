import React from 'react'
import {CollectionIcon} from '@heroicons/react/solid';

function Logo() {
    return (
        <div className="flex items-center">
            <CollectionIcon className="h-6 text-primary"></CollectionIcon>
            <h1 className=" font-openSans font-extrabold text-xl
                py-4 px-1
                text-primary">
                    Flick.
            </h1>
        </div>
    )
}

export default Logo;
