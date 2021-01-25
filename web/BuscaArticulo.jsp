<%-- 
    Document   : BuscaArticulo
    Created on : 15 ene. 2021, 13:16:39
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
        <title>Buscar Articulo</title>
    </head>
    <body>
        <h1>Amazon Light</h1>
        <form id="buscart" name="buscart" action="BuscaArticulo" method="POST">
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
