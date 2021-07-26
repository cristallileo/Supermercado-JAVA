<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear cuenta</title>

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  <link href="style/login/login.css" rel="stylesheet">

</head>
<body>

	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	    <div class="container">
	      <a class="navbar-brand" href="index.jsp">Supermercado</a>
	      <div class="collapse navbar-collapse" id="navbarResponsive">
	        <ul class="navbar-nav ml-auto">
	           <li class="nav-item ">
	            <a class="nav-link" href="login.jsp">Iniciar Sesión </a>
          	   </li>
	          <li class="nav-item active">
	            <a class="nav-link" href="registro.jsp">Registrarse</a>
	             <span class="sr-only">(current)</span>
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
              <h3 class="login-heading mb-4 text-center">Creá tu cuenta</h3>
              
              <form action="AddClientes" method="post">
               
                <div class="form-label-group">
                  <input type="text" name="name" id="name" class="form-control" placeholder="Nombre" required >
                  <label for="name">Nombre</label>
                </div>

                <div class="form-label-group">
                  <input type="text" name="surname" id="surname" class="form-control" placeholder="Apellido" required>
                  <label for="surname">Apellido</label>
                </div>

				<label for="tipoDoc">Tipo Doc:</label>
  				<select id="tipoDoc" name="tipoDoc">
   				<option value="DNI">DNI</option>
  				<option value="Libreta Civica">Libreta Cívica</option>
  				<option value="Libreta de Enrolamiento">Libreta de Enrolamiento</option>
  				</select>
              
                <div class="form-label-group">
                  <input type="text" name="nroDoc" id="nroDoc" class="form-control" placeholder="Nro doc" required>
                  <label for="nroDoc">Nro Documento</label>
                </div>
             
                <div class="form-label-group">
                  <input type="text" name="tel" id="tel" class="form-control" placeholder="Telefono" required>
                  <label for="tel">Teléfono</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="direc" id="direc" class="form-control" placeholder="Dirección" required>
                  <label for="direc">Dirección</label>
                </div>
                
                <div class="form-label-group">
                  <input type="email" name="email" id="email" class="form-control" placeholder="Email" required>
                  <label for="email">Email</label>
                </div>
                
                <div class="form-label-group">
                  <input type="password" name="pass" id="pass" class="form-control" placeholder="Contraseña" required>
                  <label for="pass">Contraseña</label>
                </div>
                
                <p>${message_cliente1}</p>
                <p>${message_cliente2}</p>
         		<p>${message_cliente3}</p>
         
      			<form action="AddCliente" method="post">
                		<button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Enviar</button>
                </form>
                
                <div class="text-center">
                  Ya tenés cuenta? <a  href="login.jsp">Ingresá</a></div>
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