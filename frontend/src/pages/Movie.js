import React ,{useState,useEffect} from 'react'
import { useParams } from 'react-router';
import NavBar from '../components/navigation/NavBar';
import MovieInfo from '../components/movie/MovieInfo';
import axios from 'axios';

function Movie() {
  const { movieId } = useParams();
  const [movie,setMovie] = useState({});

  useEffect(()=>{
    axios.get(`http://localhost:8080/tmdb/movie/${movieId}`)
      .then((response)=>{
        setMovie(response.data);
      })
  },[])

  return (
    <div>
      <NavBar />
      <div className="flex justify-center my-10">
        <div className="flex flex-col flex-grow max-w-screen-lg gap-6 px-20">
          <MovieInfo movie={movie}/>
        </div>
      </div>
    </div>
  )
}

export default Movie;
