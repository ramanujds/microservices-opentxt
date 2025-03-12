package com.optxt.notesapp.userservice.api;

import com.optxt.notesapp.userservice.model.User;
import com.optxt.notesapp.userservice.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockitoBean
    private UserServiceImpl userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUserById() throws Exception {
        User user = new User(1L, "user1", "user1@yahoo.com");
        Mockito.when(userService.findUserById(Mockito.anyLong())).thenReturn(user);

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("user1"));

        Mockito.verify(userService,Mockito.times(1)).findUserById(Mockito.anyLong());

    }
}