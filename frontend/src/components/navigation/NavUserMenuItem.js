import React from 'react'
import { Menu } from '@headlessui/react';
import { Link } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import * as actions from '../../redux/actions';

const { Item } = Menu;

function NavUserMenuItem(props) {

    const dispatch = useDispatch()

    const { url, name, icon } = props;

    const handleReroute = () => {
        if (url === "/logout") {
            dispatch(
                {
                    type: actions.CURRENT_USER_STORED,
                    payload: {}
                }
            )
        }
        return null;
    }

    return (
        <Item>
            {({ active }) => (
                <div className={`${active
                    ? 'bg-primary text-white'
                    : ' opacity-95'
                    } whitespace-nowrap px-4 py-2  focus:outline-none rounded-md`}>
                       
                    <Link to={url}
                        className="flex items-center gap-3 text-lg font-openSans"
                        onClick={() => { handleReroute() }}
                        >
                        {icon} 
                        {name}

                    </Link>
                </div>

            )}
        </Item>
    )
}

export default NavUserMenuItem
