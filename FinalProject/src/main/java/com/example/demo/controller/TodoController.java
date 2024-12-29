package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demos")
@CrossOrigin(origins = "*")  
public class TodoController {

    @Autowired
    private	TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getdemos() {
        return todoRepository.findAll();
    }

    @PostMapping
    public Todo adddemo(@RequestBody Todo demo) {
        return todoRepository.save(demo);
    }

 
    @PutMapping("/{id}/complete")
    public Todo markdemoCompleted(@PathVariable String id) {
    	Todo demo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("demo not found"));
    	demo.setCompleted(true);
        return todoRepository.save(demo);
    }
 
    @DeleteMapping("/{id}")
    public void deletedemo(@PathVariable String id) {
    	todoRepository.deleteById(id);
    }
}
