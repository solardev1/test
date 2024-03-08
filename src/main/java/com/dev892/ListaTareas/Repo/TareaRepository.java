package com.dev892.ListaTareas.Repo;

import com.dev892.ListaTareas.Entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}
