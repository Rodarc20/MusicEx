package com.example.dominio;

/**
 * Created by rodrigo on 18/06/16.
 */
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Playlist {
    @Id
    @SequenceGenerator(name="Playlist_ID_GENERATOR", sequenceName="Playlist_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Playlist_ID_GENERATOR")
    private Integer id_playlist;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private String titulo;
    private Date fecha;

    @ManyToMany
    @JoinTable(name = "playlist_cancion", joinColumns = @JoinColumn(name = "id_cancion"), inverseJoinColumns = @JoinColumn(name = "id_playlist"))
    private Set<Cancion> canciones;

    private Integer seguidores;
    private Integer puntuacion;

    public Integer getId_playlist() {
        return id_playlist;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setCanciones(Set<Cancion> canciones) {
        this.canciones = canciones;
    }

    public Set<Cancion> getCanciones() {
        return canciones;
    }

    public void setSeguidores(Integer seguidores) {
        this.seguidores = seguidores;
    }

    public Integer getSeguidores() {
        return seguidores;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }
}
