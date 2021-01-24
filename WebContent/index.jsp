<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Bienvenido</title>

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
  
  <style>

	.masthead {
	 
	font-family: Arial, Helvetica, sans-serif;
  height: 100vh;
  min-height: 500px;
  background-image: url('style/login/1.jpg');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}
	h1, .h1 {
	  font-size: 4em;
	}
	


	
</style>
  
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
            	<a class="nav-link" href="login.jsp">Iniciar Sesión</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="registro.jsp">Registrarse</a>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>


  <!-- Page Content -->


<!-- Full Page Image Header with Vertically Centered Content -->
<header class="masthead">
  <div class="container h-100">
    <div class="row h-50 align-items-center">
      <div class="col-12 text-center">
       <b><h1  class="font-weight-light">Comprá Online</h1></b>
        <p style="font-size:30px;" class="lead">Nosotros te lo llevamos a tu casa</p>
 		<a href="login.jsp" class="btn btn-info" role="button">Comenzar a comprar</a>
      </div>
    </div>
  </div>
</header>




</body>

</body>
</html>