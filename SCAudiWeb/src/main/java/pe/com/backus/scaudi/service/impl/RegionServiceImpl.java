/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.RegionDAO;
import pe.com.backus.scaudi.domain.Region;

/**
 *
 * @author Administrador
 */
public class RegionServiceImpl implements RegionDAO{

    private RegionDAO regionDAO;

    public void setRegionDAO(RegionDAO regionDAO) {
        this.regionDAO = regionDAO;
    }




    public void guardar(Region region) {
        regionDAO.guardar(region);
    }

    public void eliminar(Region region) {
        regionDAO.eliminar(region);
    }

    public Region obtenerRegion(Integer codigo) {
        return regionDAO.obtenerRegion(codigo);
    }

    public List<Region> listarRegiones() {
        return regionDAO.listarRegiones();
    }


}
