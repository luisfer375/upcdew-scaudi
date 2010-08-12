/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao;

import java.util.List;
import pe.com.backus.scaudi.domain.Evaluacion;

/**
 *
 * @author Administrador
 */
public interface EvaluacionDAO {


    public void guardar(Evaluacion Evaluacion);

    public void eliminar(Evaluacion Evaluacion);

    public Evaluacion obtenerEvaluacion(Integer codigo);

    public List<Evaluacion> listarEvaluaciones();

}
