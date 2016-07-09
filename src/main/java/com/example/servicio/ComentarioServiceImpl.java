package com.example.servicio;

/**
 * Created by rodrigo on 25/06/16.
 */
import com.example.dominio.Album;
import com.example.dominio.Comentario;
import com.example.dominio.Usuario;
import com.example.repositorio.AlbumRepositorio;
import com.example.repositorio.ComentarioRepositorio;
import com.example.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ComentarioServiceImpl implements ComentarioService{
    ComentarioRepositorio comentarioRepositorio;
    AlbumRepositorio albumRepositorio;
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public ComentarioServiceImpl (ComentarioRepositorio cr, AlbumRepositorio ar, UsuarioRepositorio ur){
        comentarioRepositorio = cr;
        albumRepositorio = ar;
        usuarioRepositorio = ur;
    }

    @Transactional
    @Override
    public void agregarComentario(Integer idUsuario, Integer idAlbum, String comentario){
        Usuario usuario = usuarioRepositorio.findOne(idUsuario);
        Album album = albumRepositorio.findOne(idAlbum);
        Comentario coment = new Comentario();
        coment.setUsuario(usuario);
        coment.setAlbum(album);
        coment.setComentario(comentario);
        coment.setFecha(new Date());
        comentarioRepositorio.save(coment);
    }

    @Override
    public void eliminarComentario(Integer idComentario){
        comentarioRepositorio.delete(idComentario);
    }

    @Override
    public void editarComentario(Integer idComentario, String comentario){
        Comentario coment = comentarioRepositorio.findOne(idComentario);
        coment.setComentario(comentario);
        comentarioRepositorio.save(coment);
    }
}
