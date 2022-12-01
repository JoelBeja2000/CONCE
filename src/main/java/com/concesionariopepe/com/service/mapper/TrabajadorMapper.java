package com.concesionariopepe.com.service.mapper;

import com.concesionariopepe.com.domain.Trabajador;
import com.concesionariopepe.com.service.dto.TrabajadorDTO;

public class TrabajadorMapper {

    public Trabajador trabajadorDtoToTrabajador(TrabajadorDTO trabajadorDto){

       Trabajador trabajador = new Trabajador();

       trabajador.setId(trabajadorDto.getId());

       trabajador.setDni(trabajadorDto.getDni());

       trabajador.setNombre(trabajadorDto.getNombre());

       trabajador.setApellido(trabajadorDto.getApellido());

       trabajador.setCargo(trabajadorDto.getCargo());

       trabajador.setTelefono(trabajadorDto.getTelefono());

       trabajador.setId(trabajadorDto.getId());

    return trabajador;
    }

    public TrabajadorDTO toDTO(Trabajador trabajador, Long numeroVentas) {
        return null;
    }
}