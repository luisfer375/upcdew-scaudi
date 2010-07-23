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

/**
 *
 * @author Administrador
 */
public class LoginFiltro implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		if (request.getSession().getAttribute("usuario") != null){
			//Authentication passed.
		}
		else {
			if (!request.getServletPath().endsWith("login.jsp")){
				//response.sendRedirect("http://www.google.ca");
				System.out.println("url: " + request.getContextPath() + "/login.jsp");
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		}
	}


	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
