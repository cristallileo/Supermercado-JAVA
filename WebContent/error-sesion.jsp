<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Error</title>

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">  
  <link href="style/login/login.css" rel="stylesheet">
   
</head>
<body style="padding-top: 87px;">

	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	    <div class="container">
	      <a class="navbar-brand" href="index.jsp">Supermercado</a>

	      <div class="collapse navbar-collapse" id="navbarResponsive">
	        <ul class="navbar-nav ml-auto">
	           <li class="nav-item ">
	            <a class="nav-link" href="login.jsp">Iniciar Sesión
	            </a>
          	  </li>
	          <li class="nav-item">
	            <a class="nav-link" href="registro.jsp">Registrarse</a>
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
            <div class="col-md-9 col-lg-8 mx-auto text-center ">
              <h3 class="login-heading mb-4 text-center">La sesión ha expirado</h3>
              <p>Intente de nuevo</p>
              <a href="login.jsp" style="text-align:center;">Ingresar</a>
          
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>