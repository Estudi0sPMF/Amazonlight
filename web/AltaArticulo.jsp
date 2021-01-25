<%-- 
    Document   : AltaArticulo
    Created on : 14 ene. 2021, 18:14:51
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <Table>
            <TR>

                <TD><h1> Amazon Light</h1></TD>  
            </TR>
        </table>
        <h2> Alta Articulo </h2>

        <form id="peticion" name="peticion" action="AltaArticulo" method="get">
            <Table>
                <TR>
                    <TD>Nombre:</Td> <Td><input type="text" id="nombre" name="nombre" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>Descripcion:</Td> <Td><input type="text" id="descripcion" name="descripcion" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>Precio:</Td> <Td><input type="text" id="precio" name="precio" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>Stock:</Td> <Td><input type="text" id="stock" name="stock" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>Foto:</Td> <Td><input type="text" id="urlFoto" name="urlFoto" size="30"><br></td>
                </TR>
               

            </table>
            <br>
            <br>
            <br>

            <input type="submit" value="Registrar alta">
        </form>	

        <br><a href="menuAdmin.jsp">MENU PRINCIPAL</A>
    </body>
</html>
