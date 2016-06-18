package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
import com.example.dominio.Album;
import com.example.dominio.Cancion;
import com.example.repositorio.AlbumRepositorio;
import com.example.repositorio.CancionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancionServiceImpl implements CancionService{
    CancionRepositorio cancionRepositorio;
    AlbumRepositorio albumRepositorio;

    @Autowired
    public CancionServiceImpl(CancionRepositorio cr, AlbumRepositorio ar){
        this.cancionRepositorio = cr;
        this.albumRepositorio = ar;
    }

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

}
