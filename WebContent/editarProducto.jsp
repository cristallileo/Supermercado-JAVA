<%@page import="Data.*" %>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar producto</title>

<!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
   <!--  <link href="style/login/login.css" rel="stylesheet"> -->
    
   <link href="style/login/login.css" rel="stylesheet">
  
<% Producto prod = (Producto)request.getAttribute("productoEditar");
%> 
</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage-admin.jsp">Supermercado</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item ">
            <a class="nav-link" href="mainpage-admin.jsp">Home
              
            </a>
          </li>
          <li class="nav-item">
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
          <li class="nav-item">
             <form action="Inicio" method="get">
              	<a class="nav-link" href="">Cerrar Sesión</a>
          	  </form>
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
              <h3 class="login-heading mb-4 text-center">Editar producto</h3>
              
              <form action="EditProducto?id=<%=prod.getIdProducto()%>" method="post">

                <div class="form-label-group">
                  <input type="text" name="descProd" id="inputDescProd" class="form-control" value=<%=prod.getDescProducto()%> required >
                  <label for="inputPorc">Descripcion</label>
                </div>

                <div class="form-label-group">
                  <input type="text" name="stock" id="inputStock" class="form-control" value=<%=prod.getStock()%> required>
                  <label for="inputFechai">Stock</label>
                </div>
				
				<div class="form-label-group">
                  <input type="text" name="stockMin" id="inputStockMin" class="form-control" value=<%=prod.getStockMinimo()%> required>
                  <label for="inputFechai">Stock Minimo</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="marca" id="inputMarca" class="form-control" value=<%=prod.getMarca()%> required>
                  <label for="inputFechaf">Marca</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="categ" id="inputCategoria" class="form-control" value=<%=prod.getId_categoria()%> required>
                  <label for="inputFechaf">ID Categoria</label>
                </div>

                <div class="form-label-group">
                  <input type="text" name="precio" id="inputPrecio" class="form-control" value=<%=prod.getPrecio()%> required>
                  <label for="inputFechaf">Precio</label>
                </div>
                
                	<button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Se editará el producto. Desea confirmar?')">Guardar cambios</button>
                
         
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


</body>
</html>
