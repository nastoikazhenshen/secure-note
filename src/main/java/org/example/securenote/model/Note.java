package org.example.securenote.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Note {
    private int id;

    @NotBlank(message = "Title is required")
    @Size(max = 50, message = "Title must be less than 50 characters")
    private String title;

    @NotBlank(message = "Content is required")
    @Size(max = 500, message = "Content must be less than 500 characters")
    private String content;

    public Note() {
    }

    public Note(int id, String title, String content) {
        this.id = id;
        this.title = sanitize(title);
        this.content = sanitize(content);
    }

    private String sanitize(String value) {
        return value.replace("<", "&lt;").replace(">", "&gt;");
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
