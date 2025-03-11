package com.optxt.notesapp.userservice.client;

import com.optxt.notesapp.userservice.dto.Note;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "notes-service")
public interface NotesClient {

    @GetMapping("/api/notes/user/{userId}")
    @CircuitBreaker(name = "notesClient", fallbackMethod = "getNotesByUserIdFallback")
    List<Note> getNotesByUserId(@PathVariable long userId);

    default List<Note> getNotesByUserIdFallback(Exception e) {
        System.err.println("Fallback method called for getNotesByUserId" );
        System.err.println(e.getMessage());
        return List.of();
    }

}
