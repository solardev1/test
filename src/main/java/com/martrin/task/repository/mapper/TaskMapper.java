package com.martrin.task.repository.mapper;


import com.martrin.task.model.param.TaskParam;
import com.martrin.task.model.response.TaskResponse;
import com.martrin.task.repository.sqlProviders.TaskSqlProviders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Autowired
    void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);

    /**
     * // --> INQUIRIES SECTION --> //  contiene todos los select que se realizan en los diversos casos
     */
    @SelectProvider(type = TaskSqlProviders.class, method = "selectListTask")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nombre", column = "nombre"),
            @Result(property = "descripcion", column = "descripcion"),
            @Result(property = "fecha_limite", column = "fecha_limite"),
            @Result(property = "estado", column = "estado")
    })
    List<TaskResponse> selectTasks(@Param("estado") String estado, @Param("fecha_limite") String fecha_limite);

    @Select("SELECT nombre as nombreTask\n" +
            "FROM tareas \n" +
            "WHERE nombre = #{nombre,jdbcType=VARCHAR} ")
    @Results({
            @Result(column = "nombreTask"),
    })
    String getNombreTarea(@Param("nombre") String nombre);


    /**
     * // --> UPDATES SECTION --> // contiene todos los updates que se realizan en los diversos casos
     */
    @UpdateProvider(type = TaskSqlProviders.class, method = "updTask")
    Boolean updByTask(TaskParam taskParam);


    /**
     * // --> INSERT SECTION --> // contiene todos los insert que se realizan en los diversos casos
     */
    @InsertProvider(type = TaskSqlProviders.class, method = "insTask")
    int insByTask(TaskResponse taskResp);


    /**
     * // --> DELETE SECTION --> // contiene todos los delete que se realizan en los diversos casos
     */
    @Delete(
            "DELETE from tareas WHERE id =  #{id,jdbcType=DECIMAL}"
    )
    int delByTask(@Param("id") Integer id);

}
