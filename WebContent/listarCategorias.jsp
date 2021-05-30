<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset= ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	 <!-- Boostrap para searchbar -->
 	<link href="style/search-bar/search-bar.css" rel="stylesheet">
 
 	 <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  	<link href="style/mainpage/modern-business.css" rel="stylesheet">
  	<link href="style/clientes-admin/listado-clientes.css" rel="stylesheet"> 
  	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  	<link href="style/clientes-admin/confirmacion.css" rel="stylesheet"> 
  	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 

	 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	
     <!-- Custom styles for this template -->
     
   <link href="style/login/login.css" rel="stylesheet">
  
	<title>Categorias</title>
	<% LinkedList<Categoria> lc = (LinkedList<Categoria>)request.getAttribute("categorias"); 
	String descrip= (String)request.getAttribute("descrip");
	%>

</head>

<body>

  <div class="container">
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage-admin.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">

          <li class="nav-item active">
            <a class="nav-link" href="ListCategorias">Categorías</a>
                       	 <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
           <a class="nav-link" href="ListDescuentos">Descuentos</a>
          </li>
          <li class="nav-item ">
	            <a class="nav-link" href="ListClientes">Clientes</a>	            
          </li>
          <li class="nav-item ">
	            <a class="nav-link" href="ListEmpleados">Empleados</a>	             
          </li>
          <li class="nav-item">
              <a class="nav-link" href="ListProductos">Productos</a>
          </li>
          <li class="nav-item">
             <a class="nav-link" href="ListPedidos">Pedidos</a>
          </li>
           <li class="nav-item ">
            <a class="nav-link" href="ListProveedores">Proveedores</a>
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
 		 
 		<div class="col"> 		
			<form class="example" action="ListCategoriasDesc" style="margin:10px;max-width:300px;">
	   			<%if (descrip==null){ %>
	  				<input type="text" placeholder="Descripción..." name="search" autocomplete="off">
	  			<%}else{ %>
	  				<input type="text" placeholder="Descripción..." name="search" value="<%=descrip%>">
	  			<%} %>
	  			<button type="submit"><i class="fa fa-search"></i></button>	  	
			</form>			
			<%if(lc == null || lc.size() == 0){ %>		  
				<br>                     
    			<div class="alert alert-warning"> ¡Lo sentimos! No hay categorias con esa descripción.</div>    	                               
			<%} %>
		</div>
		
		<div class="col">
			<span style="text-align: right; vertical-align: bottom;">           	
			<form action="crearCategoria.jsp" method="post">
		 	<button class="btn btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" style="margin:12px;max-width:270px;height:50px;position: absolute;
  right: 0;">Agregar Categoria</button>
  	</form>	
			</span>	
		</div>
		
	</div>
	<br>
    <div class="row">
    <!--  TABLA -->	
        <div class="col-lg-12">
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th align="center"><span>ID</span></th>                                               
                                <th align="center"><span>DESCRIPCIÓN</span></th>
                                <th align="center"><span>ESTADO</span></th>
               
                                <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <% for (Categoria cat : lc) { %>
	                    			<tr>
	                    			<td><%=cat.getIdCategoria() %></td>
                                    <td><%=cat.getDescCategoria()%></td>  
                                     <%if (cat.getFecha_hora_baja()==null){%>
                                    <td>
                                    <a href="DeshabilitarCategoria?id=<%=cat.getIdCategoria()%>" onclick="return confirm('Desea deshabilitar esta categoría?');" >
                                      <span class="badge bg-success">Activo</span>
                                    </a>
                                    </td>
                                    <%}else{%> 
                                       <td>
                                       <a href="HabilitarCategorias?id=<%=cat.getIdCategoria()%>" onclick="return confirm('Desea habilitar esta categoría?');">
                                       	<span class="badge bg-danger">Inactivo</span>
                                       </a>
                                       </td>
                                    <%} %>                                       
                                     <td style="width: 10%;">                                        
                                        <a href="BuscarCategoria?id=<%=cat.getIdCategoria()%>" class="table-link text-info">
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
