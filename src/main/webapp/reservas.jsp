<%-- 
    Document   : reservas
    Created on : oct 5, 2021, 4:52:47 a.m.
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
        <title>Reservas</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/checkout/">
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
        
        <div class="container text-center">
            <div class="text-center" style="padding-top: 15px; padding-bottom: 5px"> <h3>Reservas</h3> </div>
            
            <div class="container-sm"style="width: 350px">
                <div class="input-group mb-3 ">
                    <input type="text" class="form-control" placeholder="ID Reserva" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">Buscar</button>
                </div>              
            </div>
            
            <img src="assets/gifs/Flight Booking.gif" alt=""/>
            
            <div class="d-grid gap-2 col-3 mx-auto" style="padding-top: 10px; padding-bottom: 35px"> 
                <input class="btn btn-primary" type="submit" class="BotonDown" value="Descargar" onclick="document.location.href='assets/pdf/Ticket.pdf'" target="_blank">
            </div>
        </div>
        
        <! –– footer ––>
        <div class="container">
            <div class="fluid-container">
                <footer class="d-flex flex-wrap align-items-center py-3 border-top">
                    <div class=" d-flex align-items-center justify-content-between">
                        <span class="text-muted">Copyright © VuelaFácil 2021. Todos los derechos reservados.</span>
                    </div>                   
                </footer>
            </div>
        </div>
        
        <script src="assets/js/bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script> 
    </body>
</html>
