import React from 'react'
import { Menu } from '@headlessui/react';
import { Link } from 'react-router-dom';

const { Item } = Menu;

function NavUserMenuItem(props) {

    const { url, name } = props;

    return (
        <Item>
            {({ active }) => (
                <Link to={url}>
                    <button
                        className={`${active
                            ? 'bg-primary text-white'
                            : 'text-gray-90'
                            } whitespace-nowrap px-4 py-2 w-40 rounded-lg focus:outline-none`}
                    >
                        {name}
                    </button>
                </Link>
            )}
        </Item>
    )
}

export default NavUserMenuItem
