package com.oocl.todolist.Service;

import com.oocl.todolist.Entity.Todo;
import com.oocl.todolist.Repository.TodoRepositoryImpl;
import com.oocl.todolist.Repository.TodoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TodoListService {
    @Autowired
    private TodoRespository todoRespository;

    public List<Todo> getAllTodos(){
        return todoRespository.findAll();
    }

    public Todo addTodo(Todo todo){
        todoRespository.addTodo(todo);
        return todo;
    }
}
