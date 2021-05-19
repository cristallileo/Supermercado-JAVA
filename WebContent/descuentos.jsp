<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.Date" %>
<%@page import="entidades.*"%>
<%@ page import="java.util.Calendar"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Home</title>

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">


<% LinkedList<Descuento> ld = (LinkedList<Descuento>)request.getAttribute("descuentos"); %>
<% Persona per = (Persona)session.getAttribute("usuario");
 Pedido pedido= (Pedido)request.getAttribute("pedido");%>

</head>
<body>

 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
  
          <li class="nav-item">
            <a class="nav-link" href="ListPedidos">Mis pedidos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="ListDescuentos">Descuentos</a> <!--  poner en un boton -->
            <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListProductos">Productos</a>
          </li>          
          <li class="nav-item">
            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
          </li>
       
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container bootstrap snippets bootdey">
    <!-- Heading Row -->
    <div class="row align-items-center my-5">
   
      <div class="col" align="center" >
        <h1 class="font-weight-light"><b>Ahora también disfrutar de nuestros descuentos.</b> </h1>
        <h2 class="font-weight-light"> Se aplica sobre el monto total </h2>
       <!--  <a class="btn btn-primary" href="#">Call to Action!</a>  -->
      </div>
    </div>
    
  	<div class="col-lg-12">
  		<div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>                                
                                <th align="center"><span>Porcentaje</span></th>
                                <th align="center"><span>Fecha Fin</span></th>                             
                                <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <% for (Descuento d : ld) { %>
	                    			<tr>	                    			
                                    <td><%=d.getPorcDcto()%></td>
                                    <td><%=d.getFechaDctoFin()%> </td>
                               <%} %>
                            </tbody>	
                        </table>
       
  	</div>
 
 <!-- ACA VA LAS CARDS (ERROR LD IS NULL) -->

</div>
</div>
</div>
</div>
  
</body>
</html>