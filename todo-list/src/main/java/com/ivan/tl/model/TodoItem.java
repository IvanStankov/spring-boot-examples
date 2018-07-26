package com.ivan.tl.model;

import javax.validation.constraints.NotEmpty;

public class TodoItem {

    private Long id;

    @NotEmpty
    private String name;
    private String description;

    private boolean done;

    public TodoItem() {
    }

    public TodoItem(String name, String description) {
        this(null, name, description);
    }

    public TodoItem(Long id, String name, String description) {
        this(id, name, description, false);
    }

    public TodoItem(Long id, @NotEmpty String name, String description, boolean done) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (done != todoItem.done) return false;
        if (id != null ? !id.equals(todoItem.id) : todoItem.id != null) return false;
        if (name != null ? !name.equals(todoItem.name) : todoItem.name != null) return false;
        return description != null ? description.equals(todoItem.description) : todoItem.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (done ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}
