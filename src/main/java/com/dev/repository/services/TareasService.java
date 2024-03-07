package com.dev.repository.services;

import com.dev.model.Tareas;
import com.dev.repository.TareasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareasService {

    @Autowired
    private TareasRepository tareasRepository;

    public Tareas crearTarea(Tareas tarea){
        return tareasRepository.save(tarea);
    }

    public List<Tareas> listarTareas(){
        return tareasRepository.findAll();
    }

    public void borrarTarea(Long id){
        tareasRepository.deleteById(id);
    }

}
