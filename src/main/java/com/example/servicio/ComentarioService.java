package com.example.servicio;

/**
 * Created by rodrigo on 25/06/16.
 */
public interface ComentarioService {
    void agregarComentario(Integer idUsuario, Integer idAlbum, String comentario);
    void eliminarComentario(Integer idComentario);
    void editarComentario(Integer idComentario, String comentario);
}
