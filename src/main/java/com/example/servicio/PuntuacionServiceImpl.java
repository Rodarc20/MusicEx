package com.example.servicio;

/**
 * Created by rodrigo on 30/06/16.
 */
import com.example.dominio.Cancion;
import com.example.dominio.Puntuacion;
import com.example.dominio.Usuario;
import com.example.repositorio.CancionRepositorio;
import com.example.repositorio.PuntuacionRepositorio;
import com.example.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PuntuacionServiceImpl implements PuntuacionService{
    PuntuacionRepositorio puntuacionRepositorio;
    CancionRepositorio cancionRepositorio;
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public PuntuacionServiceImpl(PuntuacionRepositorio pr, CancionRepositorio cr, UsuarioRepositorio ur){
        this.puntuacionRepositorio = pr;
        this.cancionRepositorio = cr;
        this.usuarioRepositorio = ur;
    }
    @Transactional
    @Override
    public void agregarPuntuacion(Integer id_usuario, Integer id_cancion, Integer puntuacion) {
        Cancion cancion = cancionRepositorio.findOne(id_cancion);
        Usuario usuario = usuarioRepositorio.findOne(id_usuario);
        Puntuacion punt = new Puntuacion();
        punt.setUsuario(usuario);
        punt.setCancion(cancion);
        punt.setPuntuacion(puntuacion);
        punt.setFecha(new Date());
        puntuacionRepositorio.save(punt);
    }

    @Override
    public void eliminarPuntuacion(Integer id_puntuacion) {
        puntuacionRepositorio.delete(id_puntuacion);
    }

    @Override
    public void modificarPuntuacion(Integer id_puntuacion, Integer newPuntuacion) {
        Puntuacion puntuacion = puntuacionRepositorio.findOne(id_puntuacion);
        puntuacion.setPuntuacion(newPuntuacion);
        puntuacionRepositorio.save(puntuacion);
    }
}
