package com.concesionariopepe.com.repository;

import com.concesionariopepe.com.domain.Vehiculo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Vehiculo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
@Query ("SELECT c FROM Vehiculo c LEFT JOIN c.compraventa v WHERE v IS null")
Page<Vehiculo> getDisponibles(Pageable pageable);
}
