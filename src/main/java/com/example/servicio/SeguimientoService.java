package com.example.servicio;

import com.example.dominio.Usuario;

import java.util.List;

/**
 * Created by rodrigo on 30/06/16.
 */
public interface SeguimientoService {
    void seguirUsuario(Integer id_usuario1, Integer id_usuario2);
    void noSeguirUsuario(Integer id_seguimiento);
    //List<Usuario> usuariosSeguidos(Usuario usuario);//por dria recibir Integer id_usuario
    List<Usuario> usuariosSeguidos(Integer id_usuario);//por dria recibir Integer id_usuario
}
