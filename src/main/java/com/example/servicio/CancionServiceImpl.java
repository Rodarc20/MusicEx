package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
import com.example.dominio.Album;
import com.example.dominio.Cancion;
import com.example.repositorio.AlbumRepositorio;
import com.example.repositorio.CancionRepositorio;
import com.example.repositorio.PuntuacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CancionServiceImpl implements CancionService{
    CancionRepositorio cancionRepositorio;
    AlbumRepositorio albumRepositorio;
    PuntuacionRepositorio puntuacionRepositorio;

    @Autowired
    public CancionServiceImpl(CancionRepositorio cr, AlbumRepositorio ar, PuntuacionRepositorio pr){
        this.cancionRepositorio = cr;
        this.albumRepositorio = ar;
        this.puntuacionRepositorio = pr;
    }

    @Transactional
    @Override
    public void agregarCancion(Integer id_album, String titulo, String path, Integer numero, Integer duracion){
        Album album = albumRepositorio.findOne(id_album);
        Cancion cancion = new Cancion();
        cancion.setAlbum(album);
        cancion.setTitulo(titulo);
        cancion.setPath(path);
        cancion.setNumero(numero);
        cancion.setDuracion(duracion);
        cancion.setPuntuacion(0);
        cancion.setNumero_seguidores(0);
        cancion.setReproducciones(0);
        cancionRepositorio.save(cancion);
    }

    @Override
    public void eliminarCancion(Integer id_cancion){
        cancionRepositorio.delete(id_cancion);
    }

    @Override
    public void incrementarSeguidores(Integer id_cancion){
        Cancion cancion = cancionRepositorio.findOne(id_cancion);
        cancion.setNumero_seguidores(cancion.getNumero_seguidores() + 1);
        cancionRepositorio.save(cancion);
    }

    @Override
    public void calcularPuntuacion(Integer id_cancion){
        Cancion cancion = cancionRepositorio.findOne(id_cancion);
        cancion.setPuntuacion(puntuacionRepositorio.puntuacionCancion(cancion)/puntuacionRepositorio.cantidadPuntuacionesCancion(cancion));
        cancionRepositorio.save(cancion);
        //calcular puntuacion, deberia tener un tabla puntuaciones
    }

    @Override
    public List<Cancion> canciones(){
        return cancionRepositorio.findAll();
    }
}
