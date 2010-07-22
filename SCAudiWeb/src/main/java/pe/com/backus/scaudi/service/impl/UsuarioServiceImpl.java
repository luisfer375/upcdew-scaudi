/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.UsuarioDAO;
import pe.com.backus.scaudi.dao.hibernate.UsuarioDAOHibernate;
import pe.com.backus.scaudi.domain.Usuario;
import pe.com.backus.scaudi.service.UsuarioService;
import pe.com.backus.scaudi.util.Log;

/**
 *
 * @author Administrador
 */
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioDAO usuarioDAO = new UsuarioDAOHibernate();

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

    public Usuario validarUsuario(String login, String password) {
        Log.debug("Entro service");
        return usuarioDAO.validarUsuario(login, password);
    }


}
