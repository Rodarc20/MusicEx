package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
import com.example.dominio.Usuario;

import java.util.Date;

public interface UsuarioService {
    //void crearPlaylist(Integer id_usuario, String titulo);
    void agregarUsuario(String username, String password, String email, String nombre, String apellido, Date fecha_nacimineto, String pathFotoPerfil);
    void agregarUsuario(Usuario usuario);
    void eliminarUsuario(Integer idUsuario);
    void cambiarFotoPerfil(Integer idUsuario, String pathFotoPerfil);
    void cambiarPassword(Integer idUsuario, String password);
    void cambiarEmail(Integer idUsuario, String email);
    Usuario verUsuario(Integer idUsuaio);
}
