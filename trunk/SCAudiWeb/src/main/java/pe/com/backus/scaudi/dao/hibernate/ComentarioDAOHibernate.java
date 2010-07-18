/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao.hibernate;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.ComentarioDAO;
import pe.com.backus.scaudi.domain.Comentario;

/**
 *
 * @author Administrador
 */
public class ComentarioDAOHibernate implements ComentarioDAO{

    private SessionFactory sessionFactory = HibernateSession.getSessionFactory();;


    public void guardar(Comentario comentario) {
        sessionFactory.getCurrentSession().saveOrUpdate(comentario);
    }

    public void eliminar(Comentario comentario) {
        sessionFactory.getCurrentSession().delete(comentario);
    }

    public Comentario obtenerComentario(Integer codigo) {
       Comentario comentario =
                (Comentario) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from Comentario a  where a.idComentario=?")
                .setParameter(0, codigo).uniqueResult();
        return comentario;
    }

    public List<Comentario> listarComentarios() {
         List<Comentario> comentarios= sessionFactory.getCurrentSession()
                .createQuery("from Comentario order by idComentario").list();
        return comentarios;

    }


}
