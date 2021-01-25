<%-- 
    Document   : ListadoClientes
    Created on : 14 ene. 2021, 11:24:29
    Author     : HP
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="AL_clases.Cliente"%>
<%@page session="true"%>

<%
    HttpSession sesion = request.getSession();
    sesion.getAttribute("ListadoClientes");
    ArrayList<Cliente> listadoclientes;
    listadoclientes =(ArrayList)sesion.getAttribute("ListadoClientes");
    

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script>
        function exportTableToExcel(tableID, filename = ''){
    var downloadLink;
    var dataType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'excel_data.xls';
    
    // Create download link element
    downloadLink = document.createElement("a");
    
    document.body.appendChild(downloadLink);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['ufeff', tableHTML], {
            type: dataType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
    }else{
        // Create a link to the file
        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
    
        // Setting the file name
        downloadLink.download = filename;
        
        //triggering the function
        downloadLink.click();
    }
}
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Clientes</title>
    </head>
    
    <body>
                <h1>Listado Clientes</h1>

<table id="tblData"  border=1>
<tr>
<th>NOMBRE</Th>
<th>APELLIDO</Th>
<th>DNI</Th>
<th>DIRECCION</Th>
<th>TELEFONO</Th>
<th>EMAIL</Th>
</TR>
<%
    for(int i=0; i<listadoclientes.size();i++){
        String nombre = listadoclientes.get(i).getNombre();
        String apellido = listadoclientes.get(i).getApellido();
        String dni = listadoclientes.get(i).getDni();        
        String direccion= listadoclientes.get(i).getDireccion();
        String telefono= listadoclientes.get(i).getTelefono();
        String email= listadoclientes.get(i).getemail();
       
        
    %>

<tr>
 <TD> <%=nombre%> </TD>
 <TD><%=apellido%></TD>
 <TD><%=dni%></TD>
 <TD><%=direccion%></TD>
 <TD><%=telefono%></TD>
 <TD><%=email%></TD>
</tr>
<% } %>
</table>
<br>
<button onclick="exportTableToExcel('tblData')">Export Table Data To Excel File</button>
<br>
<br>
<br><a href="menuAdmin.jsp">MENU PRINCIPAL</A>
    </body>
</html>
