import React from 'react'
import { Menu } from '@headlessui/react';
import { Link } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import * as actions from '../../redux/actions';

const { Item } = Menu;

function NavUserMenuItem(props) {

    const dispatch = useDispatch()

    const { url, name } = props;

    const handleReroute = () => {
        if(url === "/logout"){
					dispatch(
						{
							type: actions.CURRENT_USER_STORED,
							payload : {}
						}
					)
        }   
        return null;
    }

    return (
        <Item>
            {({ active }) => (
                <Link to={url}>
                    <button
                        onClick= {() => {handleReroute()}}
                        className={`${active
                            ? 'bg-primary text-white'
                            : 'text-gray-90'
                            } whitespace-nowrap px-4 py-2 w-40 focus:outline-none`}
                    >
                        {name}
                    </button>
                </Link>
            )}
        </Item>
    )
}

export default NavUserMenuItem
