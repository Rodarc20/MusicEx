package com.example.servicio;

import java.util.Date;

/**
 * Created by rodrigo on 17/06/16.
 */
public interface AlbumService {
    void agregarAlbum(Integer id_artista, String titulo, String path_foto, Date fecha);
    void eliminarAlbum(Integer id_album);//quiza este no deberia estar o deberia recibir un albun en lugar de datos
}
