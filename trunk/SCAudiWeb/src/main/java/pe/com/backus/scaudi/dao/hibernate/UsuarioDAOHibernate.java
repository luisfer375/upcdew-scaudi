/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao.hibernate;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.UsuarioDAO;
import pe.com.backus.scaudi.domain.Usuario;
import pe.com.backus.scaudi.util.Log;

/**
 *
 * @author Administrador
 */
public class UsuarioDAOHibernate implements UsuarioDAO{

    private SessionFactory sessionFactory = HibernateSession.getSessionFactory();;


    public void guardar(Usuario usuario) {
        sessionFactory.getCurrentSession().saveOrUpdate(usuario);
    }

    public void eliminar(Usuario usuario) {
        sessionFactory.getCurrentSession().delete(usuario);
    }

    public Usuario obtenerUsuario(Integer codigo) {
       Usuario usuario =

                (Usuario) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from Usuario a  where a.idUsuario=?")
                .setParameter(0, codigo).uniqueResult();
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
         List<Usuario> usuarios= sessionFactory.getCurrentSession()
                .createQuery("from Usuario order by idUsuario").list();
        return usuarios;

    }

    public Usuario validarUsuario(String login, String password) {
      Log.debug("Entro a validar Usuario");
      Usuario usuario =
                (Usuario) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from t_usuario u  where u.vc_login=? and u.vc_password=?")
                .setParameter(0, login).setParameter(1, password).uniqueResult();
        return usuario;
    }


}
