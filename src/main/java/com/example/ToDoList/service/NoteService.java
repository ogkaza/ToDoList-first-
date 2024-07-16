package com.example.ToDoList.service;

import com.example.ToDoList.entity.NoteEntity;
import com.example.ToDoList.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class NoteService {
    @Autowired
    NoteRepo noteRepo;

    public NoteService() {
    }

    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public void saveNote(NoteEntity noteEntity){
        noteRepo.save(noteEntity);
    }

    public List<NoteEntity> getAll(){
        return noteRepo.findAll();
    }

    public void deleteNote(@RequestParam Integer id){
        try{
            NoteEntity noteEntity = noteRepo.findById(id).get();
            noteRepo.delete(noteEntity);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public NoteEntity updateUser(@RequestParam Integer id, @RequestBody NoteEntity noteEntity) {
        NoteEntity note = noteRepo.findById(id).get();
        note.setNote(noteEntity.getNote());
        return noteRepo.save(note);
    }

    public Optional<NoteEntity> findById(Integer id){
        Optional<NoteEntity> noteEntity = noteRepo.findById(id);
        return noteEntity;
    }
}
