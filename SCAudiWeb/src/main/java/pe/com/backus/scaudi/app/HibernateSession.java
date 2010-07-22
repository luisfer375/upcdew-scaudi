/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.app;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pe.com.backus.scaudi.util.Log;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author Administrador
 */
public class HibernateSession {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            Log.error("Error al inicializar el SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
