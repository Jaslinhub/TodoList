package com.oocl.todolist.Service;

public class JsonEmptyException extends RuntimeException {
    public JsonEmptyException(String updateBodyCannotBeEmpty) {
        super(updateBodyCannotBeEmpty);
    }
}
