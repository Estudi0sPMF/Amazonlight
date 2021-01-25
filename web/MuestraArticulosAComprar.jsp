<%-- 
    Document   : MuestraArticulosAComprar
    Created on : 23 ene. 2021, 11:20:46
    Author     : HP
--%>

<%@page import="AL_clases.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
   HttpSession sesion = request.getSession();
   sesion.getAttribute("SeleccionArticulos");
   ArrayList<Articulo> seleccionarticulos;
   seleccionarticulos=(ArrayList)sesion.getAttribute("SeleccionArticulos");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muestra articulos a comprar</title>
    </head>
    <body>
        <h1>Seleccion Articulos</h1>

        <table border=1>
            <tr>
                <td><B>NOMBRE</B></TD>
                <td><B>DESCRIPCION</B></TD>
                <td><B>PRECIO</B></TD>
                <td><B>STOCK</B></TD>
                <td><B><CENTER>FOTO</CENTER></B></TD>
            </TR>
            <%
                for(int i=0; i<seleccionarticulos.size();i++){
                    int idarticulo = seleccionarticulos.get(i).getId_articulo();
                    String nombre = seleccionarticulos.get(i).getNombre();
                    String descripcion = seleccionarticulos.get(i).getDescripcion();
                    double precio = seleccionarticulos.get(i).getPrecio();        
                    int stock= seleccionarticulos.get(i).getStock();
                    String foto= seleccionarticulos.get(i).getUrlFoto();
        
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
    </body>
</html>
