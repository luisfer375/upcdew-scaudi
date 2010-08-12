/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.EvaluacionDAO;
import pe.com.backus.scaudi.dao.hibernate.EvaluacionDAOHibernate;
import pe.com.backus.scaudi.domain.Evaluacion;
import pe.com.backus.scaudi.domain.Usuario;
import pe.com.backus.scaudi.service.EvaluacionService;

/**
 *
 * @author Administrador
 */
public class EvaluacionServiceImpl implements EvaluacionService{

    private EvaluacionDAO evaluacionDAO = new EvaluacionDAOHibernate();

    
    public void guardar(Evaluacion evaluacion) {
         evaluacionDAO.guardar(evaluacion);
    }

    public void eliminar(Evaluacion Evaluacion) {
        evaluacionDAO.eliminar(Evaluacion);
    }

    public Evaluacion obtenerEvaluacion(Integer codigo) {
        return evaluacionDAO.obtenerEvaluacion(codigo);
    }

    public List<Evaluacion> listarEvaluaciones() {
        return evaluacionDAO.listarEvaluaciones();

    }

    public Integer obtenerCorrelativoEvaluacionUsuario(Usuario usuario) {
         return evaluacionDAO.obtenerCorrelativoEvaluacionUsuario(usuario);
    }


}
