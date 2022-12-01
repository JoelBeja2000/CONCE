package com.concesionariopepe.com.service.impl;

import com.concesionariopepe.com.service.TrabajadorService;
import com.concesionariopepe.com.service.dto.TrabajadorDTO;
import com.concesionariopepe.com.service.mapper.TrabajadorMapper;
import com.concesionariopepe.com.domain.Trabajador;
import com.concesionariopepe.com.repository.TrabajadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Trabajador}.
 */
@Service
@Transactional
public class TrabajadorServiceImpl implements TrabajadorService {

    private final Logger log = LoggerFactory.getLogger(TrabajadorServiceImpl.class);

    private final TrabajadorRepository trabajadorRepository;

    public TrabajadorServiceImpl(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    /**
     * Save a trabajador.
     *
     * @param trabajador the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Trabajador save(Trabajador trabajador) {
        log.debug("Request to save Trabajador : {}", trabajador);
        return trabajadorRepository.save(trabajador);
    }

    /**
     * Get all the trabajadors.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TrabajadorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Trabajadors");

        Page<Trabajador> trabajadorToTrabajadorDto = trabajadorRepository.findAll(pageable);

         List<TrabajadorDTO> trabajadoresDtoLista = new ArrayList<>();

         TrabajadorMapper trabajadorMapper = new TrabajadorMapper();
         trabajadorToTrabajadorDto.forEach(trabajador -> {
                  int numeroVentas = trabajadorRepository.getAllCounterSales(trabajador.getId());
                  double comision = numeroVentas * 1.5;
                  if(numeroVentas==13 ){comision = 19.5;};
                  trabajadoresDtoLista.add(trabajadorMapper.toDTO(trabajador, numeroVentas,comision));
          });
          return new PageImpl<>(trabajadoresDtoLista, pageable,trabajadorToTrabajadorDto.getSize());

    }

    // @Override
    // @Transactional(readOnly = true)
    // public Page<TrabajadorDTO> findAll(Pageable pageable) {
    //     log.debug("Request to get all Trabajadors");
    //     Page<Trabajador> trabajadores = trabajadorRepository.findAll(pageable);


    //     List<TrabajadorDTO> trabajadoresDTO = new ArrayList<>();
    //     TrabajadorMapper trabajadorMapper = new TrabajadorMapper();
    //     trabajadores.forEach(trabajador -> {
    //         Long numeroVentas = trabajadorRepository.getAllCounterSales(trabajador.getId());
    //         trabajadoresDTO.add(trabajadorMapper.toDTO(trabajador, numeroVentas));
    //     });
    //     return new PageImpl<>(trabajadoresDTO, pageable,trabajadores.getSize());
    // }


    /**
     * Get one trabajador by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Trabajador> findOne(Long id) {
        log.debug("Request to get Trabajador : {}", id);
        return trabajadorRepository.findById(id);
    }

    /**
     * Delete the trabajador by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Trabajador : {}", id);
        trabajadorRepository.deleteById(id);
    }
}
