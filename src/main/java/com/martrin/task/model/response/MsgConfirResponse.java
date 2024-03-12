package com.martrin.task.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * Clase para manejo de Response varios en operaciones sobre la tabla tareas
 */
public class MsgConfirResponse {
    /**  Mensaje de aprobacion y/o rechazo en despliegues de apis sobre la tabla tareas  */
    private String msg;
    /**  Estado de la operarion 200, message = Operación exitosa, 400, message = Solicitud inválida, 401, message = No autorizado, 500, message = Error interno del servidor  */
    private String status;
}
