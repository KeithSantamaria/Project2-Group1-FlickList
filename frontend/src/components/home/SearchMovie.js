import React from 'react'

function SearchMovie() {
    const backgroundImg = "https://www.themoviedb.org/t/p/original/rAiYTfKGqDCRIIqo664sY9XZIvQ.jpg";
    return (
        <div className="h-96 rounded-xl " style={{
            backgroundImage: `url(${backgroundImg})`,
            backgroundSize: "cover"
        }} >
            <div className="flex flex-col h-full bg-primary rounded-xl opacity-25">
                <div className=" bg-opacity-0">
                    <h1 className="text-5xl text-white">Welcome</h1>
                    <div>

                    </div>
                </div>

            </div>
        </div>
    )
}

export default SearchMovie
