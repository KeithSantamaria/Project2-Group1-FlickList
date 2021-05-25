package com.flicklist.unittests.controllertests;


import com.flicklist.controller.ApiController;
import com.flicklist.service.tmdb.TmdbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TmdbService tmdbService;

    @Test
    public void getTrending() throws Exception{
        when(tmdbService.getTrending()).thenReturn(ResponseEntity.ok().build());
        this.mockMvc.perform(get("/tmdb/trending")).andExpect(
                status().isOk()
        );
    }

    @Test
    public void getMovieById() throws Exception{
        when(tmdbService.getMovieById("test")).thenReturn(ResponseEntity.ok().build());
        this.mockMvc.perform(get("/tmdb/movie/test")).andExpect(
                status().isOk()
        );
    }
    @Test
    public void searchByMovie() throws Exception{
        when(tmdbService.searchByMovie("test")).thenReturn(ResponseEntity.ok().build());
        this.mockMvc.perform(get("/tmdb/search/test")).andExpect(
                status().isOk()
        );
    }
}
