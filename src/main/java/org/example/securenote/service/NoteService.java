package org.example.securenote.service;

import org.example.securenote.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    private int nextId = 1;

    public Note createNote(String title, String content) {
        Note note = new Note(nextId++, title, content);
        notes.add(note);
        return note;
    }

    public List<Note> getAllNotes() {
        return notes;
    }

    public Optional<Note> getNoteById(int id) {
        return notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst();
    }

    public boolean deleteNoteById(int id) {
        return notes.removeIf(note -> note.getId() == id);
    }
}
