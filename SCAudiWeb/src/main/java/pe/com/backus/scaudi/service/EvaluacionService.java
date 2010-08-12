/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service;

import java.util.List;
import pe.com.backus.scaudi.domain.Evaluacion;
import pe.com.backus.scaudi.domain.Usuario;

/**
 *
 * @author Administrador
 */
public interface EvaluacionService {


    public void guardar(Evaluacion Evaluacion);

    public void eliminar(Evaluacion Evaluacion);

    public Integer obtenerCorrelativoEvaluacionUsuario(Usuario usuario);

    public Evaluacion obtenerEvaluacion(Integer codigo);

    public List<Evaluacion> listarEvaluaciones();

}
