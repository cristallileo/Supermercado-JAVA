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
            <a class="nav-link" href="descuentos.jsp">Descuentos</a> 
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListProductos">Productos</a>
             
          </li>          
          <li class="nav-item ">
            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
            
          </li>
          <li class="nav-item">
              <form action="Inicio" method="get">
              	<a class="nav-link" href="">Cerrar Sesión</a>
          	  </form>
          </li>
       
        </ul>
      </div>
    </div>
  </nav>
</body>
</html>