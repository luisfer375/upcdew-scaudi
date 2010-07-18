/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.EncuestaDAO;
import pe.com.backus.scaudi.domain.Encuesta;

/**
 *
 * @author Administrador
 */
public class EncuestaServiceImpl implements EncuestaDAO{

    private EncuestaDAO encuestaDAO;

    public void setEncuestaDAO(EncuestaDAO encuestaDAO) {
        this.encuestaDAO = encuestaDAO;
    }


    public void guardar(Encuesta encuesta) {
       encuestaDAO.guardar(encuesta);
    }

    public void eliminar(Encuesta encuesta) {
        encuestaDAO.eliminar(encuesta);
    }

    public Encuesta obtenerEncuesta(Integer codigo) {
        return encuestaDAO.obtenerEncuesta(codigo);
    }

    public List<Encuesta> listarEncuestas() {
        return encuestaDAO.listarEncuestas();

    }


}
