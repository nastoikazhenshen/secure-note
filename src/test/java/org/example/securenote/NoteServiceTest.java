package org.example.securenote;

import org.example.securenote.model.Note;
import org.example.securenote.service.NoteService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoteServiceTest {

    @Test
    void shouldCreateNote() {
        NoteService noteService = new NoteService();

        Note note = noteService.createNote("Test title", "Test content");

        assertEquals(1, note.getId());
        assertEquals("Test title", note.getTitle());
        assertEquals("Test content", note.getContent());
    }

    @Test
    void shouldFindNoteById() {
        NoteService noteService = new NoteService();

        noteService.createNote("First note", "Content");

        assertTrue(noteService.getNoteById(1).isPresent());
    }

    @Test
    void shouldDeleteNoteById() {
        NoteService noteService = new NoteService();

        noteService.createNote("Delete me", "Content");

        boolean deleted = noteService.deleteNoteById(1);

        assertTrue(deleted);
        assertTrue(noteService.getAllNotes().isEmpty());
    }
}