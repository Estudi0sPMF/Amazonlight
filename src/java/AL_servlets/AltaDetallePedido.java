/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AL_servlets;

import AL_clases.ArticuloCesta;
import AL_clases.DetallePedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet("/AltaDetallePedido")
public class AltaDetallePedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList<ArticuloCesta> cesta;
        cesta = (ArrayList) request.getSession().getAttribute("cesta");
        int id_pedido = (Integer) request.getSession().getAttribute("idpedido");
        int numartpedido=0;
        System.out.println(id_pedido);
        try {

            for (int i = 0; i < cesta.size(); i++) {

                int id_articulo = cesta.get(i).getId_articulo();
                String nombre = cesta.get(i).getNombre();
                double precioArticulo = cesta.get(i).getPrecio();
                int unidades = cesta.get(i).getCantidad();
                double total = cesta.get(i).getTotal_pvpart();

                DetallePedido dp = new DetallePedido();
                dp.altaDetallePedido(id_pedido, id_articulo, precioArticulo, unidades);
                int altaDetPed = dp.getAltaDetPed();
               
                if (altaDetPed > 0) {
                  numartpedido ++;
                }
                
            }
            if (numartpedido == cesta.size()) {
                response.sendRedirect("ProcesaPago");
            } else {
                response.sendRedirect("ErrorRegistro.jsp");
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DetallePedido</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetallePedido at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
