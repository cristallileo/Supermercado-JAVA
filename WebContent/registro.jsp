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
	  

<form action="AddClientes" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
	
	 <label for="name"><b>Nombre</b></label>
    <input type="text" placeholder="Enter Name" name="name" id="name" required>
    
     <label for="surname"><b>Apellido</b></label>
    <input type="text" placeholder="Enter Surname" name="surname" id="surname" required>
    
    <label for="tipoDoc"><b>tipo doc</b></label>
    <input type="text" placeholder="Enter tipo doc" name="tipoDoc" id="tipoDoc" required>
    
    <label for="nroDoc"><b>nroDoc</b></label>
    <input type="text" placeholder="Enter nroDoc" name="nroDoc" id="nroDoc" required>
    
    <label for="tel"><b>telefono</b></label>
    <input type="text" placeholder="Enter tel" name="tel" id="tel" required>
    
        <label for="direc"><b>direc</b></label>
    <input type="text" placeholder="enter direc" name="direc" id="direc" required>
	
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
    <hr>


    <button type="submit" class="registerbtn">Register</button>
  </div>

  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>

</body>
</html>