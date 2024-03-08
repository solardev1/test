/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dev411.controller;

import com.example.dev411.model.Tarea;
import com.example.dev411.service.TareaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robert
 */
@RestController
public class TareaController {

    @Autowired
    TareaService tareaService;

    @PostMapping("/tarea")
    public Tarea saveStudent(@RequestBody Tarea tarea) {
        return tareaService.guardarTarea(tarea);
    }

    @GetMapping("/tarea/{id}")
    public Tarea obtenerTareaPorId(@PathVariable("id") Long id) {
        return tareaService.obtenerTareaPorId(id);
    }

    @GetMapping("/tareas")
    public ResponseEntity<List<Tarea>> obtenerTareas() {
        List<Tarea> tareas = tareaService.obtenerTareas();

        if (tareas.isEmpty()) { //No se encontraron registros
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(tareas);
        }
    }

    @PutMapping("/tarea/{id}")
    public Tarea actualizarTarea(@PathVariable("id") Long id, @RequestBody Tarea tarea) {
        return tareaService.actualizarTarea(id, tarea);
    }

    @DeleteMapping("/tarea/{id}")
    public ResponseEntity<String> borrarTarea(@PathVariable("id") Long id) {
                // Verifica si la tarea con el ID especificado existe en tu capa de servicio o en tu base de datos
        if (!tareaService.existeTarea(id)) {
            // Si no existe, devuelve una respuesta con el código de estado 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la tarea con el ID: " + id);
        }
        
        // Si la tarea existe, procede a borrarla
        String mensaje = tareaService.borrarTarea(id);
        return ResponseEntity.ok(mensaje);
    }
}