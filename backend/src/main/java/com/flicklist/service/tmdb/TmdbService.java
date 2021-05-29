package com.flicklist.service.tmdb;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @ClassName TmdbService
 *
 * @Purpose The following class is used to communicate with the tmdb api
 */
public class TmdbService implements ITmdbApi {

    @Value("#{environment.TMDB_SECRET}")
    private String tmdbKey;

    private WebClient webClient;

    public TmdbService(String baseUrl){
        this.webClient = WebClient.create(baseUrl);
    }

    /**
     * @FunctionName getTrending
     *
     * @return returns all trending movie regarding tmdb
     */
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

    /**
     * @FunctionName getMovieById
     * @param id : id of a movie
     * @return returns a movie with the unique id
     */
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

    /**
     * @FunctionName searchByMovie
     * @param movie : a query
     * @return returns a list of movies according to the search string
     */
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
