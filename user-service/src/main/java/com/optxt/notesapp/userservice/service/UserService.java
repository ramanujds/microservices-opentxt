package com.optxt.notesapp.userservice.service;

import com.optxt.notesapp.userservice.dto.Note;
import com.optxt.notesapp.userservice.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User findUserById(Long id);


    List<Note> getNotesByUserId(long userId);
}
