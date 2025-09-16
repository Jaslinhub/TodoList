package com.oocl.todolist.Repository;

import com.oocl.todolist.Dto.AddTodoReq;
import com.oocl.todolist.Dto.UpdateTodoReq;
import com.oocl.todolist.Entity.Todo;

import java.util.List;

public interface TodoRespository {
    Todo addTodo(AddTodoReq todo);
    List<Todo> findAll();

    void clear();

    Todo getTodoById(int id);
    Todo updateTodo(int id, Todo todo);

    void deleteTodoById(int id);
}
