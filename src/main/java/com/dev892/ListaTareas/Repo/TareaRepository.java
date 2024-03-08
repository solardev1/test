package com.dev892.ListaTareas.Repo;

import com.dev892.ListaTareas.Entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// USO DE SPRING DATA JPA PARA DISMINUIR CODIGO
@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}
