package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
import java.util.Date;

public interface UsuarioService {
    //void crearPlaylist(Integer id_usuario, String titulo);
    void agregarUsuario(String username, String password, String email, String nombre, String apellido, Date fecha_nacimineto, String path_foto_perfil);
    void eliminarUsuario(Integer id_usuario);
    void cambiarFotoPerfil(Integer id_usuario, String path_foto_perfil);
    void cambiarPassword(Integer id_usuario, String password);
    void cambiarEmail(Integer id_usuario, String email);
}
