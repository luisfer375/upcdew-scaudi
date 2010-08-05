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

    private Integer periodo;
    private CentroDistribucion  centro;
    private Usuario  usuario;
    private int posiblePuntaje;

    public Evaluacion() {
    }

    public CentroDistribucion getCentro() {
        return centro;
    }

    public void setCentro(CentroDistribucion centro) {
        this.centro = centro;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public int getPosiblePuntaje() {
        return posiblePuntaje;
    }

    public void setPosiblePuntaje(int posiblePuntaje) {
        this.posiblePuntaje = posiblePuntaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
