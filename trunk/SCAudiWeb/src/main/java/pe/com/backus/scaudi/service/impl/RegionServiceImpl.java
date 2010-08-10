/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.RegionDAO;
import pe.com.backus.scaudi.dao.hibernate.RegionDAOHibernate;
import pe.com.backus.scaudi.domain.Region;
import pe.com.backus.scaudi.service.RegionService;

/**
 *
 * @author Administrador
 */
public class RegionServiceImpl implements RegionService{

    private RegionDAO regionDAO = new RegionDAOHibernate();

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
