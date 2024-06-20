package com.api_tareas.service.interfaces;

import com.api_tareas.presentation.dto.TareasDTO;

import java.util.List;

public interface ITareasService {
    List<TareasDTO>obtenerTodos();
    TareasDTO obtenerPorId(Long id);
    TareasDTO crearTarea(TareasDTO tareasDTO);
    TareasDTO modificarTarea(TareasDTO tareasDTO, Long id);
    String eliminarTarea(Long id);
}
