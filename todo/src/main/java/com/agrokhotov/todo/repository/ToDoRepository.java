package com.agrokhotov.todo.repository;

import com.agrokhotov.todo.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, String> {

}
