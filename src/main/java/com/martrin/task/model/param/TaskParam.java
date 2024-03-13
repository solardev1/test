package com.martrin.task.model.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * Paramentros que se enviaran para realizar operaciones sobre la tabla tareas
 */
public class TaskParam {
    /**  id (PK) que se genera y se guarda por cada tarea  */
    private Integer id;
    /**  Nombre que se le asignara a la tarea creada */
    private String nombre;
    /**  Descripcion que se asignara y explicara brevemente en que consiste la tarea  */
    private String descripcion;
    /**  Fecha Limite que se le asignara y durara la tarea creada  */
    private String fecha_limite;
    /**  Estado que se asiganara a la tarea creada  */
    private String estado;
}
