package com.example.dominio;

/**
 * Created by rodrigo on 30/06/16.
 */
import javax.persistence.*;
import java.util.Date;

@Entity
public class Puntuacion {//cancion
    @Id
    @SequenceGenerator(name="Comentario_ID_GENERATOR", sequenceName="Comentario_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Comentario_ID_GENERATOR")
    private Integer id_puntuacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_cancion")
    private Cancion cancion;
    private Date fecha;
    private Integer puntuacion;//0-10

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setCancion(Cancion cancion){
        this.cancion = cancion;
    }

    public Cancion getCancion(){
        return cancion;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public Date getFecha(){
        return fecha;
    }

    public void setPuntuacion(Integer puntuacion){
        this.puntuacion = puntuacion;
    }

    public Integer getPuntuacion(){
        return puntuacion;
    }

    public Puntuacion (){}

    public Puntuacion(Usuario usuario, Cancion cancion, Integer puntuacion, Date fecha){
        this.usuario = usuario;
        this.cancion = cancion;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }

    public Integer getId_puntuacion() {
        return id_puntuacion;
    }
}
