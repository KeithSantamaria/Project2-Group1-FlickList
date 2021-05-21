package com.flicklist.unittests.controllertests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flicklist.controller.ReviewController;
import com.flicklist.model.Review;
import com.flicklist.service.review.ReviewService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReviewController.class)
public class ReviewControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    private static Review review;
    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup(){
        review = new Review();
        review.setUserId("testId");
        review.setMovieId("movieId");
        review.setRating(5);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testFindAll() throws Exception{
        when(reviewService.findAll()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get("/reviews")).andExpect(
                status().isOk()
        );
    }

    @Test
    public void testFindByUserId() throws Exception {
        when(reviewService.findAllByUserId(anyString()))
                .thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/reviews/user/testId"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindByMovieId() throws Exception {
        when(reviewService.findAllByUserId(anyString()))
                .thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/reviews/movie/testId"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindById() throws Exception {
        when(reviewService.findById(anyString()))
                .thenReturn(review);

        this.mockMvc.perform(get("/reviews/testId"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        when(reviewService.findById(anyString()))
                .thenReturn(null);

        this.mockMvc.perform(get("/reviews/testId"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateReview() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(review);
        when(reviewService.create(any()))
                .thenReturn(review);

        this.mockMvc.perform(post("/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateReviewBadRequest() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(review);
        when(reviewService.create(any()))
                .thenReturn(null);

        this.mockMvc.perform(post("/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void testUpdateReview() throws Exception {
        review.setId("testId");
        String jsonString =  objectMapper.writeValueAsString(review);
        when(reviewService.update(any()))
                .thenReturn(review);

        this.mockMvc.perform(put("/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());
        review.setId(null);
    }

    @Test
    public void testUpdateReviewBadRequest() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(review);
        when(reviewService.update(any()))
                .thenReturn(null);

        this.mockMvc.perform(put("/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void testDeleteReview() throws Exception {

        String jsonString =  objectMapper.writeValueAsString(review);
        when(reviewService.delete(any()))
                .thenReturn((long)1);

        this.mockMvc.perform(delete("/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteReviewNotFound() throws Exception {

        String jsonString =  objectMapper.writeValueAsString(review);
        when(reviewService.delete(any()))
                .thenReturn((long)0);

        this.mockMvc.perform(delete("/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isNotFound());
    }

}

