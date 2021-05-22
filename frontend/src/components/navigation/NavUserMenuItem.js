import React from 'react'
import { Menu } from '@headlessui/react';

const { Item } = Menu;

function NavUserMenuItem(props) {

    const { url, name } = props;

    return (
        <Item>
            {({ active }) => (
                <a href={url}>
                    <button
                        className={`${active
                            ? 'bg-primary text-white'
                            : 'text-gray-90'
                            } whitespace-nowrap px-4 py-2 w-40 rounded-lg focus:outline-none`}
                    >
                        {name}
                    </button>
                </a>
            )}
        </Item>
    )
}

export default NavUserMenuItem
