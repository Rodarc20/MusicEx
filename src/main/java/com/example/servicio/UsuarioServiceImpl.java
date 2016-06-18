package com.example.servicio;

/**
 * Created by rodrigo on 18/06/16.
 */
import java.util.Date;

import com.example.dominio.Usuario;
import com.example.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    UsuarioRepositorio usuarioRepositorio;

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
}
