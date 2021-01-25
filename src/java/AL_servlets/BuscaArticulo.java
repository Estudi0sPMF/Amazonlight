/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AL_servlets;

import AL_clases.ConectaBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
public class BuscaArticulo extends HttpServlet {

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
        
        HttpSession sesion = request.getSession();
        
        try {
            
            String miarticulo = '%'+request.getParameter("articulo")+'%';
            
            Connection conexion = null;
            ResultSet rs = null;
            PreparedStatement st = null;
            

            ConectaBD bd= new ConectaBD(); 
            bd.conecta();
            bd.getConexion();
            conexion=bd.getConexion();

           
            String sql = "SELECT Id_articulo,Nombre,Descripcion,Precio,Stock,URL_foto from articulo where Nombre like ? ";

            try {
                st = conexion.prepareStatement(sql);
                
                st.setString(1, miarticulo);
               

                rs = st.executeQuery();
                while (rs.next()) {
                    int idart = rs.getInt("Id_articulo");
                    String nombre = rs.getString("Nombre");
                    String descripcion = rs.getString("Descripcion");
                    double precio = rs.getDouble("precio");
                    String stock=rs.getString("Stock");
                    String foto=rs.getString("URL_foto");
                 
                 request.getSession().setAttribute("Id_articulo", idart);
                 request.getSession().setAttribute("Nombre", nombre);
                 request.getSession().setAttribute("Descripcion", descripcion);
                 request.getSession().setAttribute("precio",precio);
                 request.getSession().setAttribute("Stock", stock);
                 request.getSession().setAttribute("URL_foto", foto);

                 response.sendRedirect("MuestraBusqueda.jsp");
                }
                
                     
            } catch (SQLException e) {
                out.println(e);
            }
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuscaArticulo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuscaArticulo at " + request.getContextPath() + "</h1>");
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
