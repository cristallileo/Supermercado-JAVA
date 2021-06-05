<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  <link href="style/login/login.css" rel="stylesheet">
   
<title>Alta Producto</title>
<% 
LinkedList<Categoria> lc= (LinkedList<Categoria>)request.getAttribute("categorias");
%>
</head>
<body>
  <div class="container">
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
          <li class="nav-item ">
	            <a class="nav-link" href="ListClientes">Clientes</a>
	             
          </li>
                     <li class="nav-item">
             <a class="nav-link" href="ListEmpleados">Empleados</a>
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
  <div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto ">
              <h3 class="login-heading mb-4 text-center">Nuevo Producto</h3>
              
  				<form action="AddProducto" method="post" enctype="multipart/form-data">
  				
  				<div class="form-label-group">
                  <input type="text" name="descProd" id="descProd" class="form-control" placeholder="Descripcion" required >
                  <label for="descProd">Descripción</label>
                </div>
                
                <label for="id_cateogria">Categoría</label>
  				<select id="id_categoria" name="id_categoria">
  				 <% for (Categoria c: lc) {%> 				 
   						<option value="<%= c.getIdCategoria() %>"><%= c.getDescCategoria()  %></option>
   				<% } %> 
  				</select> 

                <div class="form-label-group">
                  <input type="text" name="stock" id="stock" class="form-control" placeholder="Stock" required>
                  <label for="stock">Stock</label>
                </div>
				
				<div class="form-label-group">
                  <input type="text" name="stockMin" id="stockMin" class="form-control" placeholder="Stock Minimo" required>
                  <label for="stockMin">Stock Mínimo</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="marca" id="marca" class="form-control" placeholder="Marca" required>
                  <label for="marca">Marca</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="precio" id="precio" class="form-control" placeholder="Precio"  required>
                  <label for="precio">Precio</label>
                </div>
                
                <div class="form-group">
				  <label for="foto">Subir Imagen</label>  
				  <div class="col-md-12">
				  <input id="foto" name="foto" type="file" class="form-control input-md" required>
				  </div>
				</div>
                
            	<form action="AddProducto" method="post">
    				<button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Se agregará un nuevo producto. Desea confirmar?')">Agregar</button>
 				</form> 
 				                
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
