package com.martrin.task.controller;
import com.martrin.task.model.param.TaskParam;
import com.martrin.task.service.TaskService;
import com.martrin.task.util.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;

import static com.martrin.task.util.Constants.API_BASE_URL;

@RestController
@RequestMapping(API_BASE_URL)
/**
 * Endpoints para operaciones con Task
 */

public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    /**
     // --> SELECT SECTION
     *
     * taskList api que realiza un select a la tabla tareas que devuelve una lista
     */
    @GetMapping("/taskList")
    public ResponseEntity<?> taskList(@QueryParam("estado") String estado,
                                      @QueryParam("fecha_limite") String fecha_limite) throws ApplicationException.NotFound {
        return ResponseEntity.ok(taskService.taskList(estado, fecha_limite));
    }


    /**
     // --> UPDATE SECTION
     *
     * updTask api que realiza un update sobre la tabla tareas
     */
    @PutMapping("/updTask")
    private ResponseEntity<?> updTask(@RequestBody TaskParam taskParam) throws ApplicationException.IllegalArgument {
        return ResponseEntity.ok(taskService.updTask(taskParam));
    }


    /**
     // --> INSERT SECTION
     *
     * insTask api que Realiza un insert sobre la tabla tareas
     */
    @PostMapping("/insTask")
    private ResponseEntity<?> insTask(@RequestBody TaskParam taskParam) throws ApplicationException.IllegalArgument {
        return ResponseEntity.ok(taskService.insTask(taskParam));
    }

    /**
     // --> DELETE SECTION
     *
     * delTask api que Realiza un delete sobre la tabla tareas
     */
    @DeleteMapping("/delTask")
    private ResponseEntity<?> delTask(@QueryParam("id") Integer id) throws ApplicationException.IllegalArgument {
        return ResponseEntity.ok(taskService.delTask(id));
    }

}

