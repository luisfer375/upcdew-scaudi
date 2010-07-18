/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao;

import java.util.List;
import pe.com.backus.scaudi.domain.Region;

/**
 *
 * @author Administrador
 */
public interface RegionDAO {


    public void guardar(Region region);

    public void eliminar(Region region);

    public Region obtenerRegion(Integer codigo);

    public List<Region> listarRegiones();

}
