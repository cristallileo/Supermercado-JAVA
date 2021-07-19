<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Editar cliente</title>

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">    
  <link href="style/login/login.css" rel="stylesheet">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<% Persona per = (Persona)request.getAttribute("cliente");%> 
</head>
<body>

<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
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
          <li class="nav-item active">
            <a class="nav-link" href="BuscarCliente?id=<%=per.getIdPersona()%>">Mi cuenta</a>
             <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
          </li>
       
        </ul>
      </div>
    </div>
  </nav>
  
  
  <div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto ">
              <h3 class="login-heading mb-4 text-center">Mi Cuenta</h3>
              
              <form action="EditCliente?id=<%=per.getIdPersona()%>" method="post">
               
                <div class="form-label-group">
                  <input type="text" name="name" id="name" class="form-control" value="<%=per.getNombre()%>" required >
                  <label for="name">Nombre</label>
                </div>

                <div class="form-label-group">
                  <input type="text" name="surname" id="surname" class="form-control" value="<%=per.getApellido()%>" required>
                  <label for="surname">Apellido</label>
                </div>
				
				
				
				<label for="tipoDoc">Elegir Tipo Doc:</label>
  				<select id="inputTipoDoc" name="tipoDoc">
  				
  				
  				
  				<% switch (per.getTipoDoc()) 
  				{ 
  				
  				case "DNI":%>  				
   				<option value="DNI">DNI</option>
  				<option value="Libreta Civica">Libreta Cívica</option>
  				<option value="Libreta de Enrolamiento">Libreta de Enrolamiento</option>
  				<% break; 
  				
  				case "Libreta Civica":%>    				
  				<option value="Libreta Civica">Libreta Cívica</option>
  				<option value="DNI">DNI</option>
  				<option value="Libreta de Enrolamiento">Libreta de Enrolamiento</option>	
  				<% break; 
  				
  				case "Libreta de Enrolamiento":%>
  				<option value="Libreta de Enrolamiento">Libreta de Enrolamiento</option>
  				<option value="DNI">DNI</option>
  				<option value="Libreta Civica">Libreta Cívica</option>  				
  				<% break; 
  				} %>				

                </select>   
                     
                                  
                <div class="form-label-group">
                  <input type="text" name="nroDoc" id="nroDoc" class="form-control" value="<%=per.getNroDoc()%>" required>
                  <label for="nroDoc">Nro Documento</label>
                </div>
             
                <div class="form-label-group">
                  <input type="text" name="tel" id="tel" class="form-control" value="<%=per.getTelefono()%>" required >
                  <label for="tel">Teléfono</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="direc" id="direc" class="form-control" value="<%=per.getDireccion()%>" required>
                  <label for="direc">Dirección</label>
                </div>
                
                <div class="form-label-group">
                  <input type="email" name="email" id="email" class="form-control" value="<%=per.getEmail() %>" disabled>
                  <label for="email">Email</label>
                </div>
                
                <div class="form-label-group">
                  <input type="password" name="pass" id="pass" class="form-control" value=<%=per.getPassword() %> required>
                  <label for="pass">Contraseña</label>
                </div>
                
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Se actualizarán sus datos. Desea confirmar?')">Guardar cambios</button>
                       
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


</body>
</html>