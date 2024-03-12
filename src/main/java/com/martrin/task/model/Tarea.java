package com.martrin.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * Clase Tarea que utilizado para levantar la estructura de la base en JPA va enlazado al archivo data.sql
 */
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**id clave PK auto incremental*/
    private Long id;
    private String nombre;
    private String descripcion;
    private String fechaLimite;
    private String estado;

}
