package com.example.repositorio;

/**
 * Created by rodrigo on 17/06/16.
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.dominio.Artista;

public interface ArtistaRepositorio extends CrudRepository<Artista, Integer>{
    List<Artista> findAll();
    Artista findOne(Integer idArtista);
}
