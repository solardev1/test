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
 * Response que se genera y devolvera una operacion realizada sobre la tabla tareas
 */
public class TaskResponse {
    /**  id (PK) que se genera y se guarda por cada tarea  */
    private Integer id;
    /**  Nombre asignado a la tarea creada  */
    private String nombre;
    /**  Descripcion que explica brevemente en que consiste la tarea  */
    private String descripcion;
    /**  Fecha Limite que durara la tarea creada y asignada  */
    private String fecha_limite;
    /**  Estado que se asiganara a la tarea mientras de va avanzando  */
    private String estado;


    public TaskResponse(String nombre, String descripcion, String fecha_limite, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_limite = fecha_limite;
        this.estado = estado;
    }
}
