/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.web.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.backus.scaudi.domain.Region;
import pe.com.backus.scaudi.domain.Usuario;
import pe.com.backus.scaudi.service.RegionService;
import pe.com.backus.scaudi.service.UsuarioService;
import pe.com.backus.scaudi.service.impl.RegionServiceImpl;
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

       // RequestDispatcher dispacher = req.getRequestDispatcher("/index.jsp");
        HttpSession session = req.getSession(true);
        RegionService regionService = new RegionServiceImpl();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String mensaje = validar(login, password, session);
        List<Region> listaRegiones = regionService.listarRegiones();
        if("".equals(mensaje)){
            session.setAttribute("listaRegiones", listaRegiones);
            resp.sendRedirect("pages/welcome.jsp");
        }else{
            Log.debug("Mensaje:" + mensaje);
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            req.setAttribute("mensaje", mensaje);
            resp.sendRedirect("pages/login.jsp");
            //resp.sendRedirect("pages/login.jsp");
        }
            
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String validar(String login, String password, HttpSession session) {

         UsuarioService usuarioService = new UsuarioServiceImpl();
         Usuario usuario = usuarioService.validarUsuario(login, password);
         if("".equals(login))
             return  "Ingrese al usuario";
         else if("".equals(password))
             return "Ingrese al password";

         if(usuario == null)
            return "Usuario o clave incorrecta";
         else{
            Log.debug("Usuario - nombre: " + usuario.getNombre());
            session.setAttribute("usuario", usuario);
         }
        return "";
    }

}
