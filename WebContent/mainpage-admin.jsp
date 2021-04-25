<%@page import="entidades.*" %>
<%@page import="logic.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Home</title>

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
 
  <%Persona per = (Persona)session.getAttribute("usuario");%>
  
</head>
<body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage-admin.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">

          <li class="nav-item">
            <a class="nav-link" href="ListCategorias">Categorías</a>
          </li>
		  <li class="nav-item">
            <a class="nav-link" href="ListDescuentos">Descuentos</a>
          </li>
          <li class="nav-item">
	        <a  href="ListClientes" class="nav-link">Clientes</a>
          </li>
          <li class="nav-item">
	         <a  href="ListEmpleados" class="nav-link">Empleados</a>         
          </li> 
          <li class="nav-item">
              <a class="nav-link" href="ListProductos">Productos</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="ListPedidos">Pedidos</a>
          </li>
           <li class="nav-item ">
            <a class="nav-link" href="ListProveedores">Proveedores</a>
          </li>
          <li class="nav-item">            
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>          	           	 
          </li>
          
        </ul>
      </div>
    </div>
  </nav>
  
  <div class="container">
    <div class="row align-items-center my-5">
      <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="style/mainpage/6.jpg" alt="">
      </div>

      <div class="col-lg-5 text-center" >
        <h1 class="font-weight-light"><b>Bienvenido!</b> </h1>
        <p>Ahora podés ver las últimas novedades del negocio en un mismo lugar. </p>
      </div>
    </div>

    <div class="row">
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">Gestión de Descuentos</h2>
            <%DescuentoController ctrl = new DescuentoController();
            int cant=ctrl.contarDctos();%>
            <p class="card-text">Descuentos activos actualmente: <b><%=cant %></b></p>
          </div>
          <div class="card-footer">
            <a href="ListDescuentos" class="btn btn-primary btn-sm">Ver más</a>
          </div>
        </div>
      </div>
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">Gestión de <br>
            Stock</h2>
            <p class="card-text">Productos que alcanzaron stock mínimo: <b>0</b></p>
  
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary btn-sm">Ver más</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">Gestión de Pedidos</h2>
            <p class="card-text">Pedidos pendientes de envio: <b>0</b></p>
            <p></p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary btn-sm">Ver más</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->

    </div>
    <!-- /.row -->

  </div>
  

  
</body>
</html>