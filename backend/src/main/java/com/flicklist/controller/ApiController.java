package com.flicklist.controller;

import com.flicklist.service.tmdb.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;


@RestController
@RequestMapping("/tmdb")
public class ApiController {

    @Value("#{environment.TMDB_SECRET}")
    private String tmdbKey;

    @Autowired
    private TmdbService tmdbService;


    @GetMapping("/trending")
    public ResponseEntity<String> getTrending() {

        return tmdbService.getTrending();

    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<String> getMovieById(@PathVariable String id){
        return tmdbService.getMovieById(id);
    }

    @GetMapping("/search/{movie}")
    public ResponseEntity<String> serachMovie(@PathVariable String movie){
        return tmdbService.searchByMovie(movie);
    }



}
