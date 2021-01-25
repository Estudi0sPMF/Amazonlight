<%-- 
    Document   : BuscaArticulosCompra
    Created on : 23 ene. 2021, 11:14:03
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesion = request.getSession();

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <h1>Amazon Light</h1>
        <form id="buscartcomp" name="buscartcomp" action="CompraArticulo" method="POST">
            <table>
                <tr>
                    <td>Buscar:</td>
                    <td><input type="text" id="articulo" name="articulo" size="30" required><br></td>
                </tr>
            </table>
            <br>
            <br>
            <br>



            <input type="submit" value="Buscar">

        </form>	

        <br><a href="menuCliente.jsp">MENU PRINCIPAL</A>



    </form>
    </body>
</html>
