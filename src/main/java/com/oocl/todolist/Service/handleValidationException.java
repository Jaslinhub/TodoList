package com.oocl.todolist.Service;

public class handleValidationException extends RuntimeException {
    public handleValidationException(String titleCannotBeEmpty) {
        super(titleCannotBeEmpty);
    }
}
