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
      Usuario usuario =
                (Usuario) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from Usuario u  where u.login=? and u.password=?")
                .setParameter(0, login).setParameter(1, password).uniqueResult();
        return usuario;
    }


}
