package com.example.notepad.service;

import com.example.notepad.model.Note;
import com.example.notepad.repository.NoteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    
    private final NoteRepository noteRepository;
    
    @Autowired
    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }
 
    public Note createNote(Note note){
        return noteRepository.save(note);
    }
    
    public Note updateNote(Long id, Note updatedNote){
        
        Note existingNote = noteRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Nota no encontrada con ID = " + id));
        
        existingNote.setTitle(updatedNote.getTitle());
        existingNote.setContent(updatedNote.getContent());
        existingNote.setArchived(updatedNote.isArchived());
//        existingNote.setCategories(updatedNote.getCategories());

        return noteRepository.save(existingNote);                
    }
    
    public void deleteNote(Long id){
        noteRepository.deleteById(id);
    }
    
    public Note toggleArchiveStatus(Long id, boolean archive){
        Note note = noteRepository.findById(id).
                orElseThrow(()-> new  RuntimeException("Nota no encontrada con ID = " + id));
        note.setArchived(archive);
        return noteRepository.save(note); 
    }
    
    public List<Note> listActivedNotes(){
        return noteRepository.findByArchivedFalse();
    }
    
    public List<Note> listArchivedNotes(){
        return noteRepository.findByArchivedTrue(); 
    }
}
