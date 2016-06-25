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
    public void agregarComentario(Integer id_usuario, Integer id_album, String comentario){
        Usuario usuario = usuarioRepositorio.findOne(id_usuario);
        Album album = albumRepositorio.findOne(id_album);
        Comentario coment = new Comentario();
        coment.setUsuario(usuario);
        coment.setAlbum(album);
        coment.setComentario(comentario);
        coment.setFecha(new Date());
        comentarioRepositorio.save(coment);
    }

    @Override
    public void eliminarComentario(Integer id_comentario){
        comentarioRepositorio.delete(id_comentario);
    }

    @Override
    public void editarComentario(Integer id_comentario, String comentario){
        Comentario coment = comentarioRepositorio.findOne(id_comentario);
        coment.setComentario(comentario);
        comentarioRepositorio.save(coment);
    }
}
