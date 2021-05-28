package com.flicklist.controller;

import com.flicklist.service.tmdb.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;


/**
 * @ClassName ApiController
 *
 * @Purpose The following class is used to communicate with the tmdb api. Each end point will be clarified below
 */

@RestController
@RequestMapping("/tmdb")
public class ApiController {

    @Value("#{environment.TMDB_SECRET}")
    private String tmdbKey;

    @Autowired
    private TmdbService tmdbService;

    /**
     * @FunctionName getTrending
     *
     * @return returns the response object that contains all of the currently trending movies as defined by tmdb
     */
    @GetMapping("/trending")
    public ResponseEntity<String> getTrending() {

        return tmdbService.getTrending();

    }

    /**
     * @FunctionName getMovieById
     * @param id : the tmdb unique id associated with a particular movie
     * @return returns the response object that contains a single movie with that unique id
     */
    @GetMapping("/movie/{id}")
    public ResponseEntity<String> getMovieById(@PathVariable String id){
        return tmdbService.getMovieById(id);
    }

    /**
     * @FunctionName serachMovie
     * @param movie : the name of whatever term the user input in the search bar
     * @return returns the response object that contains a list of every movie in tmdb that contains that term
     */
    @GetMapping("/search/{movie}")
    public ResponseEntity<String> serachMovie(@PathVariable String movie){
        return tmdbService.searchByMovie(movie);
    }



}
