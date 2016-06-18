package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
import java.util.Date;

public interface UsuarioService {
    void agregarUsuario(String username, String password, String email, String nombre, String apellido, Date fecha_nacimineto, String path_foto_perfil);
    void eliminarUsuario(Integer id_usuario);
}
