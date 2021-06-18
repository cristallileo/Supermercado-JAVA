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

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">  
 <!-- Estilo para el listado de clientes -->
  <link href="style/clientes-admin/listado-clientes.css" rel="stylesheet">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  <link href="style/clientes-admin/confirmacion.css" rel="stylesheet"> 
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href="style/login/login.css" rel="stylesheet">
  
<title>Descuentos</title>


<% LinkedList<Descuento> ld = (LinkedList<Descuento>)request.getAttribute("descuentos");
java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
String MES[] = {"Enero", "Feb", "Marzo", "Abril", "Mayo", "Jun", "Jul", "Agosto", "Sept", "Oct", "Nov", "Dic"};
Calendar cal = Calendar.getInstance();
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
          <li class="nav-item active">
            <a class="nav-link" href="ListDescuentos">Descuentos</a>
            <span class="sr-only">(current)</span>
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
        <div class="col-lg-12">
           <span style="text-align: right; vertical-align: bottom;">
			
			<div class="w3-container">	 
			<form action="crearDcto.jsp" method="post">
		 	<button class="btn btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" style="margin:12px;max-width:250px;height:50px;position: absolute;
  right: 0;">Agregar Descuento</button>
  			</form>
			</div>			
			<br>
			<br>
			<BR>			
			</span>
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th align="center"><span>ID</span></th>
                                <th align="center"><span>Porcentaje</span></th>
                                <th align="center"><span>Fecha Inicio</span></th>
                                <th align="center"><span>Fecha Fin</span></th>
                                <th align="center"><span>Estado</span></th>
                               
                                <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <% for (Descuento d : ld) { %>
	                    			<tr>
	                    			<%Date fec1= d.getFechaDctoInicio();
	                    			cal.setTime(fec1);
	                    			int year1 = cal.get(Calendar.YEAR); 
	                    			String month1 = MES[cal.get(Calendar.MONTH)];
	                    			int day1 = cal.get(Calendar.DAY_OF_MONTH);
	                    			Date fec2= d.getFechaDctoFin();
	                    			cal.setTime(fec2);
	                    			int year2 = cal.get(Calendar.YEAR); 
	                    			String month2 = MES[cal.get(Calendar.MONTH)];
	                    			int day2 = cal.get(Calendar.DAY_OF_MONTH);
	                    			%>
	                    			<td><%=d.getIdDcto() %></td>
                                    <td><%=d.getPorcDcto()*100%>%</td>
                                    <td><%=day1%> <%=month1 %> <%=year1 %></td>
                                    <td><%=day2%> <%=month2 %> <%=year2 %> </td>
       								 <%if (d.getFechaDctoInicio().before(timeNow) && d.getFechaDctoFin().after(timeNow)){%>
                                    <td>
                                    <a>
                                    	<span class="badge bg-success">Activo</span>
                                    </a>
                                    </td>
                                    <%}else{%> 
                                       <td>
                                       <a>
                                       	<span class="badge bg-danger">Inactivo</span>
                                       </a>
                                     </td>
                                    <%} %>
       
       
                                     <td style="width: 10%;">
                                        
                                        <a href="BuscarDescuento?id=<%=d.getIdDcto()%>" class="table-link text-info">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                        <a  href="DeleteDescuento?id=<%=d.getIdDcto()%>" class="table-link danger" onclick="return confirm('Desea eliminar este descuento?');" >
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