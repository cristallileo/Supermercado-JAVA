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

<title>Descuentos</title>

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">  

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">

  <style>
  
	.masthead {
	 
  font-family: Arial, Helvetica, sans-serif;
  height: 100vh;
  min-height: 500px;
  background-image: url('style/login/1.jpg');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  
  
}
	h1, .h1 {
	  font-size: 4em;
	}
	
	
</style>


<% LinkedList<Descuento> ld = (LinkedList<Descuento>)request.getAttribute("descuentos");
//java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
%>

</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage-admin.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
          <li class="nav-item">
            <a class="nav-link" href="#">Mis pedidos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Productos</a>
          </li>          
          <li class="nav-item">
            <a class="nav-link" href="#">Descuentos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Nosotros</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contactanos</a>
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


<!-- Page Content -->

<!-- Full Page Image Header with Vertically Centered Content -->
<header class="masthead">
  <div class="container h-100">
    <div class="row h-50 align-items-center">
      <div class="col-12 text-center">
       <b><h1  class="font-weight-light">Descuentos</h1></b>
        ¡Conozca nuestros descuentos disponibles y disfrutelos !	
      </div>
    </div>
    
  <!-- Cards-->
  <form action="ListDescuentosCli">
  	<!-- div class="row"-->
	   <%//if(ld.size() == 0){
		 for(Descuento d:ld){ %> 
		
	      <div class="col-md-4 mb-5">
	        <div class="card h-100">
	          <div class="card-body">
	            <h2 class="card-title">Descuento de: <%=d.getPorcDcto()*100%>%</h2>
	            <p class="card-text">La duración es desde el <%=d.getFechaDctoInicio() %> hasta el <%=d.getFechaDctoFin()%>. <br> Esperamos que pueda aprovecharlo.</p>   
	         	</div>
	             <div class="card-footer">
	             <!-- aca estaba el boton de +info pero no hace falta poner nada -->
         		 </div>
	      	</div>
	      </div>
	      
	   <%} //} %>
 
  
	<!-- /div -->
  </form>
    

  </div>
</header>

   










</body>
</html>