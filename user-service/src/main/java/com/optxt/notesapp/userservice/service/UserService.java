package com.optxt.notesapp.userservice.service;

import com.optxt.notesapp.userservice.model.User;

public interface UserService {

    User createUser(User user);

    User findUserById(Long id);


}
