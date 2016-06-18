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
//import com.example.repositorio.CancionRepositorio;
import com.example.repositorio.ArtistaRepositorio;//este tampoco va aqui creo

@Service
public class AlbumServiceImpl implements AlbumService{
    //CancionRepositorio cancionRepositorio;
    AlbumRepositorio albumRepositorio;
    ArtistaRepositorio artistaRepositorio;

    @Autowired
    public AlbumServiceImpl(AlbumRepositorio alr, ArtistaRepositorio arr){
    //public AlbumServiceImpl(CancionRepositorio cr, AlbumRepositorio alr, ArtistaRepositorio arr){//no es necesario al cancion
        //this.cancionRepositorio = cr;
        this.albumRepositorio = alr;
        this.artistaRepositorio = arr;
    }

    @Transactional
    @Override
    public void agregarAlbum(Integer id_artista, String titulo, String path_foto, Date fecha){// se supone que ya tengo la foto almacenada en una carpeta especial
        Artista artista = artistaRepositorio.findOne(id_artista);
        Album album = new Album();//o podria usar el otro constructor, pero parace que la logica de negocios no usa constructores, seguir por ahora asi
        album.setArtista(artista);
        album.setTitulo(titulo);
        album.setPath_foto(path_foto);
        album.setFecha(fecha);
        album.setSeguidores(0);
        album.setPuntuacion(0);
        albumRepositorio.save(album);
    }

    @Override
    public void eliminarAlbum(Integer id_album){//en teoria deberia recibi artista u titulo para eliminar, por ahroa recibire el codigo dl album
        Album album = albumRepositorio.findOne(id_album);//al usar el codigo del album, esta linea es inecesaria, el repositorio tiene una opcionpara elimnar por codigo
        albumRepositorio.delete(album);
    }

}
