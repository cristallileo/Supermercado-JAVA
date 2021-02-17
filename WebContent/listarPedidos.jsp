<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
 <!-- Estilo para el listado de clientes -->
 <link href="style/clientes-admin/listado-clientes.css" rel="stylesheet">
 
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
 
     <!-- Custom styles for this template -->
  <link href="style/clientes-admin/confirmacion.css" rel="stylesheet">
  
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  
<title>Pedidos</title>

<% LinkedList<Pedido> lp = (LinkedList<Pedido>)request.getAttribute("pedidos");
%>

</head>
<body>

<!-- Page Content -->
  <div class="container">
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
          <li class="nav-item ">
            <a class="nav-link" href="ListDescuentos">Descuentos</a>
           
          </li>
          <li class="nav-item ">
	            <a class="nav-link" href="ListClientes">Clientes</a>
	             
          </li>
          <li class="nav-item">
             <a class="nav-link" href="ListEmpleados">Empleados</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="ListPedidos">Pedidos</a>
             <span class="sr-only">(current)</span>
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
  </div>
  
 <hr> 
 <div class="container bootstrap snippets bootdey">
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th align="center"><span>ID</span></th>
                                <th align="center"><span>Fecha</span></th>
                                <th align="center"><span>Precio Total</span></th>
                                <th align="center"><span>Fecha Entrega</span></th>
                                <th align="center"><span>Dirección Envío</span></th>
                                <th align="center"><span>Estado</span></th>
                                <th align="center"><span>ID Cliente</span></th>
                                <th align="center"><span>ID Descuento</span></th>
                                
                               
                               
                                <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <% for (Pedido p: lp) { %>
	                    			<tr>
	                    			<td><%=p.getIdPedido()%></td>
                                    <td><%=p.getFechaPedido()%></td>
                                    <td><%=p.getPrecioTotal()%></td>
                                    <td><%=p.getFechaEntrega()%> </td>
                                    <td><%=p.getDireccionEnvio()%> </td>
                                    <td><%=p.getEstado()%> </td>
                                    <td><%=p.getId_persona()%> </td>
                                    <td><%=p.getId_dcto()%> </td>
       
                                     <td style="width: 10%;">
                                        
                                        <a href="EditPedido?id=<%=p.getIdPedido()%>" class="table-link text-info">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                        <a  href="DeletePedido?id=<%=p.getIdPedido()%>" class="table-link danger" onclick="return confirm('Desea eliminar este pedido?');" >
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                            </span>
                                            
                                        </a>
                                    
                                    </td>
                                   
    
	                    		</tr>
	                    		   
	                    		
	                    		<% } %>
	                    		
                    		</tbody>	
                        </table>
                    </div>
                </div>
            </div>
            <span style="text-align: right; vertical-align: bottom;">
            <form action="AddPedido" method=post">
					<div class="w3-container">	 
						<button class="w3-button w3-xlarge w3-circle w3-teal" type="submit" >+</button>
						<a href="AddClientes"> Agregar pedido</a>
					</div>
			</form>
			</span>
        </div>
    </div>
</div>

</body>
</html>