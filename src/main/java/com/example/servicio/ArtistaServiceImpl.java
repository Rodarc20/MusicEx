package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
import com.example.dominio.Artista;
import com.example.repositorio.ArtistaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistaServiceImpl implements ArtistaService{
    ArtistaRepositorio artistaRepositorio;

    @Autowired
    public ArtistaServiceImpl (ArtistaRepositorio ar){
        this.artistaRepositorio = ar;
    }

    @Transactional
    @Override
    public void agregarArtista(String nombre, String descripcion, String path_foto){
        Artista artista = new Artista();
        artista.setNombre(nombre);
        artista.setDescripcion(descripcion);
        artista.setPath_foto(path_foto);
        artista.setPuntuacion(0);
        artista.setSeguidores(0);
        artistaRepositorio.save(artista);
    }

    @Override
    public void eliminarArtista(Integer id_artista){//en toeira no deberia poder elimina un artista que tiene albunes, primero debo eliminar los albums
        artistaRepositorio.delete(id_artista);
    }

}
