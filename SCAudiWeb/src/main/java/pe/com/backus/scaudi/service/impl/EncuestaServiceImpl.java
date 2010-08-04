/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.EncuestaDAO;
import pe.com.backus.scaudi.domain.Evaluacion;
import pe.com.backus.scaudi.service.EncuestaService;

/**
 *
 * @author Administrador
 */
public class EncuestaServiceImpl implements EncuestaService{

    private EncuestaDAO encuestaDAO;

    public void setEncuestaDAO(EncuestaDAO encuestaDAO) {
        this.encuestaDAO = encuestaDAO;
    }


    public void guardar(Evaluacion encuesta) {
       encuestaDAO.guardar(encuesta);
    }

    public void eliminar(Evaluacion encuesta) {
        encuestaDAO.eliminar(encuesta);
    }

    public Evaluacion obtenerEncuesta(Integer codigo) {
        return encuestaDAO.obtenerEncuesta(codigo);
    }

    public List<Evaluacion> listarEncuestas() {
        return encuestaDAO.listarEncuestas();

    }


}
