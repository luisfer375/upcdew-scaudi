/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.RegionDAO;
import pe.com.backus.scaudi.domain.Region;

/**
 *
 * @author Administrador
 */
public class RegionDAOHibernate implements RegionDAO{

    private SessionFactory sessionFactory = HibernateSession.getSessionFactory();;


    public void guardar(Region region) {
        sessionFactory.getCurrentSession().saveOrUpdate(region);
    }

    public void eliminar(Region region) {
        sessionFactory.getCurrentSession().delete(region);
    }

    public Region obtenerRegion(Integer codigo) {

       Region region =
                (Region) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from Region a  where a.idRegion=?")
                .setParameter(0, codigo).uniqueResult();
        return region;
    }

    public List<Region> listarRegiones() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
         List<Region> regiones= sessionFactory.getCurrentSession()
                .createQuery("from Region").list();
         session.getTransaction().commit();
        return regiones;

    }


}
