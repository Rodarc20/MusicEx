package com.example.repositorio;

/**
 * Created by rodrigo on 30/06/16.
 */
import java.util.List;

import com.example.dominio.Puntuacion;
import org.springframework.data.repository.CrudRepository;

public interface PuntuacionRepositorio extends CrudRepository<Puntuacion, Integer>{
    List<Puntuacion> findAll();
    Puntuacion findOne(Integer id_puntuacion);
}
