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
    public void agregarCancion(Integer idAlbum, String titulo, String path, Integer numero, Integer duracion){
        Album album = albumRepositorio.findOne(idAlbum);
        Cancion cancion = new Cancion();
        cancion.setAlbum(album);
        cancion.setTitulo(titulo);
        cancion.setPath(path);
        cancion.setNumero(numero);
        cancion.setDuracion(duracion);
        cancion.setPuntuacion(0);
        cancion.setNumeroSeguidores(0);
        cancion.setReproducciones(0);
        cancionRepositorio.save(cancion);
    }

    @Override
    public void eliminarCancion(Integer idCancion){
        cancionRepositorio.delete(idCancion);
    }

    @Override
    public void incrementarSeguidores(Integer idCancion){
        Cancion cancion = cancionRepositorio.findOne(idCancion);
        cancion.setNumeroSeguidores(cancion.getNumeroSeguidores() + 1);
        cancionRepositorio.save(cancion);
    }

    @Override
    public void calcularPuntuacion(Integer idCancion){
        Cancion cancion = cancionRepositorio.findOne(idCancion);
        cancion.setPuntuacion(puntuacionRepositorio.puntuacionCancion(cancion)/puntuacionRepositorio.cantidadPuntuacionesCancion(cancion));
        cancionRepositorio.save(cancion);
        //calcular puntuacion, deberia tener un tabla puntuaciones
    }

    @Override
    public Cancion verCancion(Integer idCancion){
        return cancionRepositorio.findOne(idCancion);
    }

    @Override
    public List<Cancion> canciones(){
        return cancionRepositorio.findAll();
    }
}
