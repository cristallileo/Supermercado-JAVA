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
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Productos</title>


  
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/cliente/productos.css" rel="stylesheet">
  
  <!-- Boton para aumentar o decrementar la cantidad de productos seleccionados -->
    
  	
  <%Persona per = (Persona)session.getAttribute("usuario");%>
  <% LinkedList<Producto> lprod = (LinkedList<Producto>)request.getAttribute("productos");
   	 LinkedList<Categoria> lc= (LinkedList<Categoria>)request.getAttribute("categorias");%>

</head>

<body>
 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
          <li class="nav-item">
            <a class="nav-link" href="#">Mis pedidos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="ListProductos">Productos</a>
             <span class="sr-only">(current)</span>
          </li>          
          <li class="nav-item">
            <a class="nav-link" href="#">Nosotros</a>
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
  
  <!-- Contenido de la página -->
  
<div class="container">

    <div class="row">
    
    <div class="col-lg-3">

        <h1 class="my-4">Shop Name</h1>
        <div class="list-group">
        	<%for(Categoria c:lc){ %>
        		<a href="BuscarCatAct?id=<%=c.getIdCategoria()%>"class="list-group-item"><%=c.getDescCategoria()%></a>
			<%}%>

        </div>

      </div>
      <!-- /.col-lg-3 -->


      <div class="col-lg-9">
		  <br>
        
        <div class="row">
		
		<%if(lprod.size() == 0){ %>   
		<br> 
		<br>
		<br>                   
		<div class="alert alert-warning" > ¡Lo sentimos! No hay productos con esta categoría  </div>                               	
		<%} %>
		
		<%for (Producto p: lprod){ %>
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#"><%=p.getDescProducto()%></a>
                </h4>
                <p class="card-text"><%=p.getMarca() %></p>
                <h5><%="$" + p.getPrecio() %></h5>
              </div>
              <div class="card-footer">
                <!-- ESPACIO PARA SELECCIONAR CANTIDAD DEL PRODUCTO -->
				  <input type="number" id="points" name="points" value="0" step="1" min="0" max="99">
				  <small class="btn btn-primary btn-sm" style="margin-left: 75px;">Añadir</small>
				</div>
				
				<!-- BOTON PAR AGREGAR AL CARRITO ESA CANTIDAD -->
        
              
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
  <!-- Footer -->
  <!-- Yo esto lo saque de la mainpage, decidir si se queda o se va -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
  </footer>
  
  
</body>

</html>