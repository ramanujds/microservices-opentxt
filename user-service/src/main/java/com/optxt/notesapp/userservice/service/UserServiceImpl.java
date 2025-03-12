package com.optxt.notesapp.userservice.service;

import com.optxt.notesapp.userservice.client.NotesClient;
import com.optxt.notesapp.userservice.dto.Note;
import com.optxt.notesapp.userservice.model.User;
import com.optxt.notesapp.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final NotesClient notesClient;

    private final UserRepository userRepository;

    public UserServiceImpl(NotesClient notesClient, UserRepository userRepository) {
        this.notesClient = notesClient;
        this.userRepository = userRepository;
    }


    public User createUser(User user) {
        return userRepository.save(user);

    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<Note> getNotesByUserId(long userId) {
        return notesClient.getNotesByUserId(userId);
    }
}
