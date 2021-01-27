<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear cuenta</title>

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
   <!--  <link href="style/login/login.css" rel="stylesheet"> -->
   
   
   <link href="style/register/register.css" rel="stylesheet">
   
  
</head>
<body>

<!-- Navigation -->
	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	    <div class="container">
	      <a class="navbar-brand" href="index.jsp">Supermercado</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	      <div class="collapse navbar-collapse" id="navbarResponsive">
	        <ul class="navbar-nav ml-auto">
	           <li class="nav-item">
	            <a class="nav-link" href="login.jsp">Iniciar Sesión
	            </a>
          	  </li>
	          <li class="nav-item active">
	            <a class="nav-link" href="registro.jsp">Registrarse</a>
	            <span class="sr-only">(current)</span>
	          </li>
	          
	        </ul>
	      </div>
	    </div>
	  </nav>
	  
<br>
<br>
<form action="AddClientes" method="post">
  <div class="container">
    <h1>Únete a (nombre)</h1>
    <p>Por favor complete el formulario para crear una cuenta</p>
    <hr>
	
	<label for="name"><b>Nombre </b></label>
    <input type="text" placeholder="Ingrese nombre" name="name" id="name" required>
    
     <label for="surname"><b>Apellido</b></label>
    <input type="text" placeholder="Ingrese apellido" name="surname" id="surname" required>
    
    <label for="surname"><b>Tipo de Documento</b></label>
    <input type="text" placeholder="Tipo" name="surname" id="tipoDoc" required>
    
	<!-- <label for="tDoc"><b>Elegir tipo de documento</b></label>
	  <select id="text" name="tipoDoc">
	    <option value="dni">Dni</option>
	    <option value="pasaporte">Pasaporte</option>
	    <option value="ect">etc</option>
	  </select>
	<br>     
    <br> -->
    
    <label for="nroDoc"><b>Numero de Documento</b></label>
    <input type="text" placeholder="Nro doc" name="nroDoc" id="nroDoc" required>
    
    <label for="tel"><b>Telefono</b></label>
    <input type="text" placeholder="Ingrese telefono" name="tel" id="tel" required>
    
        <label for="direc"><b>Dirección</b></label>
    <input type="text" placeholder="Ingrese direccion" name="direc" id="direc" required>
	
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Ingrese email" name="email" id="email" required>

    <label for="psw"><b>Contraseña</b></label>
    <input type="password" placeholder="Ingrese contraseña" name="psw" id="psw" required>

    <label for="psw-repeat"><b>Repetir Contraseña</b></label>
    <input type="password" placeholder="Repita la contraseña" name="psw-repeat" id="psw-repeat" required>
    <hr>


    <button type="submit" class="registerbtn" value="AddClientes">Registrame</button>
  </div>

</form>

  <div class="container signin">
    <p>¿Ya tienes una cuenta? <a href="login.jsp">Log in</a>.</p>
  </div>
</body>
</html>