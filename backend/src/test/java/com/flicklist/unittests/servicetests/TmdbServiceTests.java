package com.flicklist.unittests.servicetests;

import com.flicklist.service.tmdb.TmdbService;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class TmdbServiceTests {
    public static MockWebServer mockBackEnd;
    public static TmdbService tmdbService;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void initialize() {
        String baseUrl = String.format("http://localhost:%s",
                mockBackEnd.getPort());
        tmdbService = new TmdbService(baseUrl);
    }

    @Test
    void getTrending() throws Exception{
        String response = "{\"success\":\"ok\"}";
        mockBackEnd.enqueue(new MockResponse()
            .setBody(response)
            .addHeader("Content-Type","application/json")
            .setResponseCode(200));
        Assertions.assertEquals(HttpStatus.OK,tmdbService.getTrending().getStatusCode());
    }

    @Test
    void getMovieById() throws Exception{
        String response = "{\"success\":\"ok\"}";
        mockBackEnd.enqueue(new MockResponse()
                .setBody(response)
                .addHeader("Content-Type","application/json")
                .setResponseCode(200));
        Assertions.assertEquals(HttpStatus.OK,tmdbService.getMovieById("test").getStatusCode());
    }

    @Test
    void searchByMovie() throws Exception{
        String response = "{\"success\":\"ok\"}";
        mockBackEnd.enqueue(new MockResponse()
                .setBody(response)
                .addHeader("Content-Type","application/json")
                .setResponseCode(200));
        Assertions.assertEquals(HttpStatus.OK,tmdbService.searchByMovie("test").getStatusCode());
    }

    @Test
    void getTrendingBadRequest() throws Exception{
        String response = "{\"success\":\"bad_request\"}";
        mockBackEnd.enqueue(new MockResponse()
                .setBody(response)
                .addHeader("Content-Type","application/json")
                .setResponseCode(404));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,tmdbService.getTrending().getStatusCode());
    }

    @Test
    void getMovieByIdBadRequest() throws Exception{
        String response = "{\"success\":\"bad_request\"}";
        mockBackEnd.enqueue(new MockResponse()
                .setBody(response)
                .addHeader("Content-Type","application/json")
                .setResponseCode(404));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,tmdbService.getMovieById("test").getStatusCode());
    }

    @Test
    void searchByMovieBadRequest() throws Exception{
        String response = "{\"success\":\"bad_request\"}";
        mockBackEnd.enqueue(new MockResponse()
                .setBody(response)
                .addHeader("Content-Type","application/json")
                .setResponseCode(404));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,tmdbService.searchByMovie("test").getStatusCode());
    }
}
