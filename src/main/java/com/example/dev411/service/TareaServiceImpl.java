/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dev411.service;

import com.example.dev411.model.Tarea;
import com.example.dev411.repository.TareaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robert
 */
@Service
public class TareaServiceImpl implements TareaService {

    @Autowired //inject repository dependency
    TareaRepository tareaRepository;

    @Override
    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea); //guardar tarea
    }

    @Override
    public Tarea obtenerTareaPorId(Long id) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        if (tarea.isPresent()) {
            return tarea.get();
        }
        return null;
    }

    @Override
    public List<Tarea> obtenerTareas() {
        List<Tarea> tareas = new ArrayList<>(); //crear una lista de tipo Tarea
        tareaRepository.findAll().forEach(tarea -> tareas.add(tarea)); // mantener todas las tareas dentro de la lista de tareas
        return tareas;
    }

    @Override
    public String borrarTarea(Long id) {
        tareaRepository.deleteById(id); //borrar una tarea por id
		return "id " + id + " Se ha borrado correctamente."; 
    }

    @Override
    public Tarea actualizarTarea(Long id, Tarea tarea) {
        Optional<Tarea> tareaPorId = tareaRepository.findById(id);
		
		if(tareaPorId.isPresent()) { 
			Tarea actualizarTarea = tareaPorId.get();
		
			actualizarTarea.setId(tarea.getId());
			actualizarTarea.setNombre(tarea.getNombre());
			actualizarTarea.setDescripcion(tarea.getDescripcion());
			
			return tareaRepository.save(actualizarTarea);
		}
		
		return null;
    }
    
    @Override
    // Método para verificar si una tarea con el ID especificado existe
    public boolean existeTarea(Long id) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);
        return tareaOptional.isPresent(); // Devuelve true si la tarea existe, false si no
    }

}