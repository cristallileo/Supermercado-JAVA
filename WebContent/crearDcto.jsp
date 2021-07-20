<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  <link href="style/login/login.css" rel="stylesheet">
   
<title>Alta Descuento</title>

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
           <a class="nav-link" href="ListDescuentos">Descuentos
           <span class="sr-only">(current)</span>
           </a>
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
          
          <li class="nav-item">
             <a class="nav-link" href="ListPedidos">Pedidos</a>
          </li>
          
           <li class="nav-item ">
            <a class="nav-link" href="ListProveedores">Proveedores</a>
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
  <h3 class="login-heading mb-4 text-center">Nuevo Descuento</h3>
  
  <form action="AddDescuento" method="post">
  				<div class="form-label-group">
                  <input type="text" name="porc" id="porc" class="form-control" placeholder="Porcentaje" required autocomplete="off">
                  <label for="porc">Porcentaje</label>
                </div>

                <div class="form-label-group">
                  <input type="date" name="desde" id="desde" class="form-control" placeholder="Desde-dd/mm/yyyy" required >
                  <label for="desde">Desde</label>
                </div>

				
                <div class="form-label-group">
                  <input type="date" name="hasta" id="hasta" class="form-control" placeholder="Hasta-dd/mm/yyyy" required >
                  <label for="hasta">Hasta</label>
                </div>
                   
                 <!-- Mensaje de error si la fecha desde es anterior a la fecha hasta -->
                <p>${message_wrong_date1}</p>
                <p>${message_wrong_date2}</p>
                 <p>${message_porc}</p>
    				<button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Se agregará un nuevo descuento. Desea confirmar?')">Agregar</button>
 				
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