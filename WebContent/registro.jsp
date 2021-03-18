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
                  <input type="text" name="name" id="inputName" class="form-control" placeholder="Nombre" required >
                  <label for="inputEmail">Nombre</label>
                </div>

                <div class="form-label-group">
                  <input type="text" name="surname" id="inputSurname" class="form-control" placeholder="Apellido" required>
                  <label for="inputPassword">Apellido</label>
                </div>

				<label for="tipoDoc">Elegir Tipo Doc:</label>
  				<select id="tipoDoc" name="tipoDoc">
   				<option value="dni">DNI</option>
  				<option value="libreta">Libreta Cívica</option>
  				<option value="libreta">Libreta de Enrolamiento</option>
  				</select>
              
                <div class="form-label-group">
                  <input type="text" name="nroDoc" id="inputNro" class="form-control" placeholder="Nro doc" required>
                  <label for="inputPassword">Nro Documento</label>
                </div>
             
                <div class="form-label-group">
                  <input type="text" name="tel" id="inputTel" class="form-control" placeholder="Telefono" required>
                  <label for="inputPassword">Teléfono</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="direc" id="inputDirec" class="form-control" placeholder="Dirección" required>
                  <label for="inputPassword">Dirección</label>
                </div>
                
                <div class="form-label-group">
                  <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email" required>
                  <label for="inputPassword">Email</label>
                </div>
                
                <div class="form-label-group">
                  <input type="password" name="pass" id="inputPass" class="form-control" placeholder="Contraseña" required>
                  <label for="inputPassword">Contraseña</label>
                </div>
                
                <form action="AddCliente" method="post">
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Se agregará un nuevo cliente. Desea confirmar?')">Agregar</button>
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