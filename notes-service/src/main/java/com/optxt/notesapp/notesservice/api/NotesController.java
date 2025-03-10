package com.optxt.notesapp.notesservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from OpenText";
    }

}
