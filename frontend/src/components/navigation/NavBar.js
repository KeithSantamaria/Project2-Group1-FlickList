import React,{useState} from 'react';
import Logo from '../Logo';
import NavProfile from './NavProfile';

function NavBar() {

    const [firstName,setFirstName] = useState("First");
    const [lastName,setLastName] = useState("Name");
    const [email,setEmail] = useState("email@email.com");
    const [userId, setUserId] = useState("testId");

    return (
        <nav>
            <div className="px-20 bg-white border">
                <div className="flex justify-between">
                    <Logo>
                    </Logo>
                    <NavProfile firstName={firstName} lastName={lastName} email={email} userId={userId}>
                    </NavProfile>
                </div>
            </div>
        </nav>
    )
}

export default NavBar;
