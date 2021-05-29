<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  <link href="style/login/login.css" rel="stylesheet">

<title>Edición de Pedido</title>

<%Pedido p = (Pedido)request.getAttribute("pedidoEditar"); %>
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
          <li class="nav-item ">
            <a class="nav-link" href="ListDescuentos">Descuentos</a>
           
          </li>
          <li class="nav-item ">
	            <a class="nav-link" href="ListClientes">Clientes</a>
	             
          </li>
          <li class="nav-item">
             <a class="nav-link" href="ListEmpleados">Empleados</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="ListProductos">Productos</a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="ListPedidos">Pedidos</a>
      
              <li class="nav-item ">
            <a class="nav-link" href="ListProveedores">Proveedores</a>
       
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
            <form action="EditPedido?id=<%=p.getIdPedido()%>" method="post">
              <h3 class="login-heading mb-4 text-center">Editar Pedido</h3>
                 
  				<%String est= p.getEstado();
				if(est.equals("Confirmado")){ %>
				
				<label for="estado1">Estado</label>
  				<select id="estado1" name="estado1">
  					<option value="Confirmado">Confirmado</option>
  					<option value="Despachado">Despachado</option>
  					<option value="Entregado">Entregado</option>
  				</select>
  				<%}else if (est.equals("Despachado")) {%>
  				
  				<label for="estado2">Estado</label>
  				<select id="estado2" name="estado2">
  					<option value="Despachado">Despachado</option>
  					<option value="Entregado">Entregado</option>
  					<option value="Confirmado">Confirmado</option>
  				</select>
  				
                <div class="form-label-group">
                  <input type="date" name="fechaenvio" id="fechaenvio" class="form-control" placeholder="dd/mm/yyyy" required >
                  <label for="fechaenvio">Fecha de Entrega</label>
                </div>
                
  				<%} %>
                
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Se editará el estado de este pedido. Desea confirmar?')">Confirmar</button>
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