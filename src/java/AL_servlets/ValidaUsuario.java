/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AL_servlets;

import AL_clases.ConectaBD;
import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
public class ValidaUsuario extends HttpServlet {

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
        
          HttpSession sesion = request.getSession();
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String password = "";
            String tipousuario = "";
            String email= "";
            int idcliente = 0;
           
            Connection conexion = null;
            ResultSet rs = null;
            PreparedStatement st = null;
            

            ConectaBD bd = new ConectaBD();
            bd.conecta();
            bd.getConexion();

            String miemail = request.getParameter("email");
            String mipwd = request.getParameter("password");
            sesion.setAttribute("email", miemail);
            sesion.setAttribute("contrasenia", mipwd);
            conexion=bd.getConexion();

           
            String sql = "SELECT id_cliente,tipo_usuario from cliente where email=? and pwd=?";

            try {
                st = conexion.prepareStatement(sql);
                
                st.setString(1, miemail);
                st.setString(2, mipwd);

                rs = st.executeQuery();
                while (rs.next()) {
                    
                    
                    idcliente= rs.getInt("id_cliente");
                    tipousuario = rs.getString("tipo_usuario");
                    
                   
                  

                }

                if ("A".equals(tipousuario)) {
                    response.sendRedirect("menuAdmin.jsp");
                } else if ("U".equals(tipousuario)) {
                    request.getSession().setAttribute("idcli",idcliente); 
                    response.sendRedirect("menuCliente.jsp");
                }else{
                    response.sendRedirect("Registro.jsp");
                }
            } catch (Exception e) {
                out.println(e);
            }

            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaUsuario at " + request.getContextPath() + "</h1>");
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
