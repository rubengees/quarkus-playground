package com.rubengees.playground;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;

public final class Todo {

    private String name;
    private String description;
    private boolean done;

    public Todo() {
    }

    public Todo(String name, String description, boolean done) {
        this.name = name;
        this.description = description;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return done == todo.done &&
                Objects.equals(name, todo.name) &&
                Objects.equals(description, todo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, done);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}
