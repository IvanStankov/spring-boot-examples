package com.ivan.datatables;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class DocumentsRecord {

    @JsonProperty("0")
    private long id;
    @JsonProperty("1")
    private String title;
    @JsonProperty("2")
    private String description;
    @JsonProperty("3")
    private String author;
    @JsonProperty("4")
    private int size;
    @JsonProperty("5")
    private LocalDateTime createdDate;

    public DocumentsRecord(long id, String title, String description, String author, int size, LocalDateTime createdDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.size = size;
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
