<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
 <!-- Estilo para el listado de clientes -->
 <link href="style/clientes-admin/listado-clientes.css" rel="stylesheet">
 
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  
  <link href="style/login/login.css" rel="stylesheet">
    	
<title>Pedidos</title>

<% LinkedList<Pedido> lp = (LinkedList<Pedido>)request.getAttribute("pedidos");
Calendar cal = Calendar.getInstance();
String MES[] = {"Enero", "Feb", "Marzo", "Abril", "Mayo", "Jun", "Jul", "Agosto", "Sept", "Oct", "Nov", "Dic"};
Persona cliente = new Persona();
PersonaController ctrl = new PersonaController();

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
          <li class="nav-item ">
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
          <li class="nav-item active">
            <a class="nav-link" href="ListPedidos">Pedidos</a>
             <span class="sr-only">(current)</span>
              <li class="nav-item ">
            <a class="nav-link" href="ListProveedores">Proveedores</a>
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
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th align="center"><span>ID</span></th>
                                <th align="center"><span>Fecha</span></th>
                                <th align="center"><span>Estado</span></th>
                                <th align="center"><span>Precio Total</span></th>
                                <th align="center"><span>Fecha Entrega</span></th>
                                <th align="center"><span>Dirección Envío</span></th>
                                <th align="center"><span>Cliente</span></th>
                                <th align="center"><span>Estado</span></th>
                                <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <% for (Pedido p: lp) { %>
	                    			<tr>
	                    			<td><%=p.getIdPedido()%></td>
	                    			<%Descuento descuento = new Descuento();
									DescuentoController ctrlD= new DescuentoController();	
	                    			cal.setTime(p.getFechaPedido());
	                    			int year = cal.get(Calendar.YEAR); 
	                    			String month = MES[cal.get(Calendar.MONTH)];
	                    			int day = cal.get(Calendar.DAY_OF_MONTH);
	                    			int id = p.getId_persona();
	                    			cliente.setIdPersona(id);
	                    			cliente=ctrl.getById(cliente);
	                    			Integer id_d= p.getId_dcto();
	                    			descuento.setIdDcto(id_d);
	                    			descuento=ctrlD.getById(descuento);
	                    			%>
                                    <td><%=day%> <%=month%> <%=year%></td>
                                    <td><%=p.getEstado()%> </td>
                                    <td>$<%=p.getPrecioTotal()%></td>
                                    <%if (p.getFechaEntrega()==null){ %>
                                    <td>A definir</td>
                                    <%}else{
                                    	cal.setTime(p.getFechaEntrega());
	                    				int year2 = cal.get(Calendar.YEAR); 
	                    				String month2 = MES[cal.get(Calendar.MONTH)];
	                    				int day2 = cal.get(Calendar.DAY_OF_MONTH);%>
                                    <td><%=day2%> <%=month2 %> <%=year2 %> </td>
                                    <%} %>
                                    <%if((p.getDireccionEnvio())==null){ %>
                                    <td>A definir </td>
                                    <%}else{ %>
                                    <td><%=p.getDireccionEnvio()%> </td>
                                    <%} %>
                                    <td><%=cliente.getNombre()%> <%=cliente.getApellido() %> </td>
                                    
                                    <%if (p.getId_dcto()<1){ %>
                                    <td >--</td>
                                    <%}else{
									descuento.setIdDcto(p.getId_dcto());
									descuento=ctrlD.getById(descuento);%>
                                    <td><%=descuento.getPorcDcto()*100%></td>
                                    <%} %>
                                    <td style="width: 9%;"> 
                                    
                                    <a href="ListLineas?id=<%=p.getIdPedido() %>" class="table-link  text-warning">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
                                            </span>
                                       </a>
                                     
                                        <a href="BuscarPedido?id=<%=p.getIdPedido()%>" class="table-link text-info">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                    </td>                                  
	                    		</tr>
	                    		<%} %>
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

                                        