import React, { useState } from 'react'
import StarComponent from './StarComponent';


function RatingStarSelector(props) {

    const [tempRating, setTempRating] = useState(0);
    
    const {currentRating,setCurrentRating} = props;

    const values =  [1,2,3,4,5];

    return (
        <div className="flex gap-6">
            <div className="flex text-gray-400 items-top ">
              {
                    values.map((value,index)=>{
                        return <StarComponent key={index} value={value} setTempRating={setTempRating} tempRating={tempRating} currentRating={currentRating} 
                        setCurrentRating={setCurrentRating}/>
                    })
                }
            </div>
            <h1 className=" w-48 self-center text-center font-bold opacity-50">It's a hollywood flick!</h1>
        </div>
    )
}

export default RatingStarSelector
