<%-- 
    Document   : ListadoArticulos
    Created on : 16 ene. 2021, 19:56:46
    Author     : HP
--%>

<%@page import="AL_clases.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   HttpSession sesion = request.getSession();
   sesion.getAttribute("ListadoArticulos");
   ArrayList<Articulo> listadoarticulos;
   listadoarticulos=(ArrayList)sesion.getAttribute("ListadoArticulos");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Articulos</title>
    </head>
    <body>
        <h1>Listado Articulos</h1>

        <table border=1>
            <tr>
                <td><B>NOMBRE</B></TD>
                <td><B>DESCRIPCION</B></TD>
                <td><B>PRECIO</B></TD>
                <td><B>STOCK</B></TD>
                <td><B><CENTER>FOTO</CENTER></B></TD>
            </TR>
            <%
                for(int i=0; i<listadoarticulos.size();i++){
                    int idarticulo = listadoarticulos.get(i).getId_articulo();
                    String nombre = listadoarticulos.get(i).getNombre();
                    String descripcion = listadoarticulos.get(i).getDescripcion();
                    double precio = listadoarticulos.get(i).getPrecio();        
                    int stock= listadoarticulos.get(i).getStock();
                    String foto= listadoarticulos.get(i).getUrlFoto();
        
            %>

            <tr>
                <TD> <Font size=5 color="blue"><%=nombre%><font> </TD>
                <TD><%=descripcion%></TD>
                <TD><font SIZE="5"><%=precio%> €</font></TD>
                <TD><center><font size="5"><%=stock%> </font></center></TD>
                <TD><form id="detalleart" name="detalleart" action="Detalleart" method="get">
                        <input type="hidden" name="idarticulo" value="<%=idarticulo%>">        
                <input type="image" name="imagen" src="<%=foto%>"></form> </TD>
    </tr>

    

    <% } %>
</table>
<br>
<br>
<br>
<br>
<br>
<br><a href="menuCliente.jsp">MENU PRINCIPAL</A>
</body>
</html>
