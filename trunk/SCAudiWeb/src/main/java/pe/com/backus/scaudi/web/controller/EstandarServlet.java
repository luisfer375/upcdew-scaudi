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
import javax.servlet.http.HttpSession;
import pe.com.backus.scaudi.domain.CentroDistribucion;
import pe.com.backus.scaudi.domain.DetalleEvaluacion;
import pe.com.backus.scaudi.domain.Estandar;
import pe.com.backus.scaudi.domain.Evaluacion;
import pe.com.backus.scaudi.domain.Usuario;
import pe.com.backus.scaudi.service.DetalleEvaluacionService;
import pe.com.backus.scaudi.service.EstandarService;
import pe.com.backus.scaudi.service.impl.DetalleEvaluacionServiceImpl;
import pe.com.backus.scaudi.service.impl.EstandarServiceImpl;

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
        HttpSession session                 = request.getSession();
        DetalleEvaluacionService deService  = new DetalleEvaluacionServiceImpl();
        RequestDispatcher rd                = null;
        Estandar estandarActual             = null;
        Estandar estandarNuevo              = null;
        CentroDistribucion cd               = null;
        Evaluacion evaluacion               = new Evaluacion();
        DetalleEvaluacion detalleEvaluacion = new DetalleEvaluacion();
        EstandarService estandarService     = new EstandarServiceImpl();
        Usuario usuario                     = (Usuario) session.getAttribute("usuario");

        String strIdEstandar                = request.getParameter("idEstandar");
        String calificacion                 = request.getParameter("calificacion");
        String recomendacion                = request.getParameter("recomendacion");
        String observacion                  = request.getParameter("observacion");
        int idEstandar                      = Integer.valueOf(strIdEstandar);
        estandarActual                      =  estandarService.obtenerEstandar(idEstandar);
        cd                                  = (CentroDistribucion)session.getAttribute("cd");

        /**Seteo los parametros del Estandar**/

        detalleEvaluacion.setEstandar(estandarActual);
        detalleEvaluacion.setObservaciones(observacion);
        detalleEvaluacion.setOportunidades(recomendacion);
        evaluacion.setCentroDistribucion(cd);
        evaluacion.setUsuario(usuario);
        evaluacion.setPosiblePuntaje(Integer.valueOf(calificacion));
        detalleEvaluacion.setEvaluacion(evaluacion);
        deService.guardar(detalleEvaluacion);

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
