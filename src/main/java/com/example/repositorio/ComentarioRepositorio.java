package com.example.repositorio;

/**
 * Created by rodrigo on 25/06/16.
 */
import java.util.List;

import com.example.dominio.Comentario;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioRepositorio extends CrudRepository<Comentario, Integer>{
    List<Comentario> findAll();
    Comentario findOne(Integer id_comentario);
}
