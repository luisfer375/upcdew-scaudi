/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service;

import java.util.List;
import pe.com.backus.scaudi.domain.Estandar;

/**
 *
 * @author Administrador
 */
public interface EstandarService {


    public void guardar(Estandar estandar);

    public void eliminar(Estandar estandar);

    public Estandar obtenerEstandar(Integer codigo);

    public List<Estandar> listarEstandares();

}
