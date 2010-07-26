/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.com.backus.scaudi.domain.Area;
import pe.com.backus.scaudi.domain.EncuestaDetalle;
import pe.com.backus.scaudi.domain.Estandar;
import pe.com.backus.scaudi.domain.Modulo;
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

        List<EncuestaDetalle> listaEncuestaDetalle = null;
        RequestDispatcher rd = null;
        String calificacion = request.getParameter("calificacion");
        String tipo =  request.getParameter("hiddenField");
        String observacion = request.getParameter("observacion");
        String recomendacion = request.getParameter("recomendacion");
        Log.debug("Calificacion: " +  calificacion);
        Log.debug("Estandar: " +  tipo);
        EncuestaDetalle encuestaDetalle = new EncuestaDetalle();
        Estandar estandar = new Estandar();
        Area area = new Area();
        Modulo modulo = new Modulo();
        estandar.setIdEstandar(1);
        modulo.setDescripcion("Reparto");
        modulo.setIdModulo(1);
        area.setIdArea(1);
        area.setModulo(modulo);
        area.setDescripcion("Distribucion");
        area.setPeso(1);
        estandar.setArea(area);
        estandar.setDesripcion("Despacho");
        estandar.setPeso(1);
        encuestaDetalle.setEstandar(estandar);
        encuestaDetalle.setObservacion(observacion);
        encuestaDetalle.setRecomendacion(recomendacion);

        listaEncuestaDetalle = (ArrayList<EncuestaDetalle>) request.getAttribute("listaEncuestaDetalle");
        if(listaEncuestaDetalle == null){
            listaEncuestaDetalle = new ArrayList<EncuestaDetalle>();
        }else{
            request.removeAttribute("listaEncuestaDetalle");
        }


        String ruta = "/pages/est";
        if(Integer.parseInt(tipo)>15){
             ruta = "/pages/exito" + ".jsp";
     //       request.setAttribute("mensaje", "Auditoria finalizada");
        }else{
            ruta +=  (Integer.parseInt(tipo) + 1) + ".jsp";
            listaEncuestaDetalle.add(encuestaDetalle);
            request.setAttribute("listaEncuestaDetalle", listaEncuestaDetalle);
        }
        rd = request.getRequestDispatcher(ruta);
        

        rd.forward(request, response);



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
