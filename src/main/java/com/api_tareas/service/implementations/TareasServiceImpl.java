package com.api_tareas.service.implementations;

import com.api_tareas.persistence.dao.interfaces.ITareasDAO;
import com.api_tareas.persistence.entity.TareasEntity;
import com.api_tareas.presentation.dto.TareasDTO;
import com.api_tareas.service.interfaces.ITareasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TareasServiceImpl implements ITareasService {

    @Autowired
    ITareasDAO iTareasDAO;

    @Override
    public List<TareasDTO> obtenerTodos() {
        ModelMapper modelMapper = new ModelMapper();

        return this.iTareasDAO.obtenerTodos()
                .stream()
                .map(entity -> modelMapper.map(entity, TareasDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TareasDTO obtenerPorId(Long id) {
        Optional<TareasEntity> tareaEntity = this.iTareasDAO.obtenerPorId(id);
        if(tareaEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            TareasEntity tareaActual = tareaEntity.get();
            return modelMapper.map(tareaActual, TareasDTO.class);
        } else {
            return new TareasDTO();
        }
    }

    @Override
    public TareasDTO crearTarea(TareasDTO tareasDTO) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            TareasEntity tareasEntity = modelMapper.map(tareasDTO, TareasEntity.class);
            this.iTareasDAO.crearTarea(tareasEntity);
            return tareasDTO;
        }catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el usuario");
        }
    }

    @Override
    public TareasDTO modificarTarea(TareasDTO tareasDTO, Long id) {
        Optional<TareasEntity> tareaEntity = this.iTareasDAO.obtenerPorId(id);

        if(tareaEntity.isPresent()){
            TareasEntity tareaActual = tareaEntity.get();
            tareaActual.setDescripcion(tareasDTO.getDescripcion());
            tareaActual.setStatus(tareasDTO.getStatus());
            this.iTareasDAO.modificarTarea(tareaActual);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(tareaActual,TareasDTO.class);
        } else{
            throw new IllegalArgumentException("El usuario no existe");
        }
    }

    @Override
    public String eliminarTarea(Long id) {
        Optional<TareasEntity> tareaEntity = this.iTareasDAO.obtenerPorId(id);

        if(tareaEntity.isPresent()){
            TareasEntity tareaActual = tareaEntity.get();
            this.iTareasDAO.eliminarTarea(tareaActual);
            return "Tarea con id " + id + " ha sido eliminada";
        } else {
            return "Tarea con id " + id + " no existe";
        }
    }
}
