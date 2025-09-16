package com.oocl.todolist.Controller;

import com.oocl.todolist.Entity.Todo;
import com.oocl.todolist.Service.TodoListService;
import org.hibernate.annotations.ConcreteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoListService.addTodo(todo);
    }

    @GetMapping("/todos")
    public List<Todo> getAlltodos() {
        return todoListService.getAllTodos();
    }
}
