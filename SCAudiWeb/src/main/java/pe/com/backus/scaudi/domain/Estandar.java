/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.domain;

import java.io.Serializable;

/**
 *
 * @author u201000244
 */
public class Estandar implements Serializable{


    private Integer idModulo;
    private String nombreModulo;
    private Integer idMeta;
    private String nombreMeta;
    private Integer idEstandar;
    private String nombreEstandar;
    private String comentario;
    private String esPobre;
    private String esDebajoEstandar;
    private String esEstandar;
    private String esExcepcional;
    private int peso;



    public Estandar() {
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEsDebajoEstandar() {
        return esDebajoEstandar;
    }

    public void setEsDebajoEstandar(String esDebajoEstandar) {
        this.esDebajoEstandar = esDebajoEstandar;
    }

    public String getEsEstandar() {
        return esEstandar;
    }

    public void setEsEstandar(String esEstandar) {
        this.esEstandar = esEstandar;
    }

    public String getEsExcepcional() {
        return esExcepcional;
    }

    public void setEsExcepcional(String esExcepcional) {
        this.esExcepcional = esExcepcional;
    }

    public String getEsPobre() {
        return esPobre;
    }

    public void setEsPobre(String esPobre) {
        this.esPobre = esPobre;
    }

    public Integer getIdEstandar() {
        return idEstandar;
    }

    public void setIdEstandar(Integer idEstandar) {
        this.idEstandar = idEstandar;
    }

    public Integer getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Integer idMeta) {
        this.idMeta = idMeta;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombreEstandar() {
        return nombreEstandar;
    }

    public void setNombreEstandar(String nombreEstandar) {
        this.nombreEstandar = nombreEstandar;
    }

    public String getNombreMeta() {
        return nombreMeta;
    }

    public void setNombreMeta(String nombreMeta) {
        this.nombreMeta = nombreMeta;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }


    



}
