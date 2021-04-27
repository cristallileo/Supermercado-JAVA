<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  <link href="style/login/login.css" rel="stylesheet">

<title>Importante</title>
</head>
<body>

 <div class="container">
 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
          <li class="nav-item">
            <a class="nav-link" href="mis-pedidos.jsp">Mis pedidos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListDescuentos">Descuentos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="ListProductos">Productos</a>
          </li>          
          <li class="nav-item">
            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
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
              <h3 class="login-heading mb-4 text-center">Ingrese dirección</h3>
                   
               <form action="ConfirmarPedido" method="post">
	                <div class="form-label-group">
	                  <input type="text" name="direc" id="direc" class="form-control" placeholder="Dirección de envío" required >
	                  <label for="direc">Dirección de envío</label>
	                </div>
                	<button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Desea confirma su pedido?')">Confirmar</button>
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