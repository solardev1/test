package com.dannyprats.taskboot.repository;

import com.dannyprats.taskboot.model.Task;

import java.util.UUID;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.repository.ListCrudRepository;

//@Repository
public interface TaskRepository extends ListCrudRepository<Task,UUID> {
}
