/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao.hibernate;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.EstandarDAO;
import pe.com.backus.scaudi.domain.Estandar;

/**
 *
 * @author Administrador
 */
public class EstandarDAOHibernate implements EstandarDAO{

    private SessionFactory sessionFactory = HibernateSession.getSessionFactory();;


    public void guardar(Estandar estandar) {
        sessionFactory.getCurrentSession().saveOrUpdate(estandar);
    }

    public void eliminar(Estandar estandar) {
        sessionFactory.getCurrentSession().delete(estandar);
    }

    public Estandar obtenerEstandar(Integer codigo) {
       Estandar estandar =
                (Estandar) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from Estandar a  where a.idEstandar=?")
                .setParameter(0, codigo).uniqueResult();
        return estandar;
    }

    public List<Estandar> listarEstandares() {
         List<Estandar> estandars= sessionFactory.getCurrentSession()
                .createQuery("from Estandar order by idEstandar").list();
        return estandars;

    }


}
