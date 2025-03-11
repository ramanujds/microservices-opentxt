package com.optxt.notesapp.notesservice.api;

import com.optxt.notesapp.notesservice.exception.ResourceNotFoundException;
import com.optxt.notesapp.notesservice.model.Note;
import com.optxt.notesapp.notesservice.repository.NoteRepository;
import com.optxt.notesapp.notesservice.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.findAllNotes();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Note createNote(@RequestBody Note note) throws ResourceNotFoundException {
        return noteService.save(note);
    }

    @GetMapping("/{id}")
    public Note getNote(@PathVariable long id) {
        return noteService.findNoteById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Note> getNotesByUserId(@PathVariable long userId) {

//        try{
//            Thread.sleep(3000);
//        }
//        catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        throw new RuntimeException("Test Error occurred");
        return noteService.findNotesByUserId(userId);
    }

}
