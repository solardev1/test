package com.martrin.task.service;

import com.martrin.task.model.param.TaskParam;
import com.martrin.task.model.response.MsgConfirResponse;
import com.martrin.task.model.response.TaskResponse;
import com.martrin.task.util.ApplicationException;

import java.util.List;

public interface TaskService {
    List<TaskResponse> taskList(String estado, String fecha_limite) throws ApplicationException.NotFound;
    MsgConfirResponse updTask(TaskParam taskParam) throws ApplicationException.IllegalArgument;
    TaskResponse insTask(TaskParam taskParam) throws ApplicationException.IllegalArgument;
    MsgConfirResponse delTask(Integer id) throws ApplicationException.IllegalArgument;
}
