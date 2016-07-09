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
    private Integer idPlaylist;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    private String titulo;
    private Date fecha;

    @ManyToMany
    @JoinTable(name = "playlist_cancion", joinColumns = @JoinColumn(name = "idCancion"), inverseJoinColumns = @JoinColumn(name = "idPlaylist"))
    private Set<Cancion> canciones;

    private Integer seguidores;
    private Integer puntuacion;

    public Integer getIdPlaylist() {
        return idPlaylist;
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

    public void addCancion(Cancion cancion){//no se si debo hacerlos a travez de esto, o a travez  get canciones y a l resulado hacer esta operacion, revisar si funciona despues
        this.canciones.add(cancion);
    }

    public void deleteCancion(Cancion cancion){
        this.canciones.remove(cancion);
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

    public Playlist (){}

    public Playlist (Usuario usuario, String titulo){
        this.usuario = usuario;
        this.titulo = titulo;
    }
}
