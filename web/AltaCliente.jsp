<%-- 
    Document   : AltaCliente
    Created on : 13 ene. 2021, 22:36:55
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
        <h2> Alta cliente </h2>

        <form id="peticion" name="peticion" action="AltaCliente" method="get">
            <Table>
                <TR>
                    <TD>Nombre:</Td> <Td><input type="text" id="nombre" name="nombre" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>Apellido:</Td> <Td><input type="text" id="apellido" name="apellido" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>DNI:</Td> <Td><input type="text" id="dni" name="dni" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>Direccion:</Td> <Td><input type="text" id="direccion" name="direccion" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>Telefono:</Td> <Td><input type="text" id="telefono" name="telefono" size="30"><br></td>
                </TR>
                <TR>
                    <TD>email:</Td> <Td><input type="text" id="email" name="email" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>Password:</Td> <Td><input type="password" id="password" name="password" size="30"required><br></td>
                </TR>

            </table>
            <br>
            <br>
            <br>

            <input type="submit" value="Registrar alta">
        </form>	

        <br><a href="nolosetodavía.jsp">no lo se todavía</A>
    </body>
</html>
