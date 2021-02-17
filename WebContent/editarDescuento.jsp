<%@page import="Data.*" %>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar descuento</title>

<!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
   <!--  <link href="style/login/login.css" rel="stylesheet"> -->
    
   <link href="style/login/login.css" rel="stylesheet">
  
<% Descuento dcto = (Descuento)request.getAttribute("descuentoEditar");
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
            <a class="nav-link" href="categorias-admin.jsp">Categorías</a>
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
              <h3 class="login-heading mb-4 text-center">Editar descuento</h3>
              
              <form action="EditDescuento?id=<%=dcto.getIdDcto()%>" method="post">
               
                <div class="form-label-group">
                  <input type="text" name="porc" id="inputPorc" class="form-control" value=<%=dcto.getPorcDcto()%> required >
                  <label for="inputPorc">Porcentaje</label>
                </div>

                <div class="form-label-group">
                  <input type="text" name="fechaIni" id="inputFechai" class="form-control" value=<%=dcto.getFechaDctoInicio()%> required>
                  <label for="inputFechai">Fecha inicio</label>
                </div>
				
                <div class="form-label-group">
                  <input type="text" name="fechaFin" id="inputFechaf" class="form-control" value=<%=dcto.getFechaDctoFin() %> required>
                  <label for="inputFechaf">Fecha fin</label>
                </div>
                
                
                	<button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Se editará el descuento. Desea confirmar?')">Guardar cambios</button>
                
         
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