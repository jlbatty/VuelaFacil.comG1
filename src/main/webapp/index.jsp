<%-- 
    Document   : index
    Created on : 4/10/2021, 10:45:59 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>vuelaFacil</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>       
        <link rel="shortcut icon" href= "assets/img/favicon.ico"/> 
        <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="assets/css/estilos.css" type="text/css"/>      
    </head>
    <body class="body-fondo">
        <%

        if (request.getParameter("botonIngreso") != null) 
        {
        
        String username = request.getParameter("usuario");
        String password = request.getParameter("contrasena");

        if(username.length() !=0 && password.length()!=0){
        
            
            if (username.equals("admin")&&password.equals("admin"))
            {

            response.sendRedirect("admin/index.jsp");
            }

            else
            {

            out.println("<script>alert('Usuario o contraseña incorrecta');</script>");
            }
        }
        }
        
        %>
        <script type="text/javascript" ></script>
        <script>
            function stateListener() {

                var ida = document.getElementById("idaVuelta");
                var fecharegreso = document.getElementById("fechaRegreso");
                fecharegreso.disabled = ida.checked ? false : true;
                fecharegreso.value = "";


            }
        </script>
        <div class="d-flex">
            <div class="vh-100 py-3 px-3 fs-6 text-light contenedor-buscador">          
                <div class="d-flex">
                    <div class="w-15 me-4">
                        <img src="assets/img/logo-blanco.png" class="w-100" alt="logo vuelaFacil">
                    </div>
                    <div class="d-flex fw-bold fst-italic align-items-center">
                        <p>Volar nunca había sido tan fácil</p>
                    </div>
                </div>
                <form action="vuelos" method="POST">
                    <div class="d-flex justify-content-center mt-5 mb-4">
                        <div class="d-inline-flex w-70 radio">
                            <input class="radio-input" type="radio" value="true" name="ida" id="ida" onclick="stateListener()"> 
                            <label for="ida" class="radio-label">Ida</label>
                            <input class="radio-input" type="radio" value="false" name="ida" id="idaVuelta" checked onclick="stateListener()">  
                            <label for="idaVuelta" class="radio-label">Ida y vuelta</label>
                        </div>              
                    </div>
                    <div class="d-flex mb-4">
                        <div class="w-50">
                            <label class="d-block" for="origen">Origen</label>
                            <select class="w-90 form-select" id="origen" name="origen">
                                <option disabled selected >seleccione origen</option>
                                <option value="BOG" >Bogotá</option>
                                <option value="BGA" >Bucaramanga</option>
                                <option value="BAQ" >Barranquilla</option>
                                <option value="CTG" >Cartagena</option>
                                <option value="CLO" >Cali</option>
                                <option value="MDE" >Medellín</option>
                            </select>
                        </div>
                        <div class="w-50">
                            <label class="d-block" for="destino">Destino</label>
                            <select class="w-90 form-select" id="destino" name="destino">
                                <option disabled selected >seleccione origen</option>
                                <option value="BOG" >Bogotá</option>
                                <option value="BGA" >Bucaramanga</option>
                                <option value="BAQ" >Barranquilla</option>
                                <option value="CTG" >Cartagena</option>
                                <option value="CLO" >Cali</option>
                                <option value="MDE" >Medellín</option>
                            </select>
                        </div>
                    </div>
                    <div class="d-flex mb-4">
                        <div class="w-50">
                            <label class="d-block " for="fechaSalida">Fecha de salida</label>
                            <input type="date" id="fechaSalida" name="fechaSalida" class="w-90 form-control">
                        </div>
                        <div class="w-50">
                            <label class="d-block" for="fechaRegreso">Fecha de regreso</label>
                            <input type="date" id="fechaRegreso" name="fechaRegreso" value=" " class="w-90 form-control">
                        </div>
                    </div>
                    <div class="mb-2">
                        <label>Cantidad de pasajeros</label>
                    </div>

                    <div class="d-flex mb-5">            
                        <div class="w-40">
                            <label for="adultos" class="d-block">Adultos: </label>
                            <input id="adultos" name="adultos" type="number" class="w-90 form-control" min="0" placeholder="0">
                        </div>
                        <div class="w-40">
                            <label for="infantes" class="d-block">Niños: </label>
                            <input id="infantes" name="infantes" type="number" class="w-90 form-control" min="0" placeholder="0">
                        </div>
                    </div>
                    <div class="d-flex justify-content-center">            
                        <div class="w-40">
                            <input type="submit" name="accion" class="w-100 btn btn-primary boton" value="Buscar" ></input>
                        </div>
                    </div>
                </form>





            </div>
            <div class="vh-100 py-3 px-3 contenedor-derecho">
                <header class="mb-3">
                    <div class="d-flex justify-content-end">     
                        <div class="dropdown">
                            <a href="#" class="fw-bold text-decoration-none text-dark dropdown-toggle" id="dropdownLogin" 
                               data-bs-toggle="dropdown" aria-expanded="false">
                                <span class="me-1">
                                    <img class="icono" src="assets/img/user.png" alt="icon-user"/>
                                </span>                
                                LogIn
                            </a>                
                            <div class="dropdown-menu p-2" aria-labelledby="dropdownLogin">

                                <label class="w-100 text-center">LogIn</label>
                                <form action="index.jsp" method="POST">
                                    <div class="w-100 px-2 mt-2 mb-2">
                                        <label for="usuario" class="d-block" >Usuario </label>
                                        <input name="usuario" id="usuario" type="text" class="form-control">
                                    </div>
                                    <div class="w-100 px-2 mb-2">
                                        <label for="pass" class="d-block">Contraseña </label>
                                        <input name="contrasena" id="pass" type="password" class="form-control">
                                    </div>
                                    <div class="w-100 px-2 mt-2 mb-2">
                                        <input type="submit" value="Iniciar sesión" name="botonIngreso" class="w-100 btn btn-primary boton">
                                    </div>
                                </form>
                            </div>
                        </div>  
                    </div>

                </header>
                <nav class="nav navbar-light justify-content-end bg-claro">
                    <a href="index.jsp" class="fw-medium nav-link active">
                        Inicio
                    </a>
                    <a href="reservas.jsp" class="nav-link fw-medium">
                        Reservas
                    </a>
                    <a href="nosotros.html" class="nav-link fw-medium">
                        Nosotros
                    </a>            
                </nav>

                <main style="height:82%;">

                </main>

                <footer class="nav navbar-light d-flex justify-content-between bg-claro">
                    <div>
                        <p class="m-0 py-2 px-3 fw-medium">Copyright © 2021 VuelaFacil. Todos los derechos reservados</p>
                    </div>

                    <div class="d-flex">
                        <div class="me-2">
                            <img src="assets/img/facebook.png" alt="facebook" class="mt-2"/>
                        </div>
                        <div class="me-2">
                            <img src="assets/img/instagram.png" alt="instagram" class="mt-2"/>
                        </div>
                        <div class="me-3">
                            <img src="assets/img/twitter.png" alt="twitter" class="mt-2"/>
                        </div>
                    </div>
                </footer>
            </div>
        </div> 
        <script src="assets/js/bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
