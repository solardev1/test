package com.dev.controller;

import com.dev.model.Tareas;
import com.dev.repository.services.TareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareasService tareasService;

    @PostMapping("/crear")
    public Tareas crearTarea(@RequestBody Tareas tarea){
        return tareasService.crearTarea(tarea);
    }

    @GetMapping("/listar")
    public List<Tareas> listarTareas(){
        return tareasService.listarTareas();
    }

    @GetMapping("/borrar/{id}")
    public void borrarTarea(@PathVariable("id") Long id){
        tareasService.borrarTarea(id);
    }

    @PostMapping("/actualizar")
    public Tareas actualizarTarea(@RequestBody Tareas tarea){
        return tareasService.crearTarea(tarea);
    }
}
