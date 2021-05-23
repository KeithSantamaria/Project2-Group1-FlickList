import React from 'react';
import { UserCircleIcon } from '@heroicons/react/outline';
import { ChevronDownIcon } from '@heroicons/react/solid';
import { Menu, Transition } from '@headlessui/react';
import NavUserMenuItem from './NavUserMenuItem';

function NavUserMenu(props) {
    return (
        <div className="relative z-10">
            <Menu>
                <Menu.Button className="focus:outline-none">
                    <div className="flex items-center">
                        <ChevronDownIcon className="h-3 text-gray-400" />
                        <UserCircleIcon className="h-10 text-gray-400" />
                    </div>
                </Menu.Button>
                <Transition
                    enter="transition ease-out duration-100"
                    enterFrom="transform opacity-0 scale-95"
                    enterTo="transform opacity-100 scale-100"
                    leave="transition ease-in duration-75"
                    leaveFrom="transform opacity-100 scale-100"
                    leaveTo="transform opacity-0 scale-95"
                >
                    <Menu.Items className="absolute flex flex-col rounded-lg bg-white shadow-2xl border">
                        <NavUserMenuItem url={`/profile/${props.userId}`} name="Profile"></NavUserMenuItem>
                        <NavUserMenuItem url={`/reviews/${props.userId}`} name="My Reviews"></NavUserMenuItem>
                        <NavUserMenuItem url="/logout" name="Log Out"></NavUserMenuItem>
                    </Menu.Items>
                </Transition>
            </Menu>
        </div>

    )
}

export default NavUserMenu;