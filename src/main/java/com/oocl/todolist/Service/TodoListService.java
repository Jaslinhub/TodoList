package com.oocl.todolist.Service;

import com.oocl.todolist.Dto.AddTodoReq;
import com.oocl.todolist.Dto.UpdateTodoReq;
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

    public List<Todo> getAllTodos() {
        return todoRespository.findAll();
    }

    public Todo addTodo(AddTodoReq todo) {
        if (todo.getText() == null || todo.getText().isEmpty()) {
            throw new handleValidationException("Text cannot be empty");
        }
        return todoRespository.addTodo(todo);
    }

    public Todo updateTodoById(int id, UpdateTodoReq updatedTodo) {
        Todo existingTodo = todoRespository.getTodoById(id);
        if (existingTodo == null) {
            throw new TodoNotFindException("Todo not found with id: " + id);
        }
        boolean isEmpty = (updatedTodo.getText() == null || updatedTodo.getText().isEmpty())
                && updatedTodo.getDone() == null;
        if (isEmpty) {
            throw new JsonEmptyException("Update body cannot be empty");
        }
        existingTodo.setDone(updatedTodo.getDone() != null ? updatedTodo.getDone() : existingTodo.getDone());
        existingTodo.setText(updatedTodo.getText() != null ? updatedTodo.getText() : existingTodo.getText());
        return todoRespository.updateTodo(id, existingTodo);
    }

    public void deleteTodoById(int id) {
        todoRespository.deleteTodoById(id);
    }
}
