package com.oocl.todolist.Repository;

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
    public void addTodo(Todo todo) {
        todo.setDone(false);
        todoListJpaRepository.save(todo);;
    }

    @Override
    public void deleteTodo() {

    }

    @Override
    public void updateTodo() {

    }

    public List<Todo> findAll() {
        return todoListJpaRepository.findAll();
    }
    @Override
    public void clear() {
        todoListJpaRepository.deleteAll();
    }
}
