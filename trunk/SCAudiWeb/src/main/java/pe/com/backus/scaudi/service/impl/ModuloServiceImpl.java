/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.ModuloDAO;
import pe.com.backus.scaudi.domain.Modulo;
import pe.com.backus.scaudi.service.ModuloService;

/**
 *
 * @author Administrador
 */
public class ModuloServiceImpl implements ModuloService{

    private ModuloDAO moduloDAO;

    public void setModuloDAO(ModuloDAO moduloDAO) {
        this.moduloDAO = moduloDAO;
    }




    public void guardar(Modulo modulo) {
        moduloDAO.guardar(modulo);
    }

    public void eliminar(Modulo modulo) {
        moduloDAO.eliminar(modulo);
    }

    public Modulo obtenerModulo(Integer codigo) {
        return moduloDAO.obtenerModulo(codigo);
    }

    public List<Modulo> listarModulos() {
        return moduloDAO.listarModulos();

    }


}
