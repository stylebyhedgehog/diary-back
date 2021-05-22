package org.example.diary.controller;


import org.example.diary.entity.Todo;
import org.example.diary.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/user/{idUser}/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public @ResponseBody
    Todo addTodo(@PathVariable Long idUser, @Valid @RequestBody final Todo todo){ return todoService.addTodo(idUser,todo); }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long idUser, @PathVariable Long id) {
        return todoService.getTodo(idUser,id);
    }

    @GetMapping()
    public  @ResponseBody
    Set<Todo> getTodos(@PathVariable Long idUser){
        return todoService.getTodos(idUser);
    }


    @PutMapping("/{id}/toggle")
    public Todo toggleTodo(@PathVariable Long idUser, @PathVariable final Long id){
        return todoService.toggleTodo(idUser,id);
    }

    @DeleteMapping("/{id}")
    public Todo deleteTodo(@PathVariable Long idUser, @PathVariable final Long id){
        return todoService.deleteTodo(idUser,id);
    }

}
