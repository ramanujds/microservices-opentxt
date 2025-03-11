package com.optxt.notesapp.notesservice.repository;

import com.optxt.notesapp.notesservice.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUserId(long userId);

}
