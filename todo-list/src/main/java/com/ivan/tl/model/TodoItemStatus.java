package com.ivan.tl.model;

public class TodoItemStatus {

    private boolean done;

    public TodoItemStatus() {
    }

    public TodoItemStatus(boolean done) {
        this.done = done;
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

        TodoItemStatus that = (TodoItemStatus) o;

        return done == that.done;
    }

    @Override
    public int hashCode() {
        return (done ? 1 : 0);
    }

    @Override
    public String toString() {
        return "TodoItemStatus{" +
                "done=" + done +
                '}';
    }
}
