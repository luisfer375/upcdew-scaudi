/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service;

import java.util.List;
import pe.com.backus.scaudi.domain.Modulo;

/**
 *
 * @author Administrador
 */
public interface ModuloService {


    public void guardar(Modulo modulo);

    public void eliminar(Modulo modulo);

    public Modulo obtenerModulo(Integer codigo);

    public List<Modulo> listarModulos();

}
