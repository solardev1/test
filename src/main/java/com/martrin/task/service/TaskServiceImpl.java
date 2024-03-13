package com.martrin.task.service;

import com.martrin.task.model.param.TaskParam;
import com.martrin.task.model.response.MsgConfirResponse;
import com.martrin.task.model.response.TaskResponse;
import com.martrin.task.repository.mapper.TaskMapper;
import com.martrin.task.util.ApplicationException;
import com.martrin.task.util.ServiceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = ApplicationException.AbortException.class)
/**
 * TaskService", description = "Servicio aplicados a TaskController
 */
public class TaskServiceImpl implements TaskService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    TaskMapper taskMapper;

    /**
     * Get - que realiza el select de las Tareas
     */
    @Override
    public List<TaskResponse> taskList(String estado, String fecha_limite) throws ApplicationException.NotFound {
        List<TaskResponse> tasks = taskMapper.selectTasks(estado, fecha_limite);
        if (tasks == null || tasks.isEmpty()) {
            ServiceUtils.validarEncontrado(tasks, "No se encontraron datos con los paramentros ingresados.");
        }
        return tasks;
    }


    /**
     * Put - que realiza el update de las Tareas
     */
    @Override
    public MsgConfirResponse updTask(TaskParam taskParam) throws ApplicationException.IllegalArgument {
        //validaciones
        ServiceUtils.validarArgumento(taskParam.getId(), "El  id de tarea no puede ser nulo, verifique y seleccione el registro.");

        MsgConfirResponse msg = new MsgConfirResponse();
        Boolean result = taskMapper.updByTask(taskParam);
        if (result) {
            msg.setMsg("Los cambios se realizaron correctamente.");
            msg.setStatus("200");
        } else {
            ServiceUtils.validarArgumento(false, "No se pudo realizar el cambio, favor contartar con el Administrador de sistema.");
        }
        return msg;
    }


    /**
     * Post - que realiza el insert de las Tareas
     */
    @Override
    public TaskResponse insTask(TaskParam taskParam) throws ApplicationException.IllegalArgument {
        /**  validaciones de parametros  */
        ServiceUtils.validarArgumento(taskParam.getNombre(), "El  nombre de la tarea no puede ser nulo.");
        ServiceUtils.validarArgumento(taskParam.getDescripcion(), "Debe escribir una descripcion.");
        ServiceUtils.validarArgumento(taskParam.getEstado(), "Debe determinar el estado de la tarea.");

        TaskResponse taskResp = new TaskResponse(taskParam.getNombre(), taskParam.getDescripcion(), taskParam.getFecha_limite(), taskParam.getEstado());

        /**  validaciones de registro  */
        String nombreTask = taskMapper.getNombreTarea(taskResp.getNombre());
        if (nombreTask != null && nombreTask.equals(taskResp.getNombre())) {
            ServiceUtils.validarArgumento(false, "No se pudo registrar un registro con el mismo nombre.");
        } else {
            taskMapper.insByTask(taskResp);
        }

        return taskResp;
    }


    /**
     * Post - que realiza el delete de las Tareas
     */
    @Override
    public MsgConfirResponse delTask(Integer id) throws ApplicationException.IllegalArgument {
        /**  validaciones de parametros  */
        ServiceUtils.validarArgumento(id, "El  id de tarea no puede ser nulo, verifique y seleccione el registro a eliminar.");

        MsgConfirResponse msg = new MsgConfirResponse();
        int result = taskMapper.delByTask(id);
        if (result > 0) {
            msg.setMsg("El registro se ha eliminado correctament.");
            msg.setStatus("200");
        } else {
            ServiceUtils.validarArgumento(false, "No se pudo pudo eliminar el registro, favor contartar con el Administrador de sistema.");
        }
        return msg;
    }
}
