/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.DetalleEvaluacionDAO;
import pe.com.backus.scaudi.domain.DetalleEvaluacion;
import pe.com.backus.scaudi.util.Log;

/**
 *
 * @author Administrador
 */
public class DetalleEvaluacionDAOHibernate implements DetalleEvaluacionDAO{

    private SessionFactory sessionFactory = HibernateSession.getSessionFactory();;


    public void guardar(DetalleEvaluacion detalleEvaluacion) {
       Log.debug("Guarda DetalleEvaluacion");
       Session session = sessionFactory.getCurrentSession();
       session.beginTransaction();
       sessionFactory.getCurrentSession().saveOrUpdate(detalleEvaluacion);
       session.getTransaction().commit();
    }

    public void eliminar(DetalleEvaluacion detalleEvaluacion) {
        sessionFactory.getCurrentSession().delete(detalleEvaluacion);
    }

    public DetalleEvaluacion obtenerDetalleEvaluacion(Integer codigo) {
       Log.debug("Obtiene los DetalleEvaluacion");
       Session session = sessionFactory.getCurrentSession();
       session.beginTransaction();
       DetalleEvaluacion DetalleEvaluacion =
                (DetalleEvaluacion) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from DetalleEvaluacion a  where a.idDetalleEvaluacion=?")
                .setParameter(0, codigo).uniqueResult();
        session.getTransaction().commit();
        return DetalleEvaluacion;
    }

    public List<DetalleEvaluacion> listarDetalleEvaluaciones() {
         List<DetalleEvaluacion> DetalleEvaluaciones= sessionFactory.getCurrentSession()
                .createQuery("from DetalleEvaluacion order by idDetalleEvaluacion").list();
        return DetalleEvaluaciones;

    }


}
