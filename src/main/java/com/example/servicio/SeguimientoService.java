package com.example.servicio;

/**
 * Created by rodrigo on 30/06/16.
 */
public interface SeguimientoService {
    void seguirUsuario(Integer id_usuario1, Integer id_usuario2);
    void noSeguirUsuario(Integer id_seguimiento);
}
