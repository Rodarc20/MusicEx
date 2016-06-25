package com.example.dominio;

/**
 * Created by rodrigo on 25/06/16.
 */
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Comentario {
    @Id
    @SequenceGenerator(name="Comentario_ID_GENERATOR", sequenceName="Comentario_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Comentario_ID_GENERATOR")
    private Integer id_comentario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;

    private String comentario;
    private Date fecha;

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setAlbum(Album album){
        this.album = album;
    }

    public Album getAlbum(){
        return album;
    }

    public void setComentario(String comentario){
        this.comentario = comentario;
    }

    public String getComentario(){
        return comentario;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public Date getFecha(){
        return fecha;
    }

    public Comentario(){}

    public Comentario(Usuario usuario, Album album, String comentario, Date fecha){
        this.usuario = usuario;
        this.album = album;
        this.comentario = comentario;
        this.fecha = fecha;
    }
}
