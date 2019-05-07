package com.rubengees.playground;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public final class TodoEntity extends PanacheEntity {

    private String name;
    private String description;
    private boolean done;

    public TodoEntity() {
    }

    public TodoEntity(String name, String description, boolean done) {
        this.name = name;
        this.description = description;
        this.done = done;
    }

    public TodoEntity(Todo todo) {
        this.name = todo.getName();
        this.description = todo.getDescription();
        this.done = todo.isDone();
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

    @Override
    public String toString() {
        return "TodoEntity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}
