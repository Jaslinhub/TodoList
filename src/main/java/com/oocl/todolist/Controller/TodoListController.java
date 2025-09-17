package com.oocl.todolist.Controller;

import com.oocl.todolist.Dto.AddTodoReq;
import com.oocl.todolist.Dto.UpdateTodoReq;
import com.oocl.todolist.Entity.Todo;
import com.oocl.todolist.Service.TodoListService;
import com.oocl.todolist.Service.handleValidationException;
import org.hibernate.annotations.ConcreteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3001")
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @PostMapping("/todos")
    public ResponseEntity<Todo> addTodo(@RequestBody AddTodoReq todoRequest) {
        Todo createdTodo = todoListService.addTodo(todoRequest);
        return ResponseEntity.status(201).body(createdTodo);
    }

    @GetMapping("/todos")
    public List<Todo> getAlltodos() {
        return todoListService.getAllTodos();
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody UpdateTodoReq updatedTodo) {
        return todoListService.updateTodoById(id, updatedTodo);

    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable int id) {
        todoListService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }
}
