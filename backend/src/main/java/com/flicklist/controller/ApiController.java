package com.flicklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
<<<<<<< HEAD
=======
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
>>>>>>> 9d592034e3ba3550c60eb75805b3777e160c3e9c
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
<<<<<<< HEAD
=======
import reactor.core.publisher.Mono;
>>>>>>> 9d592034e3ba3550c60eb75805b3777e160c3e9c

@RestController
@RequestMapping("/tmdb")
public class ApiController {

    @Value("#{environment.TMDB_SECRET}")
    private String tmdbKey;

    @Autowired
    private WebClient webClient;


    @GetMapping("/trending")
    public ResponseEntity<String> getTrending() {

        try{
            return webClient
                    .get()
                    .uri("/trending/movie/week?api_key="+tmdbKey)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .toEntity(String.class)
                    .block();
        }catch(WebClientRequestException exception){
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<String> getMovieById(@PathVariable String id){
        try{
            return webClient
                    .get()
                    .uri("/movie/" + id + "?api_key="+tmdbKey)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .toEntity(String.class)
                    .block();
        }catch(WebClientRequestException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search/{movie}")
    public ResponseEntity<String> serachMovie(@PathVariable String movie){
        try{
            return webClient
                    .get()
                    .uri("/search/movie?api_key="+tmdbKey+"&query="+movie+"&page=1&include_adult=false")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .toEntity(String.class)
                    .block();
        }catch(WebClientRequestException exception) {
            return ResponseEntity.badRequest().build();
        }
    }



}
