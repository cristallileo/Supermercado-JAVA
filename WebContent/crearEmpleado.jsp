<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  <link href="style/login/login.css" rel="stylesheet">
   
<title>Alta Empleado</title>
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
          <li class="nav-item ">
             <a class="nav-link" href="ListEmpleados">Empleados</a>
          </li>
           <li class="nav-item">
              <a class="nav-link" href="ListProductos">Productos</a>
          </li>
          <li class="nav-item">
             <a class="nav-link" href="ListPedidos">Pedidos</a>
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesión</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  </div>
  <div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto ">
              <h3 class="login-heading mb-4 text-center">Nuevo empleado</h3>
              
              <form action="AddEmpleado" method="post">
               
                <div class="form-label-group">
                  <input type="text" name="name" id="name" class="form-control" placeholder="Nombre" required  autocomplete="off" >
                  <label for="name">Nombre</label>
                </div>

                <div class="form-label-group">
                  <input type="text" name="surname" id="surname" class="form-control" placeholder="Apellido" required  autocomplete="off" >
                  <label for="surname">Apellido</label>
                </div>

				<label for="tipoDoc">Tipo Doc:</label>
  				<select id="inputTipoDoc" name="tipoDoc">
   				<option value="DNI">DNI</option>
  				<option value="Libreta Civica">Libreta Cívica</option>
  				<option value="Libreta de Enrolamiento">Libreta de Enrolamiento</option>
  				</select>	
            
                <div class="form-label-group">
                  <input type="text" name="nroDoc" id="nroDoc" class="form-control" placeholder="Nro doc" required  autocomplete="off" >
                  <label for="nroDoc">Nro Documento</label>
                </div>
             
                <div class="form-label-group">
                  <input type="text" name="tel" id="tel" class="form-control" placeholder="Telefono" required  autocomplete="off" >
                  <label for="tel">Teléfono</label>
                </div>
               
                
                <div class="form-label-group">
                  <input type="text" name="direc" id="direc" class="form-control" placeholder="Dirección" required  autocomplete="off" >
                  <label for="direc">Dirección</label>
                </div>
                
                <div class="form-label-group">
                  <input type="email" name="email" id="email" class="form-control" placeholder="Email" required  autocomplete="off" >
                  <label for="email">Email</label>
                </div>
                
                <div class="form-label-group">
                  <input type="password" name="pass" id="pass" class="form-control" placeholder="Contraseña" required>
                  <label for="pass">Contraseña</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="cuil" id="cuil" class="form-control" placeholder="CUIL" required  autocomplete="off" >
                  <label for="cuil">CUIL</label>
                </div>
                
                <p>${message_empleado1}</p>
                <p>${message_empleado2}</p>
                <p>${message_empleado3}</p>
                 <p>${message_empleado4}</p>
                 
                <form action="AddEmpleado" method="post">
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Se agregará un nuevo empleado. Desea confirmar?')">Agregar</button>
                </form>
                
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