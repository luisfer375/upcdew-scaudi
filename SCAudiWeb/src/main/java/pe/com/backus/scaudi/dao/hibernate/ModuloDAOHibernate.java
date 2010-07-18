/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.dao.hibernate;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.backus.scaudi.app.HibernateSession;
import pe.com.backus.scaudi.dao.ModuloDAO;
import pe.com.backus.scaudi.domain.Modulo;

/**
 *
 * @author Administrador
 */
public class ModuloDAOHibernate implements ModuloDAO{

    private SessionFactory sessionFactory = HibernateSession.getSessionFactory();;


    public void guardar(Modulo modulo) {
        sessionFactory.getCurrentSession().saveOrUpdate(modulo);
    }

    public void eliminar(Modulo modulo) {
        sessionFactory.getCurrentSession().delete(modulo);
    }

    public Modulo obtenerModulo(Integer codigo) {
       Modulo modulo =
                (Modulo) sessionFactory.getCurrentSession()
                //Aquí cada uno pone su consulta.
                .createQuery("from Modulo a  where a.idModulo=?")
                .setParameter(0, codigo).uniqueResult();
        return modulo;
    }

    public List<Modulo> listarModulos() {
         List<Modulo> modulos= sessionFactory.getCurrentSession()
                .createQuery("from Modulo order by idModulo").list();
        return modulos;

    }


}
