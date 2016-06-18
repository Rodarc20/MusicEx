package com.example.repositorio;

/**
 * Created by rodrigo on 18/06/16.
 */
import java.util.List;

import com.example.dominio.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
    List<Usuario> findAll();
    Usuario findOne(Integer id_usuario);
}
