<%-- 
    Document   : index
    Created on : 15/05/2018, 11:34:28
    Author     : vapstor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inversor Palavras</title>
    </head>
    <body>
        <div>
            <form method="POST" action="RegistraTexto">
                <input type="text" name="inputTexto" maxlength="500" placeholder="digite a palavra a inverter">
                <input type="submit" value="Enviar"/>
            </form>
        </div>
        
        <div>
            <div>${erro}</div>
            <label>Suas Palavras:</label>
            <ul>
                <li>${texto}</li>
            </ul>
            <label>Suas Palavras Invertidas:</label>
            <ul>
                <li>${textoInvertido}</li>
            </ul>
        </div>
    </body>
</html>
