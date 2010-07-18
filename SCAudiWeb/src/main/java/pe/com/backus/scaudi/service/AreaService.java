/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service;

import java.util.List;
import pe.com.backus.scaudi.domain.Area;

/**
 *
 * @author Administrador
 */
public interface AreaService {

    public void guardar(Area area);

    public void eliminar(Area area);

    public Area obtenerArea(Integer codigo);

    public List<Area> listarAreas();


}
