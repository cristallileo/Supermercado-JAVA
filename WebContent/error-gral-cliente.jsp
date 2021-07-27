<%@page import="entidades.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Error</title>

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">  
  <link href="style/login/login.css" rel="stylesheet">
   
   <% Persona per= (Persona)request.getSession(true).getAttribute("usuario");
   if(per==null){
		request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
   } 
   %>
</head>
<body>

 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="ListDescuentos">Supermercado</a>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="ListPedidos">Mis pedidos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListProductos">Productos</a>
          </li>   
          <li class="nav-item ">
            <a class="nav-link" href="BuscarCliente?id=<%=per.getIdPersona()%>">Mi cuenta</a>
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
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
            <div class="col-md-9 col-lg-8 mx-auto text-center ">
              <h3 class="login-heading mb-4 text-center">Algo salió mal.</h3>
              <a href="ListDescuentos"  style="text-align:center;">Volver</a>
          
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>