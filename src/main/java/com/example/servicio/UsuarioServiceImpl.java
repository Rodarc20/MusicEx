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
    public void agregarUsuario(String username, String password, String email, String nombre, String apellido, Date fecha_nacimineto, String path_foto_perfil){
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setFecha_nacimiento(fecha_nacimineto);
        usuario.setPath_foto_perfil(path_foto_perfil);
        usuario.setFecha_creacion(new Date());
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer id_usuario){
        usuarioRepositorio.delete(id_usuario);
    }

    @Override
    public void cambiarFotoPerfil(Integer id_usuario, String path_foto_perfil){
        Usuario usuario = usuarioRepositorio.findOne(id_usuario);
        String path_eliminar = usuario.getPath_foto_perfil();//deberia eliminar esta foto anterior, de mi base de datos, aun no se como trabajaremos las imagenes
        usuario.setPath_foto_perfil(path_foto_perfil);
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void cambiarPassword(Integer id_usuario, String password){
        Usuario usuario = usuarioRepositorio.findOne(id_usuario);
        usuario.setPassword(password);
        usuarioRepositorio.save(usuario);
    }
    @Override
    public void cambiarEmail(Integer id_usuario, String email){
        Usuario usuario = usuarioRepositorio.findOne(id_usuario);
        usuario.setEmail(email);
        usuarioRepositorio.save(usuario);
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
