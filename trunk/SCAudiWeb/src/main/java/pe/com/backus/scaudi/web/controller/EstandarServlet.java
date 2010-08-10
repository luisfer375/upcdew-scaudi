/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.com.backus.scaudi.domain.DetalleEvaluacion;
import pe.com.backus.scaudi.domain.Estandar;
import pe.com.backus.scaudi.service.EstandarService;
import pe.com.backus.scaudi.service.impl.EstandarServiceImpl;
import pe.com.backus.scaudi.util.Log;

/**
 *
 * @author etapiave
 */
public class EstandarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

  



    }


    private void irPagina(HttpServletRequest request, HttpServletResponse response){

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
        RequestDispatcher rd                = null;
        Estandar estandarActual             = null;
        Estandar estandarNuevo              = null;
        DetalleEvaluacion detalleEvaluacion = new DetalleEvaluacion();
        EstandarService estandarService     = new EstandarServiceImpl();
        String strIdEstandar                = request.getParameter("idEstandar");
        String recomendacion                = request.getParameter("recomendacion");
        String observacion                  = request.getParameter("observacion");
        int idEstandar                      = Integer.valueOf(strIdEstandar);
        estandarActual                      =  estandarService.obtenerEstandar(idEstandar);

        /**Seteo los parametros del Estandar**/
        detalleEvaluacion.setEstandar(estandarActual);
        detalleEvaluacion.setObservaciones(observacion);
        detalleEvaluacion.setOportunidades(recomendacion);

        if (idEstandar < 5) {
            rd                              = request.getRequestDispatcher("pages/est1.jsp");
            estandarNuevo                   = estandarService.obtenerEstandar(idEstandar + 1);
        } else{
            rd                           =  request.getRequestDispatcher("pages/exito.jsp");
        }

        request.setAttribute("estandar", estandarNuevo);
        rd.forward(request, response);
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
