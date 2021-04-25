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
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Home</title>

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">


<% // LinkedList<Descuento> ld = (LinkedList<Descuento>)request.getAttribute("descuentos"); %>
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
            <a class="nav-link" href="ListDescuentos">Descuentos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListProductos">Productos</a>
          </li>          
          <li class="nav-item">
            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="style/mainpage/6.jpg" alt="">
      </div>
      <!-- /.col-lg-8 -->
      <div class="col-lg-5 text-center" >
        <h1 class="font-weight-light"><b>Ahora también podés comprar online.</b> </h1>
        <p>La calidad de servicio de siempre, pero ahora desde la comodidad de tu casa. </p>
       <!--  <a class="btn btn-primary" href="#">Call to Action!</a>  -->
      </div>
      <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->
    

</div>

  
</body>
</html>