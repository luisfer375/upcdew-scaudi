/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.domain;

/**
 *
 * @author u201000244
 */
public class DetalleEvaluacion {

    private Estandar estandar;
    private Evaluacion  evaluacion;
    private CentroDistribucion centroDistribucion;
    private int   puntaje;
    private String    observaciones;
    private String    oportuniadades;

    public DetalleEvaluacion() {
    }

    public CentroDistribucion getCentroDistribucion() {
        return centroDistribucion;
    }

    public void setCentroDistribucion(CentroDistribucion centroDistribucion) {
        this.centroDistribucion = centroDistribucion;
    }

    public Estandar getEstandar() {
        return estandar;
    }

    public void setEstandar(Estandar estandar) {
        this.estandar = estandar;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOportuniadades() {
        return oportuniadades;
    }

    public void setOportuniadades(String oportuniadades) {
        this.oportuniadades = oportuniadades;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    







}
