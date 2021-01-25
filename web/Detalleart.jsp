<%-- 
    Document   : Detalleart
    Created on : 17 ene. 2021, 12:32:47
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
        <title>Detalle Articulo</title>
    </head>
    <body>
        <form id="cesta" name="cesta" action="CestaTmp" method="get">
            <table>

                <tr>
                    <TD><img src="<%=(String) sesion.getAttribute("det_foto")%>"></TD>

                </tr>
                <tr>
                    <TD><FONT SIZE=5 color="blue"><%=(String) sesion.getAttribute("det_nombre")%></FONT></TD>   
                </tr>
                <tr>
                    <TD><%=(String) sesion.getAttribute("det_descripcion")%></TD>  

                </tr>
                <tr>
                    <td><font SIZE="5"><%=(Double) sesion.getAttribute("det_precio")%>€</font></td>
                </tr>
                <tr>
                    <TD><%=(Integer) sesion.getAttribute("det_stock")%> UNIDADES</TD>  
                </tr>
                <tr>
                    <Td> cantidad:

                        <input type="number" name="cantidad" min="1" max="<%=(Integer) sesion.getAttribute("det_stock")%>" value="1" />
                        </td>
                        
                    
                </tr>
                <tr>
                    <td>

                        <input type="submit" name="botonAniadirCesta" value="Añadir a cesta" ></td>
                </tr>
            </table>
        </form>
    </body>
</html>
