package com.example.repositorio;

/**
 * Created by rodrigo on 17/06/16.
 */
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.dominio.Album;

public interface AlbumRepositorio extends CrudRepository<Album, Integer>{
    List<Album> findAll();
    Album findOne(Integer id_album);
}
