package com.example.dominio;

/**
 * Created by rodrigo on 18/06/16.
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Entity
public class Usuario {
    @Id
    @SequenceGenerator(name="Usuario_ID_GENERATOR", sequenceName="Usuario_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Usuario_ID_GENERATOR")
    private Integer idUsuario;
    private String username;
    private String password;
    private String email;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String pathFotoPerfil;
    private Date fechaCreacion;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setPathFotoPerfil(String pathFotoPerfil) {
        this.pathFotoPerfil = pathFotoPerfil;
    }

    public String getPathFotoPerfil() {
        return pathFotoPerfil;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario(){}

    public Usuario(String username, String password, String email, String nombre, String apellido, Date fechaNacimineto, String pathFotoPerfil){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimineto;
        this.pathFotoPerfil = pathFotoPerfil;
        this.fechaCreacion = new Date();
    }
}
