package com.example.dominio;

/**
 * Created by rodrigo on 30/06/16.
 */
import javax.persistence.*;
import java.util.Date;

@Entity
public class Seguimiento {//usuario1 sigue a usuario2, no visceversa
    @Id
    @SequenceGenerator(name="Comentario_ID_GENERATOR", sequenceName="Comentario_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Comentario_ID_GENERATOR")
    private Integer id_seguimiento;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario1;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario2;

    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public Seguimiento(){}

    public Seguimiento (Usuario usuario1, Usuario usuario2, Date fecha){
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.fecha = fecha;
    }
}
