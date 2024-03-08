/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.dev411.service;

import com.example.dev411.model.Tarea;
import java.util.List;

/**
 *
 * @author Robert
 */
public interface TareaService {
    	List<Tarea> obtenerTareas();
	Tarea obtenerTareaPorId(Long id);
	Tarea guardarTarea(Tarea tarea);
	String borrarTarea(Long id);
	Tarea actualizarTarea(Long id, Tarea tarea);
}