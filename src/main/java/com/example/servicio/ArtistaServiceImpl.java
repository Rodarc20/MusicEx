package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
import com.example.dominio.Artista;
import com.example.repositorio.ArtistaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArtistaServiceImpl implements ArtistaService{
    @Autowired
    ArtistaRepositorio artistaRepositorio;

    @Autowired
    public ArtistaServiceImpl (ArtistaRepositorio ar){
        this.artistaRepositorio = ar;
    }

    @Transactional
    @Override
    public void agregarArtista(String nombre, String descripcion, String pathFoto){
        Artista artista = new Artista();
        artista.setNombre(nombre);
        artista.setDescripcion(descripcion);
        artista.setPathFoto(pathFoto);
        artista.setPuntuacion(0);
        artista.setSeguidores(0);
        artistaRepositorio.save(artista);
    }

    @Transactional
    @Override
    public Artista agregarArtista(Artista artista){
        return artistaRepositorio.save(artista);
    }
    @Override
    public void eliminarArtista(Integer idArtista){//en toeira no deberia poder elimina un artista que tiene albunes, primero debo eliminar los albums
        artistaRepositorio.delete(idArtista);
    }

    @Override
    public void incrementarSeguidores(Integer idArtista){
        Artista artista = artistaRepositorio.findOne(idArtista);
        artista.setSeguidores(artista.getSeguidores()+1);
        artistaRepositorio.save(artista);
    }

    @Override
    public void calcularPuntuacion(Integer idArtista){
        //calcular
    }
    @Override
    public List<Artista> all(){
        return artistaRepositorio.findAll();
    }
}
