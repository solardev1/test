package com.martrin.task.repository.sqlProviders;

import com.martrin.task.model.param.TaskParam;
import com.martrin.task.model.response.TaskResponse;
import org.apache.ibatis.jdbc.SQL;

public class TaskSqlProviders {

    public String selectListTask(String estado, String fecha_limite) {
        SQL sql = new SQL();
        sql.SELECT("id, nombre, descripcion, fecha_limite, estado from tareas");

        if (estado != null) {
            sql.WHERE("estado = #{estado}");
        }
        if (fecha_limite != null) {
            sql.WHERE("fecha_limite = #{fecha_limite}");
        }

        return sql.toString();
    }


    public String updTask(TaskParam taskParam) {

        SQL sql = new SQL();
        sql.UPDATE("tareas");

        if (taskParam.getNombre() != null) {
            sql.SET("nombre = #{nombre,jdbcType=VARCHAR}");
        }
        if (taskParam.getDescripcion() != null) {
            sql.SET("descripcion = #{descripcion,jdbcType=VARCHAR}");
        }
        if (taskParam.getFecha_limite() != null) {
            sql.SET("fecha_limite = #{fecha_limite,jdbcType=VARCHAR}");
        }
        if (taskParam.getEstado() != null) {
            sql.SET("estado = #{estado,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=DECIMAL}");


        return sql.toString();
    }

    public String insTask(TaskResponse taskResp) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tareas");

        if (taskResp.getNombre() != null) {
            sql.VALUES("nombre", "#{nombre,jdbcType=VARCHAR}");
        }

        if (taskResp.getDescripcion() != null) {
            sql.VALUES("descripcion", "#{descripcion,jdbcType=VARCHAR}");
        }

        if (taskResp.getFecha_limite() != null) {
            sql.VALUES("fecha_limite", "#{fecha_limite,jdbcType=VARCHAR}");
        }

        if (taskResp.getEstado() != null) {
            sql.VALUES("estado", "#{estado,jdbcType=VARCHAR}");
        }


        return sql.toString();
    }
}
