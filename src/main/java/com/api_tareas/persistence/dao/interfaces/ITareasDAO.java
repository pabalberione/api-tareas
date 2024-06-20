package com.api_tareas.persistence.dao.interfaces;

import com.api_tareas.persistence.entity.TareasEntity;

import java.util.List;
import java.util.Optional;

public interface ITareasDAO {
     List<TareasEntity>obtenerTodos();
     Optional<TareasEntity> obtenerPorId(Long id);
     void crearTarea(TareasEntity tareasEntity);
     void modificarTarea(TareasEntity tareasEntity);
     void eliminarTarea(TareasEntity tareasEntity);

}
