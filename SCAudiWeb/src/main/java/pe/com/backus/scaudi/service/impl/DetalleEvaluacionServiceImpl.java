/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.DetalleEvaluacionDAO;
import pe.com.backus.scaudi.dao.hibernate.DetalleEvaluacionDAOHibernate;
import pe.com.backus.scaudi.domain.DetalleEvaluacion;
import pe.com.backus.scaudi.service.DetalleEvaluacionService;
import pe.com.backus.scaudi.service.EvaluacionService;

/**
 *
 * @author Administrador
 */
public class DetalleEvaluacionServiceImpl implements DetalleEvaluacionService{

    private DetalleEvaluacionDAO detalleEvaluacionDAO = new DetalleEvaluacionDAOHibernate();

    
    public void guardar(DetalleEvaluacion detalleEvaluacion) {
       EvaluacionService evaluacionService = new EvaluacionServiceImpl();
       evaluacionService.guardar(detalleEvaluacion.getEvaluacion());
       detalleEvaluacionDAO.guardar(detalleEvaluacion);
    }

    public void eliminar(DetalleEvaluacion detalleEvaluacion) {
        detalleEvaluacionDAO.eliminar(detalleEvaluacion);
    }

    public DetalleEvaluacion obtenerDetalleEvaluacion(Integer codigo) {
        return detalleEvaluacionDAO.obtenerDetalleEvaluacion(codigo);
    }

    public List<DetalleEvaluacion> listarDetalleEvaluaciones() {
        return detalleEvaluacionDAO.listarDetalleEvaluaciones();

    }


}
