<%-- 
    Document   : checkout
    Created on : oct 5, 2021, 3:30:41 a.m.
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href= "assets/img/favicon.ico"/> 
        <link href="assets/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/bootstrap/form-validation.css" rel="stylesheet" type="text/css"/>        
        <title>Checkout</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/checkout/">



        <!-- Bootstrap core CSS -->
        <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

        <style>
          .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
          }

          @media (min-width: 768px) {
            .bd-placeholder-img-lg {
              font-size: 3.5rem;
            }
          }
        </style>
  
    </head>
    <body>
        
        <! –– MENU ––>
        <nav class="navbar navbar-expand-lg navbar-light" style="background:#1588e3">
            <div class="container-fluid">

                <img src="assets/img/logoblancolargo.png" alt="" height="55px"/>                               

                <div class="" id="navbarSupportedContent"> 
                    <form class="d-flex">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active text-white" aria-current="page" href="index.jsp"> Inicio</a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link text-white" href="reservas.jsp">Reservas</a>
                            </li> 
                            <li class="nav-item">
                                <a class="nav-link  text-white" href="nosotros.html">Nosotros</a>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </nav>
        
        <div class="container">
            <main>
                <div class="py-3 text-center">
                    <img class="d-block mx-auto mb-4" src="assets/img/logo largo.png" alt="" height="75px"/>
                    <h3>Formulario de Reserva y pagos</h3>
                    <p class="lead">Agrega la información personal para realizar la reserva y la informacion de pago para completar la compra</p>
                </div>

                <div class="row g-5">
                    <div class="col-md-5 col-lg-4 order-md-last">
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="text-primary">Vuelos seleccionados</span>
                            <span class="badge bg-primary rounded-pill">2</span>
                        </h4>
                        <ul class="list-group mb-3">
                            <li class="list-group-item d-flex justify-content-between lh-sm">
                                <div>
                                    <h6 class="my-0">Vuelo de IDA</h6>
                                    <small class="text-muted">ID Vuelo 17748</small>
                                </div>
                                <span class="text-muted">$85.000</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between lh-sm">
                                <div>
                                    <h6 class="my-0">Vuelo de VUELTA</h6>
                                    <small class="text-muted">ID Vuelo 18554</small>
                                </div>
                                <span class="text-muted">$85.000</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between lh-sm">
                                <div>
                                    <h6 class="my-0">Cantidad de Pasajeros</h6>
                                    <small class="text-muted">Adultos</small>
                                </div>
                                <span class="text-muted">2</span>
                            </li>                           
                            <li class="list-group-item d-flex justify-content-between">
                                <span>Total Parcial (COP)</span>
                                <strong>$340.000</strong>
                            </li>
                            <li class="list-group-item d-flex justify-content-between bg-light">
                                <div class="text-success">
                                    <h6 class="my-0">Codigo Promoción</h6>
                                    <small>EXAMPLECODE</small>
                                </div>
                                <span class="text-success">−$80.000</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between">
                                <span>Total a Pagar (COP)</span>
                                <strong>$260.000</strong>
                            </li>
                        </ul>

                        <form class="card p-2">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Codigo Promocion">
                                <button type="submit" class="btn btn-secondary">Aplicar</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-7 col-lg-8">
                        <h4 class="mb-3">Facturación</h4>
                        <form class="needs-validation" novalidate>
                            <div class="row g-3">
                                <div class="col-sm-6">
                                    <label for="firstName" class="form-label">Nombres</label>
                                    <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Se requiere un nombre válido.
                                    </div>
                                </div>

                                <div class="col-sm-6">
                                    <label for="lastName" class="form-label">Apellidos</label>
                                    <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Se requiere un apellido válido.
                                    </div>
                                </div>  
                                
                                
                                <div class="col-sm-6">
                                    <label for="firstName" class="form-label">Cedula</label>
                                    <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Se requiere un nombre válido.
                                    </div>
                                </div>

                                <div class="col-sm-6">
                                    <label for="lastName" class="form-label">Celular</label>
                                    <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Se requiere un apellido válido.
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="email" class="form-label">Correo <span class="text-muted"></span></label>
                                    <input type="email" class="form-control" id="email" placeholder="you@example.com">
                                    <div class="invalid-feedback">
                                       Ingrese una dirección de correo electrónico válida.
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="address" class="form-label">Dirección</label>
                                    <input type="text" class="form-control" id="address" placeholder="1234 Main St" required>
                                    <div class="invalid-feedback">
                                        Por favor introduzca su direccion de envio.
                                    </div>
                                </div>
                                

                                <div class="col-md-5">
                                    <label for="country" class="form-label">Ciudad</label>
                                    <select class="form-select" id="country" required>
                                        <option value="">Seleccionar</option>
                                        <option>Bucaramanga</option>
                                    </select>
                                    <div class="invalid-feedback">
                                        Seleccione un departamento válido.
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <label type="text" class="form-label">Barrio</label>
                                    <input type="text" class="form-control" required> 
                                    <div class="invalid-feedback">
                                        Proporcione una ciudad válida.
                                    </div>
                                </div>
                                
                            </div>

                            <hr class="my-4">

                            <h4 class="mb-3">Informacion de Pago</h4>

                            <div class="my-3">
                                <div class="form-check">
                                    <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked required>
                                    <img src="assets/img/tc.png" alt="" height="30px"/>
                                    <label class="form-check-label" for="credit">Tarjeta de Credito</label>
                                </div>
                                <div class="form-check align-middle">
                                    <input id="debit" name="paymentMethod" type="radio" class="form-check-input align-middle" required>
                                    <img src="assets/img/BotonPSE.png" alt="" height="33px"/>
                                    <label class="form-check-label align-middle" for="debit">PSE</label>
                                </div>
                                <div class="form-check">
                                    <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" required>
                                    <img src="assets/img/efecty.png" alt="" height="25px"/>
                                    <label class="form-check-label" for="paypal">Efecty / Baloto</label>
                                </div>
                            </div>

                            <hr class="my-4">

                            <a class="w-100 btn btn-primary btn-lg" href="reservas.jsp" role="button">Reservar y Pagar</a>
                        </form>
                    </div>
                </div>
            </main>

            
            <div class="container" style="padding-top: 35px">
                <div class="fluid-container">
                    <footer class="d-flex flex-wrap align-items-center py-3 border-top">
                        <div class=" d-flex align-items-center justify-content-between">
                            <span class="text-muted">Copyright © VuelaFácil 2021. Todos los derechos reservados.</span>
                        </div>                   
                    </footer>
                </div>
            </div>
        
        </div>
        
        <script src="assets/js/bootstrap/form-validation.js" type="text/javascript"></script>
        <script src="assets/js/bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="assets/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
