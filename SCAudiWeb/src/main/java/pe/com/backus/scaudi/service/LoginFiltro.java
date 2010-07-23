/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrador
 */
public class LoginFiltro implements Filter{

    private FilterConfig config;
    private String urlLogin;


   public void init(FilterConfig config) throws ServletException {
    this.config = config;

    //Tambien se pueden cargar los parametros
    //Configura url desconexión
  //  urlLogin = config.getInitParameter(“urlLogin”);
    if (urlLogin == null || urlLogin.trim().length() == 0) {
    //Error al cargar la url de login
    throw new ServletException("No se ha configurado URL de login");
    }
}

    public void destroy() {
    config = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {

        chain.doFilter(request, response);

        // Extraer Sesión
        HttpSession session = ((HttpServletRequest)request).getSession();

        if(session.getAttribute("usuario")==null)
        {
        //NO hay una session con ususario
        RequestDispatcher dispatcher =                                                          request.getRequestDispatcher("/"+urlLogin);
        dispatcher.forward(request, response);
        }

    }
}
