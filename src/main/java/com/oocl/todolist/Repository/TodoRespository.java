package com.oocl.todolist.Repository;

import com.oocl.todolist.Entity.Todo;

import java.util.List;

public interface TodoRespository {
    void addTodo(Todo todo);
    void deleteTodo();
    void updateTodo();
    List<Todo> findAll();
}
