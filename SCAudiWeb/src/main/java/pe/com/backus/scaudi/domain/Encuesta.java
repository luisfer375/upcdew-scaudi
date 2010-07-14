/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.domain;

import java.util.Date;

/**
 *
 * @author u201000244
 */
public class Encuesta {

    private long idEncuesta;
    private Modulo  modulo;
    private CentroDistribucion  centro;
    private Usuario  usuario;
    private Date fecha;
    private long estado;

    public Encuesta() {
    }



    public CentroDistribucion getCentro() {
        return centro;
    }

    public void setCentro(CentroDistribucion centro) {
        this.centro = centro;
    }

    public long getEstado() {
        return estado;
    }

    public void setEstado(long estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
