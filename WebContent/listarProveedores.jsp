<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <!-- Boostrap para searchbar -->
 <link href="style/search-bar/search-bar.css" rel="stylesheet">

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

  
  
<title>Proveedores</title>


<% LinkedList<Proveedor> lp = (LinkedList<Proveedor>)request.getAttribute("proveedores");
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
        
          <li class="nav-item">
            <a class="nav-link" href="ListCategorias">Categorías</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListDescuentos">Descuentos</a>
          </li>
          <li class="nav-item ">
	            <a class="nav-link" href="ListClientes">Clientes</a>
	             
          </li>
                     <li class="nav-item">
             <a class="nav-link" href="ListEmpleados">Empleados</a>
          </li>
           <li class="nav-item">
              <a class="nav-link" href="ListProductos">Productos</a>
          </li>
          <li class="nav-item">
             <a class="nav-link" href="ListPedidos">Pedidos</a>
          </li>
           <li class="nav-item active">
            <a class="nav-link" href="ListProveedores">Proveedores</a>
            <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="">Cerrar Sesión</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  </div>
  
 <hr> 
 <div class="container bootstrap snippets bootdey">
 <div class="row">	
 
<form class="example" action="ListProveedoresDesc" style="margin:10px;max-width:300px">
  <input type="text" placeholder="Razón Social" name="search">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>
	
		<!-- DESCRIPCION -->	
		<!-- <form action="ListProveedoresDesc">
		   <div class="search-box" style="margin:8px;max-width:300px;position:absolute;font-size: 16px;">
		      <input type="text" placeholder="Razon social..." name="razonS">
		      <button type="submit"><i class="fa fa-search"></i></button>
		   </div>
		</form>-->

<%if(lp.size() == 0){ %>  
    <br>         
    <div class="alert alert-warning"> ¡Lo sentimos! No hay proveedores con esa descripción.</div>                               	
<%} %>
 
	<br>
	<br>
	<br>
	
 </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th align="center"><span>ID</span></th>
                                <th align="center"><span>Razon Social</span></th>
                                <th align="center"><span>Email</span></th>
                                <th align="center"><span>Teléfono</span></th>
                                <th align="center"><span>Estado</span></th>
                               
                               
                                <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <% for (Proveedor p : lp) { %>
	                    			<tr>
	                    			<td><%=p.getIdProveedor()%></td>
                                    <td><%=p.getRazonSocial()%></td>
                                    <td><%=p.getMail()%></td>
                                    <td><%=p.getTelefono()%> </td>
                                    <%if (p.getFechaBaja()==null){%>
                                    <td>
                                    <a href="DeshabilitarProveedor?idProv=<%=p.getIdProveedor()%>" onclick="return confirm('Desea deshabilitar este proveedor?');">
                                    	<span class="badge bg-success">Activo</span>
                                    </a>
                                    </td>
                                    <%}else{%> 
                                       <td>
                                       <a href="HabilitarProveedor?idProv=<%=p.getIdProveedor()%>" onclick="return confirm('Desea habilitar este proveedor?');">
                                       	<span class="badge bg-danger">Inactivo</span>
                                       </a>
                                       </td>
                                    <%} %>
                                    
       
                                     <td style="width: 10%;">
                                        
                                        <a href="BuscarProveedor?id=<%=p.getIdProveedor()%>" class="table-link text-info">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                        <a  href="DeleteProveedor?id=<%=p.getIdProveedor()%>" class="table-link danger" onclick="return confirm('Desea eliminar este proveedor?');" >
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
			
			<div class="w3-container">	 
			<form action="crearProveedor.jsp" method="post">
				<button class="w3-button w3-xlarge w3-circle w3-teal" type="submit" >+</button>
				<a href="crearProveedor.jsp"> Agregar proveedor</a>
			</form>
			</div>
			
			</span>
        </div>
    </div>
</div>


</body>
</html>

