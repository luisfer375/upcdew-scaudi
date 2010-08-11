/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.com.backus.scaudi.domain.CentroDistribucion;
import pe.com.backus.scaudi.service.CentroDistribucionService;
import pe.com.backus.scaudi.service.impl.CentroDistribucionServiceImpl;
import pe.com.backus.scaudi.util.Log;

/**
 *
 * @author Administrador
 */
public class AjaxServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AjaxServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjaxServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        CentroDistribucionService cdService = new CentroDistribucionServiceImpl();
        List<CentroDistribucion> listaCD = null;
        PrintWriter out = response.getWriter();
        String strIdRegion = request.getParameter("idRegion");
        int idRegion = 0;
        Log.debug("Id Region:" + strIdRegion);
        if(!"".equals(strIdRegion)){
            idRegion = Integer.parseInt(strIdRegion);
            listaCD = cdService.listarCentroDistribuciones(idRegion);
            for(CentroDistribucion cd : listaCD){
                out.println("<option value="
                        +   cd.getIdCentroDistribucion() +  ">"
                        +   cd.getDescripcion()+            "</option>");
            }
        }


    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
