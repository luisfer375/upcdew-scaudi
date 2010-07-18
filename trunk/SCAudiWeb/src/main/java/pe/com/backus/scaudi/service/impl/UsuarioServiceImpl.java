/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.UsuarioDAO;
import pe.com.backus.scaudi.domain.Usuario;

/**
 *
 * @author Administrador
 */
public class UsuarioServiceImpl implements UsuarioDAO{

    private UsuarioDAO usuarioDAO;

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void guardar(Usuario usuario) {
        usuarioDAO.guardar(usuario);
    }

    public void eliminar(Usuario usuario) {
        usuarioDAO.eliminar(usuario);
    }

    public Usuario obtenerUsuario(Integer codigo) {
        return usuarioDAO.obtenerUsuario(codigo);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarUsuarios();

    }


}
