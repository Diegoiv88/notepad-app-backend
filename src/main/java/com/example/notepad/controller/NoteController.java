package com.example.notepad.controller;

import com.example.notepad.model.Note;
import com.example.notepad.service.NoteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/notes")
public class NoteController {
    
    private final NoteService noteService;
    
    @Autowired
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }
//    Crear nota
    @PostMapping("/crear")
    public Note createNote(@RequestBody Note note){
        return noteService.createNote(note);
    }
//    Editar nota
    @PutMapping("/{id}")
     public Note updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        return noteService.updateNote(id, updatedNote);
    }
//    Eliminar nota
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
//    Archivar o desarchivar una nota
    @PatchMapping("{id}/archive")
    public Note toggleArchiveStatus(@PathVariable Long id, @RequestParam boolean archive){
       return noteService.toggleArchiveStatus(id, archive); 
    }
//    Listar notas activas del usuario
    @GetMapping("/active")
    public List<Note> listActivedNotes(){
        return noteService.listActivedNotes();
    }
//    Listar notas archivadas del usuario
    @GetMapping("/archived")
    public List<Note> listArchivedNotes(){
        return noteService.listArchivedNotes();
    }

    
}
