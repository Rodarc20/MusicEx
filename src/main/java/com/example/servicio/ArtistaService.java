package com.example.servicio;

import com.example.dominio.Artista;

import java.util.List;

/**
 * Created by rodrigo on 17/06/16.
 */
public interface ArtistaService {
    void agregarArtista(String nombre, String descripcion, String pathFoto);//no se si sea asi o pasando datos, recibe los id
    Artista agregarArtista(Artista artista);//no se si sea asi o pasando datos, recibe los id
    void eliminarArtista(Integer idArtista);// o en realidad sea otra la logica
    void incrementarSeguidores(Integer idArtista);//el incremento siempre es de 1
    void calcularPuntuacion(Integer idArtista);
    List<Artista> all();
}
