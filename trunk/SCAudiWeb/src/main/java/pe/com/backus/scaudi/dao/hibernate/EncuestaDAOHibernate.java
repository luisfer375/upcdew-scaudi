/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao.hibernate;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.EncuestaDAO;
import pe.com.backus.scaudi.domain.Evaluacion;

/**
 *
 * @author Administrador
 */
public class EncuestaDAOHibernate implements EncuestaDAO{

    private SessionFactory sessionFactory = HibernateSession.getSessionFactory();;


    public void guardar(Evaluacion encuesta) {
        sessionFactory.getCurrentSession().saveOrUpdate(encuesta);
    }

    public void eliminar(Evaluacion encuesta) {
        sessionFactory.getCurrentSession().delete(encuesta);
    }

    public Evaluacion obtenerEncuesta(Integer codigo) {
       Evaluacion encuesta =
                (Evaluacion) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from Encuesta a  where a.idEncuesta=?")
                .setParameter(0, codigo).uniqueResult();
        return encuesta;
    }

    public List<Evaluacion> listarEncuestas() {
         List<Evaluacion> encuestas= sessionFactory.getCurrentSession()
                .createQuery("from Encuesta order by idEncuesta").list();
        return encuestas;

    }


}
