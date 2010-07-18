/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao;

import java.util.List;
import pe.com.backus.scaudi.domain.Usuario;

/**
 *
 * @author Administrador
 */
public interface UsuarioDAO {


    public void guardar(Usuario usuario);

    public void eliminar(Usuario usuario);

    public Usuario obtenerUsuario(Integer codigo);

    public List<Usuario> listarUsuarios();

}
