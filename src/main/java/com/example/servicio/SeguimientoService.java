package com.example.servicio;

import com.example.dominio.Usuario;

import java.util.List;

/**
 * Created by rodrigo on 30/06/16.
 */
public interface SeguimientoService {
    void seguirUsuario(Integer idUsuario1, Integer idUsuario2);
    void noSeguirUsuario(Integer idSeguimiento);
    //List<Usuario> usuariosSeguidos(Usuario usuario);//por dria recibir Integer id_usuario
    List<Usuario> usuariosSeguidos(Integer idUsuario);//por dria recibir Integer id_usuario
}
