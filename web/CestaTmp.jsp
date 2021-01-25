<%-- 
    Document   : CestaTmp
    Created on : 18 ene. 2021, 16:34:58
    Author     : HP
--%>

<%@page import="AL_clases.ArticuloCesta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesion = request.getSession();
    sesion.getAttribute("cesta");
    ArrayList<ArticuloCesta> cesta;
    cesta = (ArrayList) sesion.getAttribute("cesta");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cesta Temporal</title>
    </head>
    <body>
        <h1>Listado Articulos Cesta</h1>

        <table border=1>
            <tr>
                <td><B>NOMBRE</B></TD>
                <td><B>PRECIO</B></TD>
                <td><B>CANTIDAD</B></TD>
                <td><B><CENTER>TOTAL</CENTER></B></TD>
            </TR>
            <%
                for (int i = 0; i < cesta.size(); i++) {
                    int idarticulo = cesta.get(i).getId_articulo();
                    String nombre = cesta.get(i).getNombre();
                    double precio = cesta.get(i).getPrecio();
                    int cantidad = cesta.get(i).getCantidad();
                    double total = cesta.get(i).getTotal_pvpart();

            %>

            <tr>
                <TD> <Font size=5 color="blue"><%=nombre%><font> </TD> 
                <TD><font SIZE="5"><%=precio%> €</font></TD>
                <TD><center><font size="5"><%=cantidad%> </font></center></TD>
                <TD><font SIZE="5"><%=total%> €</font></TD>
                
            </tr> 

    <% }%>
</table>
<Table>
    <TR>
        <Td>
            <Form id="seguircompra" name="seguircompra"action="ListadoArticulos.jsp" method="get">
               <input type="submit" name="botoncomprar" value="Seguir Comprando" >
            </Form>
        </Td> 
        <td>
            <Form id="pedido" name="pedido" action="AltaPedido" method="get">
                <input type="submit" name="botonpagar" value="Pagar" ></td>
            </Form>
        </td>
    </TR>
    
</Table>


<br>
<br>
<br>
<br><a href="menuCliente.jsp">MENU PRINCIPAL</A>
</body>
</html>
