    package com.concesionariopepe.com.service;

import com.concesionariopepe.com.domain.Vehiculo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Vehiculo}.
 */
public interface VehiculoService {

    /**
     * Save a vehiculo.
     *
     * @param vehiculo the entity to save.
     * @return the persisted entity.
     */
    Vehiculo save(Vehiculo vehiculo);

    /**
     * Get all the vehiculos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Vehiculo> findAll(Pageable pageable);


    Page<Vehiculo> getDisponibles(Pageable pageable);



    /**
     * Get the "id" vehiculo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Vehiculo> findOne(Long id);

    /**
     * Delete the "id" vehiculo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
