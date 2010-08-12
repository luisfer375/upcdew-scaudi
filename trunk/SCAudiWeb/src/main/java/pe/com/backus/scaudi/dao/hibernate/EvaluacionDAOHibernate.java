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
import pe.com.backus.scaudi.domain.Usuario;
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
       sessionFactory.getCurrentSession().save(Evaluacion);
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
                .createQuery("from Evaluacion a where a.periodo=?")
                .setParameter(0, codigo).uniqueResult();
        session.getTransaction().commit();
        return Evaluacion;
    }

    public List<Evaluacion> listarEvaluaciones() {
         List<Evaluacion> Evaluaciones= sessionFactory.getCurrentSession()
                .createQuery("from Evaluacion order by idEvaluacion").list();
        return Evaluaciones;

    }

    public Integer obtenerCorrelativoEvaluacionUsuario(Usuario usuario) {
       Log.debug("Obtiene los obtenerCorrelativoEvaluacionUsuario");
       Session session = sessionFactory.getCurrentSession();
       session.beginTransaction();
       Integer periodo =
                (Integer) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("select max(e.periodo) from Evaluacion e where e.Usuario.idUsuario=?")
                .setParameter(0, usuario.getIdUsuario()).uniqueResult();
        session.getTransaction().commit();
        Log.debug("periodo:" + periodo);
        return periodo;
    }


}
