package com.example.repositorio;

/**
 * Created by rodrigo on 30/06/16.
 */
import java.util.List;

import com.example.dominio.Seguimiento;
import com.example.dominio.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SeguimientoRepositorio extends CrudRepository<Seguimiento, Integer>{
    List<Seguimiento> findAll();
    //@Query("SELECT s FROM Seguimiento s WHERE s.id_usuario1 = i")
    //Seguimiento findOne();
}
