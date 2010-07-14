/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.domain;

/**
 *
 * @author u201000244
 */
public class EncuestaDetalle {

    private Estandar estandar;
    private Encuesta  encuesta;
    private long   calificacion;
    private String    observacion;
    private String    recomendacion;

    public EncuestaDetalle() {
    }

    

    public long getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(long calificacion) {
        this.calificacion = calificacion;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Estandar getEstandar() {
        return estandar;
    }

    public void setEstandar(Estandar estandar) {
        this.estandar = estandar;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }




}
