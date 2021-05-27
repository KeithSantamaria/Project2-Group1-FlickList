import React from 'react'

function Divider(props) {

    const { title } = props;

    if (title == null) {
        return (
            <div className="flex items-center">
                <div className=" flex-grow h-2 bg-primary rounded-full"></div>
            </div>
        )
    }
    return (
        <div className="flex items-center">
            <h1 className="text-xl font-bold tracking-wide opacity-75 ">{title}</h1>
            <div className=" flex-grow h-2 bg-gradient-to-l from-primary rounded-full"></div>
        </div>
    )
}

export default Divider;
