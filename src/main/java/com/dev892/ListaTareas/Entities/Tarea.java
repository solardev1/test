package com.dev892.ListaTareas.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Tareas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombreTarea;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", nombreTarea='" + nombreTarea + '\'' +
                '}';
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public int getId() {
        return id;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }
}

