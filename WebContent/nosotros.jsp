<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Sobre nosotros</title>

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">

  
  <% Persona per = (Persona)session.getAttribute("usuario");
  Pedido pedido= (Pedido)request.getAttribute("pedido");%>


</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
          <li class="nav-item">
            <a class="nav-link" href="mis-pedidos.jsp">Mis pedidos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="descuentos.jsp">Descuentos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListProductos">Productos</a>
             
          </li>          
          <li class="nav-item active">
            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
            <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
          </li>
       
        </ul>
      </div>
    </div>
  </nav>
  
<div class="container">
<!-- 
 <div class="row align-items-center my-5">
    <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="style/nosotrs/nos1_a.jpg" alt="">
    </div>   
    <div class="col-lg-5 text-center" >
    	<img class="img-fluid rounded mb-4 mb-lg-0" src="style/nosotrs/nos1_b.jpg" alt="">
	</div>
  </div>
</div>
 <div class="row align-items-center my-5">
    <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="style/nosotrs/nos3.jpg" alt="">
    </div>   
    <div class="col-lg-5 text-center" >
    	<img class="img-fluid rounded mb-4 mb-lg-0" src="style/nosotrs/nos2.jpg" alt="">
	</div>
  </div>-->
</div>
  
</body>
</html>