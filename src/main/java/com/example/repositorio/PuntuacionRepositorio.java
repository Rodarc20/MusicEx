package com.example.repositorio;

/**
 * Created by rodrigo on 30/06/16.
 */
import java.util.List;

import com.example.dominio.Cancion;
import com.example.dominio.Puntuacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PuntuacionRepositorio extends CrudRepository<Puntuacion, Integer>{
    List<Puntuacion> findAll();
    Puntuacion findOne(Integer idPuntuacion);
    @Query("select sum(p.puntuacion) from Puntuacion p where p.cancion = :cancion group by p.cancion")//" where p.cancion = :cancion group by p.cancion")
    Integer puntuacionCancion(Cancion cancion);
    @Query("select count(p.usuario) from Puntuacion p where p.cancion = :cancion group by p.cancion")//" where p.cancion = :cancion group by p.cancion")
    Integer cantidadPuntuacionesCancion(Cancion cancion);
}
