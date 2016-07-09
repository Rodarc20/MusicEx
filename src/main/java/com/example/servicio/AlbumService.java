package com.example.servicio;

import com.example.dominio.Album;

import java.util.Date;
import java.util.List;

/**
 * Created by rodrigo on 17/06/16.
 */
public interface AlbumService {
    void agregarAlbum(Integer idArtista, String titulo, String pathFoto, Date fecha);//quiza deba recibir el objeto artista
    void eliminarAlbum(Integer idAlbum);//quiza este no deberia estar o deberia recibir un albun en lugar de datos
    void incrementarSeguidores(Integer idAlbum);
    void calcularPuntuacion(Integer idAlbum);
    List<Album> albumArtista(Integer idAlbum);
}
