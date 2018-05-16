<%-- 
    Document   : index
    Created on : 15/05/2018, 11:34:28
    Author     : vapstor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- BOOTSTRAP Latest compiled and minified CSS/JS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function(){
                var erro = '${erro}';
                var sucesso = '${sucesso}';
                if(sucesso.length > 0) {
                    $("#msg-sucesso").removeClass("hide");
                }
                if(erro.length > 0) {
                    $("#msg-erro").removeClass("hide");
                }
            });
        </script>
        <!-- Custom Theme files -->
        <link href="./style.css" rel='stylesheet' type='text/css' />
        <script src="./style.js"></script>
        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Doppio+One' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oswald:400,700' rel='stylesheet' type='text/css'>
        <title>Inversor Palavras</title>
    </head>
    <body>
        <div class="jumbotron">

            <div class="row">
                <div class="col-md-6 offset-md-3 ">
                    <div class="row">
                        <div class="col-md-12 marginLados0">
                            <form method="POST" action="RegistraTexto">
                                <input type="text" class="inputTexto" name="inputTexto" maxlength="500" placeholder="Digite a palavra a inverter">
                                <input type="submit" class="btn btn-outline-primary btn-enviar" value="Enviar"/>
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div  class="col-md-12">
                           <div class="row alert alert-danger alert-dismissible fade show hide" role="alert" id="msg-erro">
                                ${erro}
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                           </div>
                            <div class="row alert alert-success alert-dismissible fade show hide" role="alert" id="msg-sucesso">
                                ${sucesso}
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </div>
                        <div class="col-md-6 marginLados0">
                            <div class="text-center">
                                <label>Suas Palavras:</label>
                            </div>
                             <ul class="list-group">
                                <c:forEach items="${list}" var="item">
                                    <li class="list-group-item list-group-item text-center">
                                        ${item.texto}
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="col-md-6 marginLados0">
                            <div class="text-center">
                                <label>Suas Palavras Invertidas:</label>
                            </div>
                            <ul class="list-group">
                                <c:forEach items="${list}" var="item">
                                    <li class="list-group-item list-group-item text-center">
                                        ${item.textoInvertido}
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
