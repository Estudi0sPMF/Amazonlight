<%-- 
    Document   : MuestraBusqueda
    Created on : 15 ene. 2021, 19:31:51
    Author     : HP
--%>

<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesion = request.getSession();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muestra Busqueda</title>
    </head>
    <body>
        <h2>Resultado Busqueda</h2>
        <table>

            <tr>
                <TD><img src="<%=(String) sesion.getAttribute("URL_foto")%>"></TD>

            </tr>
            <tr>
                <TD><FONT SIZE=5 color="blue"><%=(String) sesion.getAttribute("Nombre")%></FONT></TD>   
            </tr>
            <tr>
                <TD><%=(String) sesion.getAttribute("Descripcion")%></TD>  
                
            </tr>
            <tr>
                <td><font SIZE="5"><%=(Double) sesion.getAttribute("precio")%>€</font></td>
            </tr>
            <tr>
                <TD><%=(String) sesion.getAttribute("Stock")%> UNIDADES</TD>  
            </tr>
            <tr>

            </tr>
        </table>
    </body>
</html>
