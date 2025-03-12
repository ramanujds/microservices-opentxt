package com.optxt.notesapp.userservice.service;

import com.optxt.notesapp.userservice.client.NotesClient;
import com.optxt.notesapp.userservice.model.User;
import com.optxt.notesapp.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private NotesClient notesClient;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void createUser() {
        User user = new User(1L, "user1", "user1@abc.com");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User createdUser = userService.createUser(user);
        assertNotNull(createdUser);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
}