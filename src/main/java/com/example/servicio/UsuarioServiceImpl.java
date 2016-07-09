package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
import java.util.Date;

import com.example.dominio.Playlist;
import com.example.dominio.Usuario;
import com.example.repositorio.PlaylistRepositorio;
import com.example.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    UsuarioRepositorio usuarioRepositorio;
    PlaylistRepositorio playlistRepositorio;

    @Autowired
    public UsuarioServiceImpl (UsuarioRepositorio ur){
        this.usuarioRepositorio = ur;
    }

    @Transactional
    @Override
    public void agregarUsuario(String username, String password, String email, String nombre, String apellido, Date fechaNacimineto, String pathFotoPerfil){
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setFechaNacimiento(fechaNacimineto);
        usuario.setPathFotoPerfil(pathFotoPerfil);
        usuario.setFechaCreacion(new Date());
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario){
        usuarioRepositorio.delete(idUsuario);
    }

    @Override
    public void cambiarFotoPerfil(Integer idUsuario, String pathFotoPerfil){
        Usuario usuario = usuarioRepositorio.findOne(idUsuario);
        String pathEliminar = usuario.getPathFotoPerfil();//deberia eliminar esta foto anterior, de mi base de datos, aun no se como trabajaremos las imagenes
        usuario.setPathFotoPerfil(pathFotoPerfil);
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void cambiarPassword(Integer idUsuario, String password){
        Usuario usuario = usuarioRepositorio.findOne(idUsuario);
        usuario.setPassword(password);
        usuarioRepositorio.save(usuario);
    }
    @Override
    public void cambiarEmail(Integer idUsuario, String email){
        Usuario usuario = usuarioRepositorio.findOne(idUsuario);
        usuario.setEmail(email);
        usuarioRepositorio.save(usuario);
    }
    @Override
    public Usuario verUsuario(Integer idUsuario){
        return usuarioRepositorio.findOne(idUsuario);
    }
    /*@Override
    public void crearPlaylist(Integer id_usuario, String titulo){
        Playlist playlist = new Playlist();
        Usuario usuario = usuarioRepositorio.findOne(id_usuario);
        playlist.setTitulo(titulo);
        playlist.setUsuario(usuario);
        playlist.setSeguidores(0);
        playlist.setPuntuacion(0);
        playlistRepositorio.save(playlist);

    }*/
}
