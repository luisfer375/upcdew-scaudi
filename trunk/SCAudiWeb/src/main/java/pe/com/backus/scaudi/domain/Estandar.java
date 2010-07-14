/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.domain;

/**
 *
 * @author u201000244
 */
public class Estandar {

    private long idEstandar;
    private Area    area;
    private String  desripcion;
    private long  peso;

    public Estandar() {
    }

    

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getDesripcion() {
        return desripcion;
    }

    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
    }

    public long getIdEstandar() {
        return idEstandar;
    }

    public void setIdEstandar(long idEstandar) {
        this.idEstandar = idEstandar;
    }

    public long getPeso() {
        return peso;
    }

    public void setPeso(long peso) {
        this.peso = peso;
    }




}
