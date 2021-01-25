<%-- 
    Document   : index
    Created on : 13 ene. 2021, 17:28:30
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Amazon_light</title>
    </head>
    <body>
                   <Table align=center>
<TR>

<TD align=center><h1>Amazon Light</H1></TD>
</TR>
</Table>

<form id="login" name="login" action="ValidaUsuario" method="post">
<Table>
<TR>
<TD>Email:</TD> <TD> <input type="text" id="userid" name="email" size="30" required><br></td>
</TR>
<TR>
<TD>PASSWORD:</TD><TD><input type="password" id="password" name="password" size="30" required><br></td>
</TR>

</table>
<br>
<br>
<br>

<input type="submit" value="Enter">


    </body>
</html>
