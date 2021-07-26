<%@page import="Data.*" %>
<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingresar stoc</title>

<!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
   <!--  <link href="style/login/login.css" rel="stylesheet"> -->
    
   <link href="style/login/login.css" rel="stylesheet">
  
  
  <%Producto prod = (Producto)request.getAttribute("prod");
	LinkedList<Proveedor> lprov = (LinkedList<Proveedor>)request.getAttribute("proveedores");%>
  
</head>
<body>
<!-- Navigation -->
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

  
  <div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">

            <div class="col-md-9 col-lg-8 mx-auto ">
              <h3 class="login-heading mb-4 text-center">Ingresar stock</h3>

            
				<form action="IngresarStock" method="post" >
				
	               <div class="form-label-group">
	                  <input type="text" name="desc" id="desc" class="form-control" value="<%=prod.getDescProducto() %>" placeholder="Producto" disabled >
	                  <label for="desc">Producto</label>
	              </div>
	              <div class="form-label-group">
                 	 <input type="text" name="stock" id="stock" class="form-control" placeholder="Cantidad" required autocomplete="off">
	                  <label for="stock">Cantidad a ingresar</label>
                  </div>
                  <label for="prov">Proveedor</label>
	  				<select id="prov" name="prov" required>
	  				 <% for (Proveedor p: lprov) { %> 				 
	   					<option value="<%=p.getIdProveedor()%>"><%=p.getRazonSocial()%></option>
	   				<% } %> 
  				</select> 
  				
                  <div class="form-label-group">
	                  <input type="hidden" name="id" id="id" value="<%=prod.getIdProducto() %>" class="form-control"  >
	              </div>
                
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Guardar</button>
               
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