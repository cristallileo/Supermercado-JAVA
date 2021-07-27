<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.Date" %>
<%@page import="java.util.Base64"%>
<%@page import="entidades.*"%>
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
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  
  <link rel="stylesheet" href="style/filtros.css">
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
    <%Persona per = (Persona)session.getAttribute("usuario");
    LinkedList<LineaDePedido> lp= (LinkedList<LineaDePedido>)request.getAttribute("lineas");
    ProductoController ctrlProd= new ProductoController();
    Pedido ped= (Pedido)request.getSession(true).getAttribute("pedido");
    String mje= (String)request.getAttribute("mensaje");
    Boolean prod_eliminado= (Boolean)request.getAttribute("prod_eliminado");
    //Producto prodEditar = (Producto)request.getAttribute("prodEditar");
	%>
  
</head>
<body>

 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
   <button class="w3-button w3-dark-gray w3-large" onclick="w3_open()">&#9776;</button>
    <div class="container">
      <a class="navbar-brand" href="ListDescuentos">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
          <li class="nav-item">
            <a class="nav-link" href="ListPedidos">Mis pedidos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListProductos">Productos</a>
          </li>          
          <li class="nav-item">
            <a class="nav-link" href="contacto.jsp">Contacto</a>
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
   <div class="col-lg-9"> 

    
  <!-- Si no hay productos en el carrito aun -->
  <%if(lp.size()==0){%>
 	<div class="alert alert-danger alert-dismissible  center-block">
    	<a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
   	    <strong>Aún no hay productos.</strong>  Seleccione los productos y podrá consultar su pedido en esta sección.<a href="ListProductos"><b> Volver</b></a>
  </div>
  <%}else if (lp.size()>=1 && prod_eliminado==true){%>
	<div class="alert alert-success alert-dismissible " >
	<a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    <strong>Producto eliminado con éxito!</strong> El producto se ha retirado del carrito.
</div>

<%} %>
</div>
    
    <div class="col-lg-11">
	<br>
    <div class="row">
	<!-- DESCRIPCION -->
	<%if (lp.size()!=0){ %>
		<div class="w3-container">
		    <div class="w3-panel w3-leftbar w3-sand w3-large w3-serif" >
   			 <p>Código de Pedido: <%=ped.getIdPedido()%></p>
		    <p>Subtotal: $<%=ped.getPrecioTotal()%></p>
  			</div>
				
		  </div>	
    <%} %>	
		<!-- BOTON Cancelar -->
		
		
		<!-- BOTON CONFIRMAR -->
	<%if (lp.size()!=0){ %>
	
	<form action="CancelarPedido" method="post">
		 <button class="btn btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2 " type="submit" style="margin:10px;max-width:200px;height:50px;position: absolute; right: 210px;" onclick="return confirm('Se cancelará el pedido. Desea confirmar?')">Cancelar pedido</button>
  	</form>
	<form action="pedirDireccion.jsp" method="post">
		 <button class="btn btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" style="margin:10px;max-width:200px;height:50px;position: absolute;
  right: 0;">Confirmar pedido</button>
  	</form>
  	<%}%>
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
	            <div class="card-img-top">
	              <a ><img class="card-img-top" src="data:image/png;base64,<%=imag%>"/></a>
	              <!-- a><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a-->   
	            </div>


	             <div class="card-body">
	                <h4 class="card-title">
	                  <a><b><%=prod.getDescProducto()%></b></a>
	                </h4>
	                <p class="card-text"><%=prod.getMarca() %></p>
	                <h5><b><%="$" + prod.getPrecio() %></b></h5>
	              </div>
				<form action="QuitarProducto">
	              <div class="card-footer">
	                <!-- ESPACIO PARA SELECCIONAR CANTIDAD DEL PRODUCTO -->
					  <input type="text" id="cant" name="cant" value="<%=linea.getCantidad()%>" disabled >
					  <input   type="hidden" id="idProd" name="idProd" value="<%=prod.getIdProducto()%>"  >
					  <!-- PARA EDITAR step="1" min="0" max="99" -->
					  <button class="btn btn-primary btn-sm" type="submit" style="margin-left: 125px;">Eliminar</button>
			
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