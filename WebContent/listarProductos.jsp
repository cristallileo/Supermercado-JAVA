<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
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
  	<link rel="stylesheet" href="style/filtros.css">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	<link href="style/login/login.css" rel="stylesheet">
 
	<title>Productos</title>

	<% LinkedList<Producto> lprod = (LinkedList<Producto>)request.getAttribute("productos");
   LinkedList<Categoria> lc= (LinkedList<Categoria>)request.getAttribute("categorias");
   String desc= (String)request.getAttribute("descrip");
   //String desc= request.getAttribute("descripcion");
	%>

	<script>
		function w3_open() {
  			document.getElementById("mySidebar").style.display = "block";
  			document.getElementById("myOverlay").style.display = "block";
		}

		function w3_close() {
 			document.getElementById("mySidebar").style.display = "none";
  			document.getElementById("myOverlay").style.display = "none";
		}
	</script>
</head>

<body>

	<!-- Sidebar -->
	<div class="w3-sidebar w3-bar-block" style="display:none;z-index:5" id="mySidebar">
	  <button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Cerrar &times;</button>
	  	 
	  	<div class="w3-dropdown-hover">
	  	  <button class="w3-button w3-gray">Precio</button>
		    <div class="w3-dropdown-content w3-bar-block w3-border">
		     <a class="w3-bar-item w3-button" href="ListProductosMenosMas">De menor a mayor precio</a>
			 <a class="w3-bar-item w3-button" href="ListProductosMasMenos">De mayor a menor precio</a>
	    	</div>
	    </div>
	  	<div class="w3-dropdown-hover">
	    	<button class="w3-button w3-gray">Categoria</button>
		    <div class="w3-dropdown-content w3-bar-block w3-border">
		     <a class="w3-bar-item w3-button" href="ListProductos">Todos</a>
			    <% for (Categoria c: lc) { %>
			      <a class="w3-bar-item w3-button" href="BuscarCat?id=<%=c.getIdCategoria()%>"><%=c.getDescCategoria()%></a>
			  	 <%} %>
    		</div>
  		</div>
	  <!-- <a href="#" class="w3-bar-item w3-button">Link 3</a>-->
	  <div class="w3-dropdown-hover">
		     <a class="w3-button w3-gray" href="ListBajoStock">Stock Bajo</a>
	    </div>
	</div>

 	<!-- Page Content -->
  	<div class="container">
  	
 		<!-- Navigation -->
  		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
   		<button class="w3-button w3-dark-gray w3-large" onclick="w3_open()">&#9776;</button>
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
          <li class="nav-item active">
              <a class="nav-link" href="ListProductos">Productos</a>
                <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="ListPedidos">Pedidos</a>
          </li>
           <li class="nav-item ">
            <a class="nav-link" href="ListProveedores">Proveedores</a>
          </li>
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
  	<div class="row">
	
  	
		<!-- SEARCH -->
		<!-- DESCRIPCION -->
		<div class="col">
				<form class="example" action="ListProductosDesc" style="margin:10px;max-width:300px">
	  				<%if (desc==null){ %>
	 					<input type="text" placeholder="Descripción..." name="search" autocomplete="off">
	  				<%}else{ %>
	  					<input type="text" placeholder="Descripción..." name="search"  autocomplete="off" value="<%=desc%>">
	 				<%} %>
	 				<button type="submit"><i class="fa fa-search"></i></button>
				</form>
   				<%if(lprod == null || lprod.size() == 0){ %>                      
   					<br>
    				<div class="alert alert-warning"> ¡Lo sentimos! No hay resultados disponibles.</div>                               	
					<%} %>
			</div>
				
			<div class="col">
				<span style="text-align: right; vertical-align: bottom;">            	
				<div class="w3-container">	 
				<form action="AddProductoDropList" method="post">
		 			<button class="btn btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" style="margin:12px;max-width:230px;height:50px;position: absolute;
  right: 0;">Agregar Producto</button>
  			</form>
  			<!-- <form action="ingresarStock.jsp" method="post">
		 		<button class="btn btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" style="margin:12px;max-width:230px;height:50px;position: absolute;
  right: 0;">Ingresar stock</button>
  			</form>-->
				</div>			
				</span>	
			</div>
 <br>
 </div>	
	<!--  TABLA -->	
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th align="center"><span>ID</span></th>
                                <th align="center"><span>Descripción</span></th>
                                <th align="center"><span>Stock</span></th>
                                <th align="center"><span>Stock Mínimo</span></th>
                                <th align="center"><span>Marca</span></th>
                                <th align="center"><span>Categoría</span></th>
                                <th align="center"><span>Precio</span></th>
                                <th align="center"><span>Estado</span></th>
                                <th align="center"><span>Proveedor</span></th>
        
                                <th >&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <% for (Producto p: lprod) { 
                    			 %>
	                    			<tr>
	                    			<td><%=p.getIdProducto()%></td>
	                    			<td><%=p.getDescProducto()%></td>
	                    			<%if (p.getStock()<=p.getStockMinimo()){ %>
	                    			<td style="color:red"><b><%=p.getStock()%></b></td>
	                    			<%}else{ %>
	                    			<td><%=p.getStock()%></td>
	                    			<%}%>
                                    <td><%=p.getStockMinimo()%></td>
                                    <td><%=p.getMarca()%></td>
                                    <%CategoriaController ctrl = new CategoriaController();
                                    Categoria c= new Categoria();
                                    c.setIdCategoria(p.getId_categoria());
                                    c=ctrl.getOne(c);%>
   									<td><%=c.getDescCategoria()%></td>
                                    <td><%=p.getPrecio()%> </td>
       								<% if (p.getFecha_hora_baja() == null) { %> 
	       								 <td>
		                                      <a href="DeshabilitarProducto?id=<%=p.getIdProducto()%>" onclick="return confirm('Desea deshabilitar este producto?');" >
		                                      	<span class="badge bg-success">Activo</span>
		                                      </a>
	                                    </td>
       								<% } else { %>
       								 	<td>
	                                       <a href="HabilitarProducto?id=<%=p.getIdProducto()%>" onclick="return confirm('Desea habilitar este producto?');">
	                                       	<span class="badge bg-danger">Inactivo</span>
	                                       </a>
                                       </td>
       								<% } %>
       								<%if(p.getId_proveedor()<1){ %>
       								 	<td style="color:red"><a href="ObtenerProducto?id=<%=p.getIdProducto()%>">Ingresar stock</a></td>
       								<%} else{
       								ProveedorController ctrlP = new ProveedorController();
                                    Proveedor prov= new Proveedor();
                                    prov.setIdProveedor(p.getId_proveedor());
                                    prov=ctrlP.getById(prov);
                                    %>
       								<td><a href="ContactarProveedor?id=<%=p.getId_proveedor()%>"><%=prov.getRazonSocial()%></a></td>
       								<%} %>
                                     <td style="width: 6%;">
                                        
                                         <a  href="BuscarProducto?id=<%=p.getIdProducto()%>"  class="table-link text-info">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
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
                        
            
          
        </div>
    </div>
</div>

</body>
</html>