import React, {useState} from 'react'
import { SearchIcon } from '@heroicons/react/solid'






function SearchBar(props) {
    const [tempQuery,setTempQuery] = useState(null);

    const enterPressed = (event) =>{
        if(event.charCode === 13){
            props.setQuery(tempQuery);
        }
    };

    return (
        <div className=" flex flex-col justify-center
                    p-20 gap-6
                    h-64 rounded-xl shadow-xl
                ">
            <h1 className="font-openSans text-6xl text-primary">Welcome.</h1>
            <div className="flex rounded-full justify-between bg-white">
                <input className="rounded-full outline-none flex-grow px-5
                    " 
                    placeholder="Search for movies.."
                    onKeyPress={(event)=>{
                        enterPressed(event);
                    }}
                    onChange={(event)=>{
                        setTempQuery(event.target.value);
                    }} ></input>
                <button className="flex bg-primary p-4 rounded-full font-openSans gap-5 
                    text-white focus:outline-none hover:shadow-2xl"
                    onClick={(event)=>props.setQuery(tempQuery)}>
                    <h1>Search</h1>
                    <SearchIcon className="h-6 " />
                </button>

            </div>

        </div>
    )
}

export default SearchBar
