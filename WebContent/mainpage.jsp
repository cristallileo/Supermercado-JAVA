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
            <a class="nav-link" href="#">Nosotros</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contactanos</a>
          </li>
          <li class="nav-item">
              <form action="Inicio" method="get">
              	<a class="nav-link" href="">Cerrar Sesi�n</a>
          	  </form>
          </li>
       
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="style/mainpage/6.jpg" alt="">
      </div>
      <!-- /.col-lg-8 -->
      <div class="col-lg-5 text-center" >
        <h1 class="font-weight-light"><b>Ahora tambi�n pod�s comprar online.</b> </h1>
        <p>La calidad de servicio de siempre, pero ahora desde la comodidad de tu casa. </p>
       <!--  <a class="btn btn-primary" href="#">Call to Action!</a>  -->
      </div>
      <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->

  <!-- Dcto cards--> 
  <form action="ListDescuentosCli"> 
    <div class="row">     
      <% for(Descuento d:ld){ %> 
      
	      <div class="col-md-4 mb-5">
	        <div class="card h-100" ">
	          <div class="card-body">
	            <h2 class="card-title">Descuento de: <%=d.getPorcDcto()*100%>%</h2>
	            <p class="card-text">La duraci�n es desde el <%=d.getFechaDctoInicio() %> hasta el <%=d.getFechaDctoFin()%>. <br> Esperamos que pueda aprovecharlo.</p>   
	         	</div>
	             <div class="card-footer">
	             <!-- aca estaba el boton de +info pero no hace falta poner nada -->
         		 </div>
	      	</div>
	      </div>
	     
	   <%} %>
     
    </div>
   </form>	
 </div>

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  
</body>
</html>