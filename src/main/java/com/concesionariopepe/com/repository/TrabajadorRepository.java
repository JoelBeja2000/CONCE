package com.concesionariopepe.com.repository;

import com.concesionariopepe.com.domain.Trabajador;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Trabajador entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {

}
