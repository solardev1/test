package com.dannyprats.taskboot.controller;

import com.dannyprats.taskboot.TaskService;
import com.dannyprats.taskboot.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    // Controlador para manejar las operaciones relacionadas con las tareas
    @Autowired
    private TaskService taskService;

    // Crea una nueva tarea
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createtask(task);
    }

    // Obtiene todas las tareas
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    // Busca una tarea por su ID
    @GetMapping("{id}")
    public Task searchTaskById(@PathVariable("id") UUID id){
        return taskService.getTaskById(id);
    }

    // Actualiza una tarea existente
    @PatchMapping("{id}")
    public Task updateTask(@PathVariable("id") UUID id, @RequestBody Task taskToUpdate){
        return taskService.updateTask(id, taskToUpdate);
    }

    // Elimina una tarea por su ID
    @DeleteMapping("{id}")
    public void deleteTaskById(@PathVariable("id") UUID id){
         taskService.deleteTask(id);
    }

}
