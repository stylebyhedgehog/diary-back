package org.example.diary.service;

import org.example.diary.entity.Todo;
import org.example.diary.entity.User;
import org.example.diary.repository.TodoRepository;
import org.example.diary.security.services.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Set;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserService userService;
    private final AccessService accessService;

    @Autowired
    public TodoService(TodoRepository todoRepository, UserService userService, AccessService accessService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
        this.accessService = accessService;
    }

    public Todo addTodo(Long idUser, Todo todo){
        User user = userService.getUserById(idUser);
        accessService.checkPermissionsForPage(idUser);
        todo.setDate(new Date());
        todo.setUser(user);
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    public Set<Todo> getTodos(Long idUser){
        User user = userService.getUserById(idUser);
//        accessService.checkPermissions(idUser);
        return user.getTodos();
    }

    public Todo getTodo(Long idUser, Long id){
        Todo todo= todoRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Todo не найдено"));
        accessService.checkPermissionsForPage(idUser);
        return todo;
    }
    public Todo deleteTodo(Long idUser, Long id){
        Todo todo= getTodo( idUser, id);
        accessService.checkPermissionsForObject(todo);
        todoRepository.delete(todo);
        return todo;
    }

    public Todo editTodo(Long idUser, Long id, Todo todo){
        Todo editTodo = getTodo(idUser,id);
        editTodo.setText(todo.getText());
        editTodo.setDate(new Date());
        accessService.checkPermissionsForObject(editTodo);
        todoRepository.save(editTodo);
        return editTodo;
    }

    public Todo toggleTodo(Long idUser, Long id){
        Todo toggleTodo = getTodo(idUser,id);
        toggleTodo.setCompleted(!toggleTodo.isCompleted());
        toggleTodo.setDate(new Date());
//        accessService.checkPermissionsForObject(toggleTodo);
        todoRepository.save(toggleTodo);
        return toggleTodo;
    }
}
