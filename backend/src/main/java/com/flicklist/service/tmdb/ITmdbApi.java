package com.flicklist.service.tmdb;

import org.springframework.http.ResponseEntity;

public interface ITmdbApi {

    ResponseEntity<String> getTrending();
    ResponseEntity<String> getMovieById(String id);
    ResponseEntity<String> searchByMovie(String movie);

}
