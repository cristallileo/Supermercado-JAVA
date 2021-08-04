<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@page import="java.util.List"%> 
<%@page import="java.util.Collections"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
	<link href="style/mainpage/modern-business.css" rel="stylesheet">
  	<!-- Estilo para el listado de clientes -->
 	<link href="style/clientes-admin/listado-clientes.css" rel="stylesheet">
 	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	<link href="style/login/login.css" rel="stylesheet">
 
	<title>Pedido</title>

	<% LinkedList<LineaDePedido> lineas = (LinkedList<LineaDePedido>)request.getAttribute("lineas");

	%>

</head>

<body style="padding-top: 87px;">
   <div class="container">
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
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
          <li class="nav-item active">
            <a class="nav-link" href="ListPedidos">Pedidos</a>
             <span class="sr-only">(current)</span>
              <li class="nav-item ">
            <a class="nav-link" href="ListProveedores">Proveedores</a>
          <li class="nav-item ">
            <a class="nav-link" href="ingresarStock.jsp">Stock</a>
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  </div>
  
  <hr> 
  <div class="container bootstrap snippets bootdey"> 

	<!--  TABLA -->	
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th align="center"><span>ID Producto</span></th>
                                 <th align="center"><span>Descripción Producto</span></th>
                                <th align="center"><span>Cantidad</span></th>
                               
        
                                <th >&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <% for (LineaDePedido l: lineas) { 
	                        	   Producto p= new Producto();
	                        	   ProductoController ctrlp= new ProductoController();
	                        	   p.setIdProducto(l.getId_producto());
	                        	   p=ctrlp.getById(p);
                    			 %>
	                    			<tr>
	                    			<td><%=p.getIdProducto()%></td>
	                    			<td><%=p.getDescProducto() %></td>
	                    			<td><%=l.getCantidad()%></td>
	                    			
	                    		</tr>
	                    		<% } %>
	                    		
                    		</tbody>	
                        </table>
                    </div>
                </div>
            </div>
                        
            
          
        </div>
    </div>
</div>

</body>
</html>