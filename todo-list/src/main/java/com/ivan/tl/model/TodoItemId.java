package com.ivan.tl.model;

public class TodoItemId {

    private Long id;

    public TodoItemId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static boolean isNotEmpty(final TodoItemId itemId) {
        return itemId != null && itemId.getId() != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItemId that = (TodoItemId) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TodoItemId{" +
                "id=" + id +
                '}';
    }
}
