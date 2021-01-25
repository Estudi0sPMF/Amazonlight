/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Detalleart;

import AL_clases.ConectaBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class Detalleart extends HttpServlet {

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
        try {

            Connection conexion = null;
            Statement st = null;
            ResultSet rs = null;
            ConectaBD bd = new ConectaBD();
            bd.conecta();
            conexion = bd.getConexion();
            st = conexion.createStatement();

            String id =request.getParameter("idarticulo");
            String sql = "SELECT * from articulo where id_articulo = '"+id+"'";

            rs = st.executeQuery(sql);
            
                int detidarticulo;
                String detnombre;
                String detdescripcion;
                double detprecio;
                int detstock;
                String detfoto;
            
            while (rs.next()) {

                detidarticulo = rs.getInt("id_articulo");
                detnombre = rs.getString("nombre");
                detdescripcion = rs.getString("Descripcion");
                detprecio = (rs.getInt("precio"));
                detstock = (rs.getInt("stock"));
                detfoto = rs.getString("url_foto");
                
            

                request.getSession().setAttribute("det_idarticulo", detidarticulo);
                request.getSession().setAttribute("det_nombre", detnombre);
                request.getSession().setAttribute("det_descripcion", detdescripcion);
                request.getSession().setAttribute("det_precio", detprecio);
                request.getSession().setAttribute("det_stock", detstock);
                request.getSession().setAttribute("det_foto", detfoto);

                response.sendRedirect("Detalleart.jsp");
              }  
                 
            } catch (SQLException ex) {
            Logger.getLogger(Detalleart.class.getName()).log(Level.SEVERE, null, ex);
                        
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Detalleart</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet Detalleart at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
                
                
           
            
        }finally {
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
