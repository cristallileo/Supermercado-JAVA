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

<title>Mis pedidos</title>

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
  <link href="style/cliente/mis-pedidos.css" rel="stylesheet">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


  <%Persona per = (Persona)session.getAttribute("usuario");
    String mje= (String)request.getAttribute("mensaje");
	Pedido ped= (Pedido)session.getAttribute("pedido");
	LinkedList<Pedido> lp = (LinkedList<Pedido>)request.getAttribute("pedidos");
  %>

</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
          <li class="nav-item active">
            <a class="nav-link" href="ListPedidos">Mis pedidos</a> <!--  poner en un boton -->
            <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListDescuentos">Descuentos</a> 
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListProductos">Productos</a>
             
          </li>          
          <li class="nav-item ">
            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
            
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
          </li>
       
        </ul>
      </div>
    </div>
  </nav>
  
  <div class="container">
    <div class="row">
 
  <!-- Si viene de confirmar un pedido: -->
  <%if(mje!=null){%>
 	<div class="alert alert-success alert-dismissible  center-block">
    	<a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
   	    <strong>Su pedido ha sido registrado con éxito.</strong> En esta sección podrá consultar el estado del mismo.
  </div>
  <%}%>
  </div>
  <%for (Pedido p: lp){%>
  			<div class="col-lg-4">
	        <div class="card card-margin">
	            <div class="card-header no-border">
	            </div>
	            <div class="card-body pt-0">
	                <div class="widget-49">
	                    <div class="widget-49-title-wrapper">
	                        <div class="widget-49-date-primary">
	                            <span class="widget-49-date-day"><%=p.getFechaPedido()%></span>
	                            <span class="widget-49-date-month">apr</span>
	                        </div>
	                        <div class="widget-49-meeting-info">
	                            <span class="widget-49-pro-title"></span>
	                            <span class="widget-49-meeting-time"><%=p.getIdPedido()%></span>
	                        </div>
	                    </div>
	                    <ol class="widget-49-meeting-points">
	                        <li class="widget-49-meeting-item"><span>Estado: <%=p.getEstado() %></span></li>
	                        <li class="widget-49-meeting-item"><span><%=p.getDireccionEnvio() %></span></li>
	                        <li class="widget-49-meeting-item"><span>Session timeout increase to 30 minutes</span></li>
	                    </ol>
	                    <div class="widget-49-meeting-action">
	                        <a href="#" class="btn btn-sm btn-flash-border-primary">Ver más</a>
	                    </div>
	                </div>
	            </div>
	     </div>
	 </div>
	   <%} %>
 

</div>

  
	
  
</body>
</html>