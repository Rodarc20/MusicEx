package com.example.dominio;

/**
 * Created by rodrigo on 17/06/16.
 */

import javax.persistence.*;

@Entity
public class Cancion {
    @Id
    @SequenceGenerator(name="Cancion_ID_GENERATOR", sequenceName="Cancion_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Cancion_ID_GENERATOR")
    private Integer id_cancion;
    private String titulo;
    private String path;
    private Integer numero;
    //private Integer id_album;
    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;
    //private Integer id_artista;//quiza no sea necesario
    private Integer duracion;
    private Integer numero_seguidores;
    private Integer puntuacion;
    private Integer reproducciones;

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public Integer getId_cancion(){
        return this.id_cancion;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public void setNumero(Integer numero){
        this.numero = numero;
    }

    public Integer getNumero(){
        return this.numero;
    }

    /*public void setId_album(Integer id_album){
        this.id_album = id_album;
    }

    public Integer getId_album(){
        return this.id_album;
    }*/

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }

    public void setDuracion(Integer duracion){
        this.duracion = duracion;
    }

    public Integer getDuracion(){
        return this.duracion;
    }

    public void setNumero_seguidores(Integer numero_seguidores){
        this.numero_seguidores = numero_seguidores;
    }

    public Integer getNumero_seguidores(){
        return this.numero_seguidores;
    }

    public void setPuntuacion(Integer puntuacion){
        this.puntuacion = puntuacion;
    }

    public Integer getPuntuacion(){
        return this.puntuacion;
    }

    public void setReproducciones(Integer reproducciones){
        this.reproducciones= reproducciones;
    }

    public Integer getReproducciones(){
        return this.reproducciones;
    }
    public Cancion(){}

    public Cancion(String titulo, String path, Integer numero, Album album, Integer duracion){
        this.titulo = titulo;
        this.path = path;
        this.numero = numero;
        this.album = album;
        this.duracion = duracion;
        this.numero_seguidores = 0;
        this.puntuacion = 0;
        this.reproducciones = 0;
    }
}
