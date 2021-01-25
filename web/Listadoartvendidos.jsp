<%-- 
    Document   : Listadoartvendidos
    Created on : 21 ene. 2021, 8:46:46
    Author     : HP
--%>

<%@page import="AL_clases.DetallePedido"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesion = request.getSession();
    sesion.getAttribute("lista_art_vendidos");
    ArrayList<DetallePedido> lista_art_vendidos;
    lista_art_vendidos =(ArrayList)sesion.getAttribute("lista_art_vendidos");
    

%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado articulos vendidos</h1>
        
        <table border=1>
<tr>
<tH>ID_ARTICULO</TH>
<tH>NOMBRE</Th>
<th>TOTAL</Th>

</TR>
<%
    for(int i=0; i<lista_art_vendidos.size();i++){
        int id_articulo = lista_art_vendidos.get(i).getId_articulo();
        String nombre = lista_art_vendidos.get(i).getNombre();
        double total = lista_art_vendidos.get(i).getTotal_venta();        
        
    %>

<tr>
 <TD> <%=id_articulo%> </TD>
 <TD><%=nombre%></TD>
 <TD><%=total%></TD>
 
</tr>
<% } %>
</table>
<br>
<br>

<br>
<br><a href="menuAdmin.jsp">MENU PRINCIPAL</A>
    </body>
</html>
