package com.example.repositorio;

/**
 * Created by rodrigo on 30/06/16.
 */
import java.util.List;

import com.example.dominio.Seguimiento;
import com.example.dominio.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface SeguimientoRepositorio extends CrudRepository<Seguimiento, Integer>{
    List<Seguimiento> findAll();
    Seguimiento findOne(Integer id_seguimiento);
    Seguimiento findByUsuario1AndUsuario2(Usuario usuario1, Usuario usuario2);
}
