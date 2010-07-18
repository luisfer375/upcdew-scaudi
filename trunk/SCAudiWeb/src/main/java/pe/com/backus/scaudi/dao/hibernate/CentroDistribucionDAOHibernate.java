/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao.hibernate;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.CentroDistribucionDAO;
import pe.com.backus.scaudi.domain.CentroDistribucion;

/**
 *
 * @author Administrador
 */
public class CentroDistribucionDAOHibernate implements CentroDistribucionDAO{

    private SessionFactory sessionFactory = HibernateSession.getSessionFactory();;


    public void guardar(CentroDistribucion centroDistribucion) {
        sessionFactory.getCurrentSession().saveOrUpdate(centroDistribucion);
    }

    public void eliminar(CentroDistribucion centroDistribucion) {
        sessionFactory.getCurrentSession().delete(centroDistribucion);
    }

    public CentroDistribucion obtenerCentroDistribucion(Integer codigo) {
       CentroDistribucion centroDistribucion =
                (CentroDistribucion) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from CentroDistribucion a  where a.idCentroDistribucion=?")
                .setParameter(0, codigo).uniqueResult();
        return centroDistribucion;
    }

    public List<CentroDistribucion> listarCentroDistribuciones() {
         List<CentroDistribucion> centroDistribucions= sessionFactory.getCurrentSession()
                .createQuery("from CentroDistribucion order by idCentroDistribucion").list();
        return centroDistribucions;

    }


}
