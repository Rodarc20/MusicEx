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
    private Integer id_usuario;
    private String username;
    private String password;
    private String email;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String path_foto_perfil;
    private Date fecha_creacion;

    public Integer getId_usuario() {
        return id_usuario;
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

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setPath_foto_perfil(String path_foto_perfil) {
        this.path_foto_perfil = path_foto_perfil;
    }

    public String getPath_foto_perfil() {
        return path_foto_perfil;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public Usuario(){}

    public Usuario(String username, String password, String email, String nombre, String apellido, Date fecha_nacimineto, String path_foto_perfil){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimineto;
        this.path_foto_perfil = path_foto_perfil;
        this.fecha_creacion = new Date();
    }
}
