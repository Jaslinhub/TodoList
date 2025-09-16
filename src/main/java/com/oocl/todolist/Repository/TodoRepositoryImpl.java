package com.oocl.todolist.Repository;

import com.oocl.todolist.Dto.AddTodoReq;
import com.oocl.todolist.Dto.UpdateTodoReq;
import com.oocl.todolist.Entity.Todo;
import com.oocl.todolist.Repository.Dao.TodoListJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TodoRepositoryImpl implements TodoRespository {
    @Autowired
    private TodoListJpaRepository todoListJpaRepository;


    @Override
    public Todo addTodo(AddTodoReq todo) {
        Todo newtodo=new Todo();
        newtodo.setText(todo.getText());
        newtodo.setDone(false);
        return todoListJpaRepository.save(newtodo);
    }

    @Override
    public void deleteTodoById(int id) {
        todoListJpaRepository.deleteById(id);

    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        todo.setId(id);
        return todoListJpaRepository.save(todo);
    }

    @Override
    public Todo getTodoById(int id) {
        return todoListJpaRepository.findById(id).orElse(null);
    }

    public List<Todo> findAll() {
        return todoListJpaRepository.findAll();
    }
    @Override
    public void clear() {
        todoListJpaRepository.deleteAll();
    }
}
