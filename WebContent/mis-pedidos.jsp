<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.Date" %>
<%@page import="entidades.*"%>
<%@ page import="java.util.Calendar"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Mis pedidos</title>

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


  <%Persona per = (Persona)session.getAttribute("usuario");
		  String mje= (String)request.getAttribute("mensaje");
	//Pedido pedido= (Pedido)request.getAttribute("pedido");
  %>

</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
          <li class="nav-item active">
            <a class="nav-link" href="mis-pedidos.jsp">Mis pedidos</a> <!--  poner en un boton -->
            <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListDescuentos">Descuentos</a> 
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListProductos">Productos</a>
             
          </li>          
          <li class="nav-item ">
            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
            
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
          </li>
       
        </ul>
      </div>
    </div>
  </nav>
  
  <div class="container">

    <div class="row">
    
  
  
  <!-- Si viene de confirmar un pedido: -->
  <%if(mje!=null){%>
 	<div class="alert alert-success alert-dismissible  center-block">
    	<a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
   	    <strong>Su pedido ha sido registrado con éxito.</strong> En esta sección podrá consultar el estado del mismo.
  </div>
  <%} else {%>
  <p>desarrollar contenido</p>
  <%} %>
 
  </div>
  </div>
  
</body>
</html>