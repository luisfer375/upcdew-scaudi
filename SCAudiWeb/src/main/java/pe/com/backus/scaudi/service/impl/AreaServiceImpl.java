/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.AreaDAO;
import pe.com.backus.scaudi.domain.Area;

/**
 *
 * @author Administrador
 */
public class AreaServiceImpl implements AreaDAO{

    private AreaDAO areaDAO;

    public void setAreaDAO(AreaDAO areaDAO) {
        this.areaDAO = areaDAO;
    }



    public void guardar(Area area) {
       areaDAO.guardar(area);
    }

    public void eliminar(Area area) {
        areaDAO.eliminar(area);
    }

    public Area obtenerArea(Integer codigo) {
     return  areaDAO.obtenerArea(codigo);
    }

    public List<Area> listarAreas() {
      return  areaDAO.listarAreas();

    }


}
