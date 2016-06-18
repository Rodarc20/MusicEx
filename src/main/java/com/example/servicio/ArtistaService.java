package com.example.servicio;

/**
 * Created by rodrigo on 17/06/16.
 */
public interface ArtistaService {
    void agregarArtista(String nombre, String descripcion, String path_foto);//no se si sea asi o pasando datos, recibe los id
    void eliminarArtista(Integer id_artista);// o en realidad sea otra la logica
}
