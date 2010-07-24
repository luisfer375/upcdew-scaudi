/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.backus.scaudi.domain.Usuario;
import pe.com.backus.scaudi.service.UsuarioService;
import pe.com.backus.scaudi.service.impl.UsuarioServiceImpl;
import pe.com.backus.scaudi.util.Log;

/**
 *
 * @author Synopsis
 */
public class LoginServlet extends HttpServlet {
   
    
    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        UsuarioService usuarioService = new UsuarioServiceImpl();
        //Usuario usuario = usuarioService.obtenerUsuario(nombre);
        //Usuario usuario = usuarioService
        Log.info("Entro al servidor");
        String login = req.getParameter("login");
        Log.debug("Login: " + login);
        String password = req.getParameter("password");
        Log.debug("Clave: " + password);
        Usuario usuario = usuarioService.validarUsuario(login, password);

        if(usuario!= null){
            Log.debug("Usuario - nombre: " + usuario.getNombre());
            session.setAttribute("usuario", usuario);
            resp.sendRedirect("pages/welcome.jsp");
        }else
            resp.sendRedirect("pages/login.jsp");
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
