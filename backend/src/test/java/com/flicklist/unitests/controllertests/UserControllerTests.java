package com.flicklist.unitests.controllertests;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flicklist.controller.UserController;
import com.flicklist.model.User;
import com.flicklist.service.user.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    private static User testUser;
    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup(){
        testUser = new User();
        testUser.setFirstName("testFirstName");
        testUser.setLastName("testLastName");
        testUser.setUsername("testUsername");
        testUser.setPassword("testPassword");
        testUser.setEmail("testEmail");
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testFindByUsernameAndPassword() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(testUser);
        when(userService.findByUsernameAndPassword(anyString(), anyString()))
                .thenReturn(testUser);

        this.mockMvc.perform(post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindByUsernameAndPasswordBadLogin() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(testUser);
        when(userService.findByUsernameAndPassword(anyString(), anyString()))
                .thenReturn(null);

        this.mockMvc.perform(post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindByUserId() throws Exception {
        testUser.setId("testId");
        when(userService.findById(anyString()))
                .thenReturn(testUser);

        this.mockMvc.perform(get("/users/test"))
                .andExpect(status().isOk());
        testUser.setId(null);
    }

    @Test
    public void testFindByUserIdNotFound() throws Exception {
        when(userService.findById(anyString()))
                .thenReturn(null);

        this.mockMvc.perform(get("/users/test"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAll() throws Exception{
        when(userService.findAll()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get("/users")).andExpect(
                status().isOk()
        );
    }

    @Test
    public void testCreateUser() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(testUser);
        when(userService.create(any()))
                .thenReturn(testUser);

        this.mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateUserBadRequest() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(testUser);
        when(userService.create(any()))
                .thenReturn(null);

        this.mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUpdateUser() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(testUser);
        when(userService.update(any()))
                .thenReturn(testUser);

        this.mockMvc.perform(put("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateUserBadRequest() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(testUser);
        when(userService.update(any()))
                .thenReturn(null);

        this.mockMvc.perform(put("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void testDeleteUser() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(testUser);
        when(userService.delete(any()))
                .thenReturn((long)1);

        this.mockMvc.perform(delete("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUserNotFound() throws Exception {
        String jsonString =  objectMapper.writeValueAsString(testUser);
        when(userService.delete(any()))
                .thenReturn((long)0);

        this.mockMvc.perform(delete("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isNotFound());
    }
}
