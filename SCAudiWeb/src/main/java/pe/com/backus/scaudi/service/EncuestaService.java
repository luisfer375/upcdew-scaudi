/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service;

import java.util.List;
import pe.com.backus.scaudi.domain.Encuesta;

/**
 *
 * @author Administrador
 */
public interface EncuestaService {


    public void guardar(Encuesta encuesta);

    public void eliminar(Encuesta encuesta);

    public Encuesta obtenerEncuesta(Integer codigo);

    public List<Encuesta> listarEncuestas();

}
