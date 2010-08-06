/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.domain;

/**
 *
 * @author u201000244
 */
public class CentroDistribucion {

    private Integer idCentroDistribucion;
    private Region  region;
    private String  descripcion;

    public CentroDistribucion() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdCentroDistribucion() {
        return idCentroDistribucion;
    }

    public void setIdCentroDistribucion(Integer idCentroDistribucion) {
        this.idCentroDistribucion = idCentroDistribucion;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    

 


}
