package com.example.notepad.repository;

import com.example.notepad.model.Note;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    
    List<Note> findByArchivedTrue();
    
    List<Note> findByArchivedFalse();

    
}
