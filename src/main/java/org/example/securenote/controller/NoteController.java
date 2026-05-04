package org.example.securenote.controller;

import org.example.securenote.model.Note;
import org.example.securenote.service.NoteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    public record NoteRequest(
            @NotBlank(message = "Title is required")
            @Size(max = 50, message = "Title must be less than 50 characters")
            String title,

            @NotBlank(message = "Content is required")
            @Size(max = 500, message = "Content must be less than 500 characters")
            String content
    ) {
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody NoteRequest request) {
        logger.info("Creating a new note with title: {}", request.title());
        Note note = noteService.createNote(request.title(), request.content());
        return ResponseEntity.ok(note);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        logger.info("Fetching all notes");
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable int id) {
        logger.info("Fetching note with id: {}", id);
        return noteService.getNoteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable int id) {
        logger.info("Deleting note with id: {}", id);
        boolean deleted = noteService.deleteNoteById(id);

        if (deleted) {
            return ResponseEntity.ok("Note deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}
