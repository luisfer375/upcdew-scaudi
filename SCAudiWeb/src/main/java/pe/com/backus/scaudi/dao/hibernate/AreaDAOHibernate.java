/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao.hibernate;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.AreaDAO;
import pe.com.backus.scaudi.domain.Area;

/**
 *
 * @author Administrador
 */
public class AreaDAOHibernate implements AreaDAO{

    private SessionFactory sessionFactory = HibernateSession.getSessionFactory();;


    public void guardar(Area area) {
        sessionFactory.getCurrentSession().saveOrUpdate(area);
    }

    public void eliminar(Area area) {
        sessionFactory.getCurrentSession().delete(area);
    }

    public Area obtenerArea(Integer codigo) {
       Area area =
                (Area) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from Area a  where a.idArea=?")
                .setParameter(0, codigo).uniqueResult();
        return area;
    }

    public List<Area> listarAreas() {
         List<Area> areas= sessionFactory.getCurrentSession()
                .createQuery("from Area order by idArea").list();
        return areas;

    }


}
