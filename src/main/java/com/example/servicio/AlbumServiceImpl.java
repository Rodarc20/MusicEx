package com.example.servicio;

/**
 * Created by rodrigo on 17/06/16.
 */

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dominio.Album;
import com.example.dominio.Cancion;
import com.example.dominio.Artista;//quiza no vaya este
import com.example.repositorio.AlbumRepositorio;
import com.example.repositorio.CancionRepositorio;
import com.example.repositorio.ArtistaRepositorio;//este tampoco va aqui creo

@Service
public class AlbumServiceImpl implements AlbumService{
    CancionRepositorio cancionRepositorio;
    AlbumRepositorio albumRepositorio;
    ArtistaRepositorio artistaRepositorio;

    @Autowired
    public AlbumServiceImpl(CancionRepositorio cr, AlbumRepositorio alr, ArtistaRepositorio arr){
        this.cancionRepositorio = cr;
        this.albumRepositorio = alr;
        this.artistaRepositorio = arr;
    }

    @Override
    public void agregarAlbum(Integer id_artista, String titulo, String path_foto, Date fecha){// se supone que ya tengo la foto almacenada en una carpeta especial
        Artista artista = artistaRepositorio.findOne(id_artista);

    }

    @Override
    public void eliminarAlbum(Integer id_artista){

    }

}
