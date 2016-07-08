package com.example.dominio;

/**
 * Created by rodrigo on 17/06/16.
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
public class Artista {
    @Id
    @SequenceGenerator(name="Artista_ID_GENERATOR", sequenceName="Artista_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Artista_ID_GENERATOR")
    private Integer idArtista;
    private String nombre;
    private String descripcion;
    private String pathFoto;
    private Integer seguidores;
    private Integer puntuacion;

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setPathFoto(String pathFoto){
        this.pathFoto = pathFoto;
    }

    public String getPathFoto(){
        return this.pathFoto;
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

    public Artista(){}

    public Artista(String nombre, String descripcion, String pathFoto){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pathFoto = pathFoto;
        this.seguidores = 0;
        this.puntuacion = 0;
    }
}
