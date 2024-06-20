package com.api_tareas.presentation.controller;

import com.api_tareas.presentation.dto.TareasDTO;
import com.api_tareas.service.interfaces.ITareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tareas")
public class TareasController {

    @Autowired
    ITareasService iTareasService;

    //Obtener todos
    @GetMapping
    public ResponseEntity<List<TareasDTO>>obtenerTodos(){
        return new ResponseEntity<>(this.iTareasService.obtenerTodos(), HttpStatus.OK);
    }

    //Obtener por Id
    @GetMapping("/{id}")
    public ResponseEntity<TareasDTO>obtenerPorId(@PathVariable Long id){
        return new ResponseEntity<>(this.iTareasService.obtenerPorId(id), HttpStatus.OK);
    }

    //Crear
    @PostMapping
    public ResponseEntity<TareasDTO>crearTarea(@RequestBody TareasDTO tareasDTO){
        return new ResponseEntity<>(this.iTareasService.crearTarea(tareasDTO), HttpStatus.CREATED);
    }

    //Modificar Tarea
    @PutMapping("/{id}")
    public ResponseEntity<TareasDTO>modificarTarea(@RequestBody TareasDTO tareasDTO, @PathVariable Long id){
        return new ResponseEntity<>(this.iTareasService.modificarTarea(tareasDTO, id),HttpStatus.OK);
    }

    //Eliminar Tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminarTarea(@PathVariable Long id){
        return new ResponseEntity<>(this.iTareasService.eliminarTarea(id), HttpStatus.NO_CONTENT);
    }
}
