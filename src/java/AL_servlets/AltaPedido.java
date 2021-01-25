package AL_servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AL_clases.DetallePedido;
import AL_clases.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class AltaPedido extends HttpServlet {

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
            int id_pedido = 0;
            LocalDate fecha_pedido= LocalDate.now();
            int id_cliente = 0;
            double importe_pedido = 0;
        
        
        try {
            
            Pedido Pe= new Pedido(id_pedido,fecha_pedido, id_cliente,importe_pedido);
            id_cliente= (Integer)request.getSession().getAttribute("idcli");
            importe_pedido=0; //tengo que calcularlo de la cesta
            
            
            Pe.altaPedido(fecha_pedido, id_cliente,importe_pedido);
         
            int altaPedido=Pe.getAltaPedido();
            
            int idpedido=Pe.getId_pedido();
            System.out.println(idpedido);
            if (altaPedido >0){
                request.getSession().setAttribute("idpedido", idpedido);
                response.sendRedirect("AltaDetallePedido");
               
            }else{
                response.sendRedirect("ErrorRegistro.jsp");
                
            }
          
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaPedido at " + request.getContextPath() + "</h1>");
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
