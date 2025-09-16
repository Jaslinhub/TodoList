package com.oocl.todolist.Service;

public class TodoNotFindException extends RuntimeException {
    public TodoNotFindException(String s) {
        super(s);
    }
}
