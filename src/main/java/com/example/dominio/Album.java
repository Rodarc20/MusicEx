package com.example.dominio;

/**
 * Created by rodrigo on 17/06/16.
 */
import javax.persistence.*;
import java.util.Date;

@Entity
public class Album {
    @Id
    @SequenceGenerator(name="Album_ID_GENERATOR", sequenceName="Album_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Album_ID_GENERATOR")
    private Integer id_album;
    private String titulo;
    //private Integer id_artista;
    @ManyToOne
    @JoinColumn(name="id_artista")
    private Artista artista;
    private String path_foto;
    private Date fecha;
    private Integer seguidores;
    private Integer puntuacion;
    //private genero; // este se debe con una tabla intermedia;

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    /*public void setId_artista(Integer id_artista){
        this.id_artista = id_artista;
    }

    public Integer getId_artista(){

        return this.id_artista;
    }
    */

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setPath_foto(String path_foto){
        this.path_foto = path_foto;
    }

    public String getPath_foto(){
        return this.path_foto;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public void setSeguidores(Integer seguidores){
        this.seguidores = seguidores;
    }

    public Integer getSeguidores(){
        return this.seguidores;
    }

    public void setPuntuacion(Integer puntuacion){
        this.puntuacion = puntuacion;
    }

    public Integer getPuntuacion(){
        return this.puntuacion;
    }

    public Album (){}

    /*public Album (String titulo, Integer id_artista, String path_foto, Date fecha){
        this.titulo = titulo;
        this.id_artista = id_artista;
        this.path_foto = path_foto;
        this.fecha = fecha;
        this.seguidores = 0;
        this.puntuacion = 0;
    }*/
    public Album (String titulo, Artista artista, String path_foto, Date fecha){
        this.titulo = titulo;
        this.artista = artista;
        this.path_foto = path_foto;
        this.fecha = fecha;
        this.seguidores = 0;
        this.puntuacion = 0;
    }
}
