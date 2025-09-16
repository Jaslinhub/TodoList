package com.oocl.todolist.Exception;

import com.oocl.todolist.Service.JsonEmptyException;
import com.oocl.todolist.Service.TodoNotFindException;
import com.oocl.todolist.Service.handleValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(handleValidationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public String handleValidationException(handleValidationException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(TodoNotFindException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTodoNotFindException(TodoNotFindException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(JsonEmptyException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public String handleJsonEmptyException(JsonEmptyException ex) {
        return ex.getMessage();
    }
}
