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

/**
 *
 * @author Administrador
 */
public class DetalleEvaluacionServiceImpl implements DetalleEvaluacionService{

    private DetalleEvaluacionDAO DetalleEvaluacionDAO = new DetalleEvaluacionDAOHibernate();

    
    public void guardar(DetalleEvaluacion detalleEvaluacion) {
       DetalleEvaluacionDAO.guardar(detalleEvaluacion);
    }

    public void eliminar(DetalleEvaluacion detalleEvaluacion) {
        DetalleEvaluacionDAO.eliminar(detalleEvaluacion);
    }

    public DetalleEvaluacion obtenerDetalleEvaluacion(Integer codigo) {
        return DetalleEvaluacionDAO.obtenerDetalleEvaluacion(codigo);
    }

    public List<DetalleEvaluacion> listarDetalleEvaluaciones() {
        return DetalleEvaluacionDAO.listarDetalleEvaluaciones();

    }


}
