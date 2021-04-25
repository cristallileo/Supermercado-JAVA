<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Error</title>


  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">

<style>

	.masthead {
	 
	font-family: Arial, Helvetica, sans-serif;
  height: 100vh;
  min-height: 500px;
  background-color: #FFFFFF;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}
	h1, .h1 {
	  font-size: 4em;
	}

	
</style>
  
</head>
<body>

<div class="container">
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage-admin.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">

          <li class="nav-item ">
            <a class="nav-link" href="ListCategorias">Categorías</a>
                  
          </li>
          <li class="nav-item">
           <a class="nav-link" href="ListDescuentos">Descuentos</a>
          </li>
          <li class="nav-item ">
	            <a class="nav-link" href="ListClientes">Clientes</a>	            
          </li>
          <li class="nav-item ">
	            <a class="nav-link" href="ListEmpleados">Empleados</a>	             
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
  </div>

  <!-- Page Content -->


<!-- Full Page Image Header with Vertically Centered Content -->
  <header class="masthead">
  <div class="container h-100">
    <div class="row h-50 align-items-center">
      <div class="col-12 text-center">
        <p style="font-size:30px;" class="lead">Este producto pertenece a una categoría inactiva.</p>
        <p style="font-size:20px;" class="lead">Reactive esta categoría o reasigne el producto a otra.</p>
 		<a href="ListProductos" class="btn btn-info" role="button">Volver</a>
      </div>
    </div>
  </div>
</header>
  
  
  
  
</body>
</html>