/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.EstandarDAO;
import pe.com.backus.scaudi.domain.Estandar;
import pe.com.backus.scaudi.service.EstandarService;

/**
 *
 * @author Administrador
 */
public class EstandarServiceImpl implements EstandarService{

    private EstandarDAO estandarDAO;

    public void setEstandarDAO(EstandarDAO estandarDAO) {
        this.estandarDAO = estandarDAO;
    }




    public void guardar(Estandar estandar) {
       estandarDAO.guardar(estandar);
    }

    public void eliminar(Estandar estandar) {
        estandarDAO.eliminar(estandar);
    }

    public Estandar obtenerEstandar(Integer codigo) {
        return estandarDAO.obtenerEstandar(codigo);
    }

    public List<Estandar> listarEstandares() {
        return estandarDAO.listarEstandares();

    }


}
