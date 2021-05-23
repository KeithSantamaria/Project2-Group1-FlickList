import React from 'react'
import NavUserMenu from './NavUserMenu'

function NavProfile(props) {
    return (
        <div className="flex items-center gap-2">
            <NavUserMenu userId={props.userId} />
            <div className="flex flex-col text-xs font-openSans">
                <h6 className=" font-bold">{props.firstName} {props.lastName}</h6>
                <h6 className="text-gray-400">{props.email}</h6>
            </div>
        </div>
    )
}

export default NavProfile
