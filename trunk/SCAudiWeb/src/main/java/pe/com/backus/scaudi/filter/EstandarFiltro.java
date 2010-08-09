/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.backus.scaudi.domain.Estandar;
import pe.com.backus.scaudi.service.EstandarService;
import pe.com.backus.scaudi.service.impl.EstandarServiceImpl;
import pe.com.backus.scaudi.util.Log;

/**
 *
 * @author Administrador
 */
public class EstandarFiltro implements Filter {

   public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
                HttpSession sesion =  request.getSession();

                Log.debug("Filtro Estandar" + request.getServletPath().substring(7));
                if(request.getServletPath().substring(7).equals("est1.jsp")){
                    if(request.getAttribute("estandar") ==null){
                        Log.debug("Inicializando idEstandar" + request.getServletPath().substring(7));
                        EstandarService estandarService = new EstandarServiceImpl();
                        Estandar estandar = estandarService.obtenerEstandar(1);
                        request.setAttribute("estandar", estandar);
                    }
                }
                filterChain.doFilter(request, response);
        }


	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
