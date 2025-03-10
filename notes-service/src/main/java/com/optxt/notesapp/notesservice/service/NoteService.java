package com.optxt.notesapp.notesservice.service;

import com.optxt.notesapp.notesservice.model.Note;

import java.util.List;

public interface NoteService {

    Note save(Note note);
    List<Note> findAllNotes();
    Note findNoteById(Long id);
    void deleteNoteById(Long id);

}
