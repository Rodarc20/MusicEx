package com.example.servicio;

/**
 * Created by rodrigo on 25/06/16.
 */
public interface ComentarioService {
    void agregarComentario(Integer id_usuario, Integer id_album, String comentario);
    void eliminarComentario(Integer id_comentario);
    void editarComentario(Integer id_comentario, String comentario);
}
