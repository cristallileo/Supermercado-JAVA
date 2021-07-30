<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Empleados</title>
		 <!-- Boostrap para searchbar -->
  	<link href="style/search-bar/search-bar.css" rel="stylesheet"> 
  	<link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  	<link href="style/mainpage/modern-business.css" rel="stylesheet">  
 <!-- Estilo para el listado de clientes -->
 	 <link href="style/clientes-admin/listado-clientes.css" rel="stylesheet">  
  	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  	<link href="style/login/login.css" rel="stylesheet">

	<% LinkedList<Persona> le = (LinkedList<Persona>)request.getAttribute("empleados");
   String descrip= (String)request.getAttribute("descrip");
   Calendar cal = Calendar.getInstance();
   String MES[] = {"Enero", "Feb", "Mar", "Abril", "Mayo", "Jun", "Jul", "Agosto", "Sept", "Oct", "Nov", "Dic"};
	%>
</head>

<body>

  <div class="container">
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage-admin.jsp">Supermercado</a>
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
          <li class="nav-item active">
	            <a class="nav-link" href="ListEmpleados">Empleados</a>
	            <span class="sr-only">(current)</span>
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
 		
 		<div class="col">
    		<form class="example" action="ListEmpleadosNombre" style="margin:10px;max-width:300px">
    		<%if (descrip==null){ %>
	 			<input type="text" placeholder="Nombre..." name="search" autocomplete="off">
	  		<%}else{ %>
	  			<input type="text" placeholder="Nombre..." name="search"  autocomplete="off"  value="<%=descrip%>">
	  			<%if (le.size() == 0){ %>  
    			<div class="alert alert-warning" style="margin:0px; max-width:450px; height:50px; position:fixed; ; right: 500px;"> ¡Lo sentimos! No hay resultados disponibles..</div>       
    			<!--   -->                    	
			<%} %>
	  		<%} %>
	  		<button type="submit"><i class="fa fa-search"></i></button>


			</form>
			
		</div>
		
		<div class="col">
			<span style="text-align: right; vertical-align: bottom;">           					
			<form action="crearEmpleado.jsp" method="post">
		 	<button class="btn btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" style="margin:12px;max-width:250px;height:50px;position: absolute;
  right: 0;">Agregar Empleado</button>
  			</form>
			</span>		
		</div>
 	</div> 
    <br>
  <!--    ----------- -->
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th align="center"><span>ID</span></th>
                                <th align="center"><span>Nombre</span></th>
                                <th align="center"><span>Apellido</span></th>
                                <th align="center"><span>Tipo Doc</span></th>
                                <th align="center"><span>Número Doc</span></th>
                                <th align="center"><span>Telefono</span></th>
                                <th align="center"><span>Dirección</span></th>
                                <th align="center"><span>Email</span></th>
                                <th align="center"><span>Ingreso</span></th>
                               
                                <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <% for (Persona per : le) { %>
	                    			<tr>
	                    			<%cal.setTime(per.getFechaIngreso());
	                    			int year = cal.get(Calendar.YEAR); 
	                    			String month = MES[cal.get(Calendar.MONTH)];
	                    			int day = cal.get(Calendar.DAY_OF_MONTH); %>
	                    			<td><%=per.getIdPersona() %></td>
                                    <td><%=per.getNombre()%></td>
                                    <td><%=per.getApellido() %></td>
                                    <td><%=per.getTipoDoc()%> </td>
                                    <td><%=per.getNroDoc()%> </td>
                                    <td><%=per.getTelefono() %> </td>
                                    <td><%=per.getDireccion()%> </td>
                                    <td><%=per.getEmail()%> </td>
                                    <td><%=day%> <%=month %> <%=year %></td>
                                     <td style="width: 10%;">
                                        
                                        <a href="BuscarEmpleado?id=<%=per.getIdPersona()%>" class="table-link text-info">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                        <a  href="DeleteEmpleado?id=<%=per.getIdPersona()%>" class="table-link danger" onclick="return confirm('Se eliminará el empleado. Desea confirmar?');" >
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
        </div>
    </div>
</div>

</body>
</html>