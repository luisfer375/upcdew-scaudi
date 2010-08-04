/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service;

import java.util.List;
import pe.com.backus.scaudi.domain.Evaluacion;

/**
 *
 * @author Administrador
 */
public interface EncuestaService {


    public void guardar(Evaluacion encuesta);

    public void eliminar(Evaluacion encuesta);

    public Evaluacion obtenerEncuesta(Integer codigo);

    public List<Evaluacion> listarEncuestas();

}
