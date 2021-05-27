import React from 'react'

import { StarIcon } from '@heroicons/react/solid';

function StarComponent(props) {

    const { value, tempRating,setTempRating,currentRating,setCurrentRating} = props;

    return (
        <StarIcon
            onMouseOver={() => {
                setTempRating(value);
            }}
            onMouseLeave={() => {
                setTempRating(0);
            }}
            onClick={()=>{
                setCurrentRating(value);
            }}
            className={`h-8 cursor-pointer
                        ${tempRating >= value
                            ? "text-primary"
                            : ""
                        }
                        ${currentRating >= value
                            ? "text-primary"
                            : ""
                        }`} />
    )
}

export default StarComponent;
