/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao;

import java.util.List;
import pe.com.backus.scaudi.domain.Modulo;

/**
 *
 * @author Administrador
 */
public interface ModuloDAO {


    public void guardar(Modulo modulo);

    public void eliminar(Modulo modulo);

    public Modulo obtenerModulo(Integer codigo);

    public List<Modulo> listarModulos();

}
