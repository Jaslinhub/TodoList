package com.oocl.todolist.Repository.Dao;

import com.oocl.todolist.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListJpaRepository extends JpaRepository<Todo, Integer> {
}
