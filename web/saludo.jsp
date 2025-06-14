<%-- 
    Document   : saludo
    Created on : 7 jun. 2025, 9:52:22 p. m.
    Author     : LUCY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%-- estilo --%>
    
    <style>
        body{
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        
        
    </style>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muestra resultado JSP</title>
    </head>
    <body>
        <h1>Hola desde el JSP!</h1>
        <h2>Bienvenido, ${nombreUsuario}</h2>
        
        <%-- 
        
        <h2>Bienvenido, ${codigoUsuario}</h2>
        <h2>Bienvenido, ${carreraUsuario}</h2>

        
        --%>
    </body>
</html>
