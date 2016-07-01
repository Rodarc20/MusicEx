package com.example.servicio;

/**
 * Created by rodrigo on 30/06/16.
 */
import com.example.dominio.Seguimiento;
import com.example.dominio.Usuario;
import com.example.repositorio.SeguimientoRepositorio;
import com.example.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SeguimientoServiceImpl implements SeguimientoService {
    SeguimientoRepositorio seguimientoRepositorio;
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public SeguimientoServiceImpl (SeguimientoRepositorio sr, UsuarioRepositorio ur){
        seguimientoRepositorio = sr;
        usuarioRepositorio = ur;
    }

    @Transactional
    @Override
    public void seguirUsuario(Integer id_usuario1, Integer id_usuario2) {
        Usuario usuario1 = usuarioRepositorio.findOne(id_usuario1);
        Usuario usuario2 = usuarioRepositorio.findOne(id_usuario2);
        Seguimiento seguimiento = new Seguimiento();
        seguimiento.setUsuario1(usuario1);
        seguimiento.setUsuario2(usuario2);
        seguimiento.setFecha(new Date());
        seguimientoRepositorio.save(seguimiento);
    }

    @Override
    public void noSeguirUsuario(Integer id_seguimiento) {
        seguimientoRepositorio.delete(id_seguimiento);
    }
}
