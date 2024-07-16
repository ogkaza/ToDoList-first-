package com.example.ToDoList.controller;

import com.example.ToDoList.entity.NoteEntity;
import com.example.ToDoList.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    NoteService noteService;

    public MainController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/notes")
    public String main(Model model){
        model.addAttribute("notes",noteService.getAll());
        return "notes";
    }

    @PostMapping("/main")
    public String save(NoteEntity noteEntity, Model model){
        noteService.saveNote(noteEntity);
        return "redirect:/notes";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable(name = "id") Integer id){
        noteService.deleteNote(id);
        return "redirect:/notes";
    }

    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable(name = "id") Integer id, Model model){
        model.addAttribute("noteEntity", noteService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateNote(@RequestParam("id") Integer id, NoteEntity noteEntity){
        noteService.updateUser(id, noteEntity);
        return "redirect:/notes";
    }
}
