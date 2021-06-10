<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Contactanos</title>

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">  
  <link href="style/login/login.css" rel="stylesheet">
  
  <%   Persona per = (Persona)session.getAttribute("usuario"); %>
  
  <style>
  textarea {
  overflow: auto;
	}
  </style>
   
</head>
<body>

 <!-- Navigation -->
	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	    <div class="container">
	      <a class="navbar-brand" href="index.jsp">Supermercado</a>
	      <div class="collapse navbar-collapse" id="navbarResponsive">
	        <ul class="navbar-nav ml-auto">
	           <li class="nav-item ">
	            <a class="nav-link" href="login.jsp">Iniciar Sesión </a>
          	   </li>
	          <li class="nav-item ">
	            <a class="nav-link" href="registro.jsp">Registrarse</a>
	          </li>
	          <li class="nav-item active">
	           <a class="nav-link" href="consulta.jsp">Contacto</a>
	          	<span class="sr-only">(current)</span>
	          </li>
	        </ul>
	      </div>
	    </div>
	  </nav>
  
	  
<div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto ">
              <h3 class="login-heading mb-4 text-center">Contactanos</h3>
              
              <form action="#" method="post">
               <!--  <div class="form-label-group">
                  <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Correo electrónico" required >
                  <label for="inputEmail">Correo electrónico</label>
                </div>-->
                
                <div class="form-label-group">
                  <input type="text" name="mail" id="mail" class="form-control" placeholder="Asunto" required >
                  <label for="mail">Correo electrónico</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="asunto" id="asunto" class="form-control" placeholder="Asunto" required >
                  <label for="asunto">Asunto</label>
                </div>

			  <label for="mensaje">Mensaje</label>
			  <textarea id="mensaje" name="mensaje" class="form-control" rows="5" cols="50" placeholder="Dejá tu consulta aquí." required>
			  </textarea>           
			  <br>  
              <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Enviar</button>
                
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>