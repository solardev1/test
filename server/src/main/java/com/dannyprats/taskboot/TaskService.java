package com.dannyprats.taskboot;

import com.dannyprats.taskboot.model.Task;
import com.dannyprats.taskboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TaskService {
    // Inyección de dependencia del repositorio de tareas
    @Autowired
    private TaskRepository taskRepository;

    // Método para crear una tarea
    public Task createtask(Task task){
        return taskRepository.save(task);
    }

    // Método para obtener una tarea por su ID
    public Task getTaskById(UUID id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.get();
    }

    // Método para obtener todas las tareas
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // Método para actualizar una tarea por su ID
    public Task updateTask(UUID id, Task taskToUpdate){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            Task existingTask = optionalTask.get();
            existingTask.setName(taskToUpdate.getName());
            existingTask.setDescription(taskToUpdate.getDescription());
            existingTask.setStatus(taskToUpdate.getStatus());
            existingTask.setAssignee(taskToUpdate.getAssignee());
            return taskRepository.save(existingTask);
        } else {
            return null; // O manejar la excepción según sea necesario
        }
    }

    // Método para eliminar una tarea por su ID
    public void deleteTask(UUID id){
        taskRepository.deleteById(id);
    }
}