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
            <a class="nav-link" href="ListCategorias">Categor�as</a>
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
          <li class="nav-item ">
            <a class="nav-link" href="ingresarStock.jsp">Stock</a>
          </li>
          <li class="nav-item">            
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesi�n</a>          	           	 
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
        <p>Ahora pod�s ver las �ltimas novedades del negocio en un mismo lugar. </p>
      </div>
    </div>

    <div class="row">
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">Gesti�n de <br>
            Stock</h2>
            <%ProductoController ct = new ProductoController();
            int cantidad = ct.contarBajoStock();%>
            <p class="card-text">Productos que alcanzaron stock m�nimo: <b><%=cantidad %></b></p>
  
          </div>
          <div class="card-footer">
            <a href="ListBajoStock" class="btn btn-primary btn-sm">Ver m�s</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
          <%PedidoController con = new PedidoController();
          int cant_peds = con.contarPendientes();%>
            <h2 class="card-title">Gesti�n de Pedidos</h2>
            <p class="card-text">Pedidos pendientes de envio: <b><%=cant_peds %></b></p>
            <p></p>
          </div>
          <div class="card-footer">
            <a href="ListPedidosPendientes" class="btn btn-primary btn-sm">Ver m�s</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->

    </div>
    <!-- /.row -->

  </div>
  

  
</body>
</html>