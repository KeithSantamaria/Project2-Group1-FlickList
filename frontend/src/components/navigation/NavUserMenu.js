import React from 'react';
import { UserCircleIcon,PencilAltIcon,LogoutIcon,AnnotationIcon} from '@heroicons/react/outline';
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
                    <Menu.Items className="absolute mt-4 flex flex-col rounded-md bg-white p-2 shadow-md">
                        <NavUserMenuItem url={`/profile/${props.userId}`} name="Profile" icon={<PencilAltIcon className="h-5"/>}></NavUserMenuItem>
                        <NavUserMenuItem url={`/reviews/${props.userId}`} name="My Reviews" icon={<AnnotationIcon className="h-5"/>}></NavUserMenuItem>
                        <NavUserMenuItem url="/logout" name="Log Out" icon={<LogoutIcon className="h-5"/>}></NavUserMenuItem>
                    </Menu.Items>
                </Transition>
            </Menu>
        </div>

    )
}

export default NavUserMenu;
