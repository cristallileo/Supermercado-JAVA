<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.Date" %>
<%@page import="entidades.*"%>
<%@ page import="java.util.Calendar"%>
<%@page import="java.util.Base64"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito de Compras</title>

 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	
  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
 <!-- Estilo para el listado de clientes -->
 <link href="style/clientes-admin/listado-clientes.css" rel="stylesheet">
 
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
 
     <!-- Custom styles for this template -->
     
      <link href="style/login/login.css" rel="stylesheet">
  <link href="style/clientes-admin/confirmacion.css" rel="stylesheet">
  
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  
  <link rel="stylesheet" href="style/filtros.css">
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
    <%Persona per = (Persona)session.getAttribute("usuario");
    LinkedList<LineaDePedido> lp= new LinkedList<LineaDePedido>();
    lp=(LinkedList<LineaDePedido>)request.getAttribute("lineas");
    ProductoController ctrlProd= new ProductoController();
    Pedido ped= new Pedido();
	ped= (Pedido)request.getSession(true).getAttribute("pedido");
	String descrip= null;
	%>
  
</head>
<body>

 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
   <button class="w3-button w3-dark-gray w3-large" onclick="w3_open()">&#9776;</button>
    <div class="container">
      <a class="navbar-brand" href="mainpage.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
          <li class="nav-item">
            <a class="nav-link" href="mis-pedidos.jsp">Mis pedidos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListDescuentos">Descuentos</a> <!--  poner en un boton -->
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
  
  <!-- Contenido de la página -->
  
<div class="container">
  <div class="row">
    <div class="col-lg-3">
      <br>
      <div class="list-group">
      </div>
    </div>
    <!-- /.col-lg-3 -->
    <div class="col-lg-11">
	  <br>
      <div class="row">
		<form class="example" action="ListProductosDesc" style="margin:10px;max-width:300px">
		  <%if (descrip==null){ %>
		  	<input type="text" placeholder="Descripción..." name="search" autocomplete="off" disabled>
		  		<%}%>
		  	<button type="submit"><i class="fa fa-search"></i></button>
		</form>
		<!-- BOTON CONFIRMAR -->
		<form action="pedirDireccion.jsp" method="post">
		 	<button class="btn btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" style="margin:10px;max-width:200px;height:50px;position: absolute;
 			 right: 0;">Confirmar pedido</button>
  		</form>
  	 </div>
	 <!-- CARDS -->
	 <div class="row">
		<%for (LineaDePedido linea: lp){
		      Producto prod= new Producto();
		      prod.setIdProducto(linea.getId_producto());
		      prod= ctrlProd.getById(prod);
		      String imag=Base64.getEncoder().encodeToString(prod.getImagen());
		      %>
	          <div class="col-lg-3 col-md-6 mb-4">
	            <div class="card h-100">
	              
                  <a ><img class="card-img-top" src="data:image/png;base64,<%=imag%>"/></a>
	              <!-- a href><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a-->

	              <div class="card-body">
	                <h4 class="card-title">
	                  <a><b><%=prod.getDescProducto()%></b></a>
	                </h4>
	                <p class="card-text"><%=prod.getMarca() %></p>
	                <h5><b><%="$" + prod.getPrecio() %></b></h5>
	              </div>
               
				  <form action="EditCarrito?idProd=<%=linea.getId_producto()%>" method="post">
		             <div class="card-footer">
		                <!-- ESPACIO PARA SELECCIONAR CANTIDAD DEL PRODUCTO -->
						<input type="text" id="cant" name="cant" value="<%=linea.getCantidad()%>" step="1" min="0" max="99" disabled>
						<!-- PARA EDITAR step="1" min="0" max="99" -->
						<br>
						<br>
						<button class="btn btn-primary btn-sm" type="submit" style="margin-left: 125px;">Editar</button>
					 </div>
				  </form>
			   </div>
	         </div>
        <%} %>
        </div>
        <!-- /.row -->
      </div>
      <!-- /.col-lg-9 -->
    </div>
    <!-- /.row -->
  </div>
  <!-- /.container -->
<br>
  
</body>
</html>