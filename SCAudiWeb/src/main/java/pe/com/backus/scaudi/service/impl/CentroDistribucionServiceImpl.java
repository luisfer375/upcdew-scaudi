/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.CentroDistribucionDAO;
import pe.com.backus.scaudi.dao.hibernate.CentroDistribucionDAOHibernate;
import pe.com.backus.scaudi.domain.CentroDistribucion;
import pe.com.backus.scaudi.service.CentroDistribucionService;

/**
 *
 * @author Administrador
 */
public class CentroDistribucionServiceImpl implements CentroDistribucionService{

    private CentroDistribucionDAO centroDistribucionDAO = new CentroDistribucionDAOHibernate();



    public void guardar(CentroDistribucion centroDistribucion) {
       centroDistribucionDAO.guardar(centroDistribucion);
    }

    public void eliminar(CentroDistribucion centroDistribucion) {
       centroDistribucionDAO.eliminar(centroDistribucion);
    }

    public CentroDistribucion obtenerCentroDistribucion(Integer codigo) {
        return centroDistribucionDAO.obtenerCentroDistribucion(codigo);
    }

    public List<CentroDistribucion> listarCentroDistribuciones(Integer idRegion) {
        return centroDistribucionDAO.listarCentroDistribuciones(idRegion);

    }


}
