/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.EvaluacionDAO;
import pe.com.backus.scaudi.domain.Evaluacion;
import pe.com.backus.scaudi.util.Log;

/**
 *
 * @author Administrador
 */
public class EvaluacionDAOHibernate implements EvaluacionDAO{

    private SessionFactory sessionFactory = HibernateSession.getSessionFactory();;


    public void guardar(Evaluacion Evaluacion) {
       Log.debug("Guarda Evaluacion");
       Session session = sessionFactory.getCurrentSession();
       session.beginTransaction();
       sessionFactory.getCurrentSession().saveOrUpdate(Evaluacion);
       session.getTransaction().commit();
       Log.debug("Registro con exito");
    }

    public void eliminar(Evaluacion Evaluacion) {
        sessionFactory.getCurrentSession().delete(Evaluacion);
    }

    public Evaluacion obtenerEvaluacion(Integer codigo) {
       Log.debug("Obtiene los Evaluacion");
       Session session = sessionFactory.getCurrentSession();
       session.beginTransaction();
       Evaluacion Evaluacion =
                (Evaluacion) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from Evaluacion a  where a.periodo=?")
                .setParameter(0, codigo).uniqueResult();
        session.getTransaction().commit();
        return Evaluacion;
    }

    public List<Evaluacion> listarEvaluaciones() {
         List<Evaluacion> Evaluaciones= sessionFactory.getCurrentSession()
                .createQuery("from Evaluacion order by idEvaluacion").list();
        return Evaluaciones;

    }


}
