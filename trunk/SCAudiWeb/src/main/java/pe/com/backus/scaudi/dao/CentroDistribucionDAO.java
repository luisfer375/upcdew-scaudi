/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao;

import java.util.List;
import pe.com.backus.scaudi.domain.CentroDistribucion;

/**
 *
 * @author Administrador
 */
public interface CentroDistribucionDAO {


    public void guardar(CentroDistribucion centroDistribucion);

    public void eliminar(CentroDistribucion centroDistribucion);

    public CentroDistribucion obtenerCentroDistribucion(Integer codigo);

    public List<CentroDistribucion> listarCentroDistribuciones();

}
