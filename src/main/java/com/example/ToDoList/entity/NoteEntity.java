package com.example.ToDoList.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "notepad")
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String note;

    public NoteEntity() {
    }

    public NoteEntity(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", note='" + note + '\'' +
                '}';
    }
}
