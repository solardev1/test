package com.dev892.ListaTareas.Controllers;

import com.dev892.ListaTareas.CustomModels.CustomResponseModel;
import com.dev892.ListaTareas.Entities.Tarea;
import com.dev892.ListaTareas.Repo.TareaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TareasController {

    private final TareaRepository tareaRepository;

    public TareasController(TareaRepository tareaRepository) {

        this.tareaRepository = tareaRepository;
    }

    // OBTENER LAS TAREAS
    @GetMapping("/tareas")
    public ResponseEntity<CustomResponseModel> GetAllTareas(){
        try {
            List<Tarea> listaTareas= tareaRepository.findAll();

            if(listaTareas.isEmpty()){
                return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.NO_CONTENT.value(), null, System.currentTimeMillis()),HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.OK.value(), listaTareas, System.currentTimeMillis()),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //OBTENER UNA TAREA POR ID
    @GetMapping("/tareas/{id}")
    public ResponseEntity<CustomResponseModel> GetOneTarea(@PathVariable int id){
        try {
            Optional<Tarea> tarea= tareaRepository.findById(id);

            if(!tarea.isPresent()){
                return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.NOT_FOUND.value(), null,System.currentTimeMillis()),HttpStatus.NOT_FOUND);            }

            return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.OK.value(), tarea.get(),System.currentTimeMillis()),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //AGREGAR UNA TAREA
    @PostMapping("/tareas")
    public ResponseEntity<CustomResponseModel> AddTarea(@RequestBody Tarea tarea){

        try {
            var Obj=tareaRepository.save(tarea);

            if(Obj==null){
                return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.NOT_FOUND.value(), null,System.currentTimeMillis()),HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.OK.value(), Obj, System.currentTimeMillis()),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ACTUALIZAR UNA TAREA
    @PutMapping("/tareas/{id}")
    public ResponseEntity<CustomResponseModel> UpdateTarea(@PathVariable("id") int id, @RequestBody Tarea newTarea){

        try {
            Optional<Tarea> tareaUpdate= tareaRepository.findById(id);

            if(tareaUpdate.isPresent()){
                var tareaData=tareaUpdate.get();
                tareaData.setNombreTarea(newTarea.getNombreTarea());

                var tareaObjeto=tareaRepository.save(tareaData);

                return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.OK.value(), tareaObjeto,System.currentTimeMillis()),HttpStatus.OK);

            }
            return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.NOT_FOUND.value(), null,System.currentTimeMillis()),HttpStatus.NOT_FOUND);

        }catch (Exception ex){
            return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), null,System.currentTimeMillis()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //BORRAR UNA TAREA
    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<CustomResponseModel> DeleteTarea(@PathVariable("id") int id){

        try {
            tareaRepository.deleteById(id);

            return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.OK.value(),"Tarea Realizada con Exito.",System.currentTimeMillis() ),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), null,System.currentTimeMillis()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
