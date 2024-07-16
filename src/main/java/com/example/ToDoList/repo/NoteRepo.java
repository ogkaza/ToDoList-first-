package com.example.ToDoList.repo;

import com.example.ToDoList.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<NoteEntity,Integer> {
}
