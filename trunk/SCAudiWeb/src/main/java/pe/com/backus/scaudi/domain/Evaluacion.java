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
public class Evaluacion {

    private Integer idEncuesta;
    private Modulo  modulo;
    private CentroDistribucion  centro;
    private Usuario  usuario;
    private Date fecha;
    private Integer estado;

    public Evaluacion() {
    }



    public CentroDistribucion getCentro() {
        return centro;
    }

    public void setCentro(CentroDistribucion centro) {
        this.centro = centro;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
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
