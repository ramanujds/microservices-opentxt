package com.optxt.notesapp.userservice.api;

import com.optxt.notesapp.userservice.dto.Note;
import com.optxt.notesapp.userservice.model.User;
import com.optxt.notesapp.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/notes/{userId}")
    public List<Note> getNotesByUserId(@PathVariable long userId) {
        return userService.getNotesByUserId(userId);
    }


}
