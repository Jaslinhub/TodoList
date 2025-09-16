package com.oocl.todolist.Repository;

import com.oocl.todolist.Dto.AddTodoReq;
import com.oocl.todolist.Entity.Todo;

import java.util.List;

public interface TodoRespository {
    Todo addTodo(AddTodoReq todo);
    void deleteTodo();
    void updateTodo();
    List<Todo> findAll();

    void clear();
}
