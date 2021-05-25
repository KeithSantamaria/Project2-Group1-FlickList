package com.flicklist.service.tmdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;

public class TmdbService implements ITmdbApi {



    @Value("#{environment.TMDB_SECRET}")
    private String tmdbKey;

    private WebClient webClient;

    public TmdbService(String baseUrl){
        this.webClient = WebClient.create(baseUrl);
    }

    @Override
    public ResponseEntity<String> getTrending() {
        try{
            return webClient
                    .get()
                    .uri("/trending/movie/week?api_key="+tmdbKey)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .toEntity(String.class)
                    .block();
        }catch(Exception exception){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<String> getMovieById(String id) {
        try{
            return webClient
                    .get()
                    .uri("/movie/" + id + "?api_key="+tmdbKey)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .toEntity(String.class)
                    .block();
        }catch(Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<String> searchByMovie(String movie) {
        try{
            return webClient
                    .get()
                    .uri("/search/movie?api_key="+tmdbKey+"&query="+movie+"&page=1&include_adult=false")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .toEntity(String.class)
                    .block();
        }catch(Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}
