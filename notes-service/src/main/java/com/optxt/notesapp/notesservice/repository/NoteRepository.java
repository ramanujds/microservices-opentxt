package com.optxt.notesapp.notesservice.repository;

import com.optxt.notesapp.notesservice.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
