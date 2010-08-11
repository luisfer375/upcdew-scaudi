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
import javax.servlet.http.HttpSession;
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
        String accion = request.getParameter("accion");
        Log.debug("Accion realizada:" + accion);
        if(accion.equals("1"))
            cargarCombo(request,response);
        else{
            asignaCD(request,response);
        }
    }

    protected void asignaCD(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        CentroDistribucionService cdService = new CentroDistribucionServiceImpl();
        Log.debug("Entro Asignar Centro distribucion");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String idCD = request.getParameter("idCD");
        Log.debug("Id Centro Distribucion:" + idCD);
        CentroDistribucion cd = cdService.obtenerCentroDistribucion(Integer.valueOf(idCD));
        try{
           session.setAttribute("cd", cd);
           out.println("Se asigno el Centro de distribucion correctamente");

        }catch(Exception e){
            Log.error("Ocurrió una excecion" ,e);
           throw new InternalError(e.toString());
        }finally{
            out.close();
        }
    }


    protected void cargarCombo(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Log.debug("Entro cargarCombo");
        CentroDistribucionService cdService = new CentroDistribucionServiceImpl();
        List<CentroDistribucion> listaCD = null;
        PrintWriter out = response.getWriter();
        try{
        String strIdRegion = request.getParameter("idRegion");
        int idRegion = 0;
        Log.debug("Id Region:" + strIdRegion);
        if(!"".equals(strIdRegion)){
            idRegion = Integer.parseInt(strIdRegion);
            listaCD = cdService.listarCentroDistribuciones(idRegion);
            out.println("<option value=0 selected=selected>Seleccione</option>");
            for(CentroDistribucion cd : listaCD){
                out.println("<option value="
                        +   cd.getIdCentroDistribucion() +  ">"
                        +   cd.getDescripcion()+            "</option>");
                }
            }
        }catch(Exception e){
           Log.error("Ocurrió una excecion" ,e);
           throw new InternalError(e.toString());
        }finally{
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
        processRequest(request, response);
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
