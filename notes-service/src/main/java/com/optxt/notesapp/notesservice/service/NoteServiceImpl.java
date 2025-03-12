package com.optxt.notesapp.notesservice.service;

import com.optxt.notesapp.notesservice.client.UserClient;
import com.optxt.notesapp.notesservice.exception.ResourceNotFoundException;
import com.optxt.notesapp.notesservice.model.Note;
import com.optxt.notesapp.notesservice.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private static final String TOPIC = "notes";

    private final NoteRepository noteRepository;
    //    private final RestTemplate restTemplate;
    private final UserClient userClient;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public NoteServiceImpl(NoteRepository noteRepository, UserClient userClient) {
        this.noteRepository = noteRepository;
        this.userClient = userClient;
    }


    public Note save(Note note) throws ResourceNotFoundException {

//  Fetch the user from user-service
        //    var user = restTemplate.getForObject("http://localhost:8200/api/users/"+note.getUserId(), UserDTO.class);
        var user = userClient.getUserById(note.getUserId());
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        note.setCreatedAt(LocalDate.now());
        var savedNote = noteRepository.save(note);
        kafkaTemplate.send(TOPIC, savedNote.toString());
        return savedNote;
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public Note findNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    public List<Note> findNotesByUserId(Long userId) {
        return noteRepository.findByUserId(userId);
    }
}
