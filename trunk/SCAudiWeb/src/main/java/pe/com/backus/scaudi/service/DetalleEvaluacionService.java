/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service;

import java.util.List;
import pe.com.backus.scaudi.domain.DetalleEvaluacion;

/**
 *
 * @author Administrador
 */
public interface DetalleEvaluacionService {


    public void guardar(DetalleEvaluacion detalleEvaluacion);

    public void eliminar(DetalleEvaluacion detalleEvaluacion);

    public DetalleEvaluacion obtenerDetalleEvaluacion(Integer codigo);

    public List<DetalleEvaluacion> listarDetalleEvaluaciones();

}
