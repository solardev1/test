/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.dev411.repository;

import com.example.dev411.model.Tarea;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Robert
 */
public interface TareaRepository extends CrudRepository<Tarea, Long>{
    
}