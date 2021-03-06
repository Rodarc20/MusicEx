package com.example.repositorio;

/**
 * Created by rodrigo on 17/06/16.
 */
import java.util.List;

import com.example.dominio.Artista;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.dominio.Album;

public interface AlbumRepositorio extends CrudRepository<Album, Integer>{
    List<Album> findAll();
    Album findOne(Integer idAlbum);
    List<Album> findByArtista(Artista artista);
    @Query("select al from Album al where al.titulo = :titulo")//jpql
    Album buscarPorTitulo(String titulo);
}
