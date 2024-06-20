package com.api_tareas.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Dejar solo las anotaciones Data, AllArgsConstructor y NoArgsConstructor
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareasDTO {
    private Long id;
    private String descripcion;
    private String status;
}
