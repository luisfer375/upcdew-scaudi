/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.domain;

/**
 *
 * @author u201000244
 */
public class Area {

    private Integer idArea;
    private Modulo modulo;
    private String descripcion;
    private Integer peso;

    public Area() {
    }




    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo idModulo) {
        this.modulo= idModulo;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
        



}
