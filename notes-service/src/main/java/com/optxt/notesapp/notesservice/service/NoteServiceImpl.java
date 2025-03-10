package com.optxt.notesapp.notesservice.service;

import com.optxt.notesapp.notesservice.model.Note;
import com.optxt.notesapp.notesservice.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;


    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note save(Note note) {
        note.setCreatedAt(LocalDate.now());
        return noteRepository.save(note);
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
}
