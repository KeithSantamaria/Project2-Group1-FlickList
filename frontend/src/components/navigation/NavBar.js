import React from 'react';
import Logo from '../Logo';
import NavProfile from './NavProfile';
import { useSelector} from 'react-redux';


function NavBar() {

    const user = useSelector(state=>state.currentUser);

    return (
        <nav>
            <div className="flex justify-center bg-white border">
                <div className="flex flex-grow max-w-screen-lg justify-between px-20 text-xl">
                    <Logo textSize="text-xl" iconHeight="h-8">
                    </Logo>
                    <NavProfile firstName={user.firstName} lastName={user.lastName} email={user.email} userId={user.id}>
                    </NavProfile>
                </div>
            </div>
        </nav>
    )
}

export default NavBar;
