<%-- 
    Document   : vuelos
    Created on : oct 5, 2021, 1:47:17 a.m.
    Author     : Robert
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Vuelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href= "assets/img/favicon.ico"/> 
        <link href="assets/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/estilos.css" rel="stylesheet" type="text/css"/>
          
        <title>Resultados</title>
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
                                <a class="nav-link text-white" href="nosotros.html">Nosotros</a>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </nav>
        
        <div class="container-fluid" >
            <div class="text-center" style="padding-top: 15px; padding-bottom: 15px"> <h3>Seleccionar Vuelo de IDA</h3> </div>
            
            <%
              List<Vuelo> vuelosIda = (ArrayList<Vuelo>)request.getAttribute("listaVuelos");
              for (Vuelo vuelo:vuelosIda){%>
            <div class="container align-self-center align-items-center" >
                <div class="shadow p-3 mb-5 bg-body rounded ">
                    <div class="row justify-content-center">
                        <div class="col-auto  align-self-center ">
                            <img src="assets/img/aero.jpg" class="rounded-circle" alt="..." height="60px" />
                        </div>
                        <div class="col-9  align-self-center">
                            <div class="container align-self-center align-items-cente">
                                <div class="row row-cols-4 align-self-center">
                                    <div class="col  text-center align-self-center h6">FECHA</div>
                                    <div class="col  text-center align-self-center h6 "><%=vuelo.getRutaAsociada().getCiudadSalida()%></div>
                                    <div class="col-2  text-center align-self-center h6">DIRECTO</div>
                                    <div class="col  text-center align-self-center h6"><%=vuelo.getRutaAsociada().getCiudadDestino()%></div>

                                    <div class="col  text-center align-self-center h5"><%=vuelo.getFechaVuelo()%> </div>
                                    <div class="col  text-center align-self-center">
                                        <img src="assets/img/despe.png" alt="" height="25px"/>
                                        <%=vuelo.getRutaAsociada().getAeropuertoSalida()%>
                                    </div>                              
                                    <div class="col-2  text-center align-self-center">
                                        <img src="assets/img/rut.png" alt="" height="25px" />                               
                                    </div>
                                    <div class="col  text-center align-self-center">
                                        <img src="assets/img/ateri.png" alt=""height="25px"/>
                                        <%=vuelo.getRutaAsociada().getAeropuertoDestino()%>
                                    </div>

                                    <div class="col  text-center align-self-center">(<%=vuelo.getRutaAsociada().getIATASalida()%> - <%=vuelo.getRutaAsociada().getIATADestino()%>)</div>
                                    <div class="col  text-center align-self-center">Hora: <%=vuelo.getHoraVuelo()%></div>
                                    <div class="col-2  text-center align-self-center">(<%=vuelo.getRutaAsociada().getTiempoAprox().toString()%>)</div>
                                    <div class="col  text-center align-self-center"><%=vuelo.getHoraLlegada()%>AM</div>

                                </div>
                            </div>
                        </div>
                        <div class="col-auto  align-self-center">
                            <div class="col  text-center align-self-center h3">$85.000</div>
                            <button class="btn  btn-primary align-middle" type="button"> <img src="assets/img/iconocarrito.png" alt="" height="25px"/>  Reservar Ahora! </button> 
                            
                        </div>
                    </div>
                </div>     
            </div>
            
            
            <%}%>
            
            <% if((boolean)request.getAttribute("idaVuelta")){ %>
            <div class="text-center" style="padding-top: 15px; padding-bottom: 15px"> <h3>Seleccionar Vuelo de VUELTA</h3> </div>
            
            
            <%}%>

            <! –– vuelta 1 ––>
            <div class="container align-self-center align-items-center" >
                <div class="shadow p-3 mb-5 bg-body rounded ">
                    <div class="row justify-content-center">
                        <div class="col-auto  align-self-center ">
                            <img src="assets/img/aero.jpg" class="rounded-circle" alt="..." height="60px" />
                        </div>
                        <div class="col-9  align-self-center">
                            <div class="container align-self-center align-items-cente">
                                <div class="row row-cols-4 align-self-center">
                                    <div class="col  text-center align-self-center h6">FECHA</div>
                                    <div class="col  text-center align-self-center h6 ">BOGOTA </div>
                                    <div class="col-2  text-center align-self-center h6">DIRECTO</div>
                                    <div class="col  text-center align-self-center h6">BUCARAMANGA</div>

                                    <div class="col  text-center align-self-center h5">15 Julio </div>
                                    <div class="col  text-center align-self-center">
                                        <img src="assets/img/despe.png" alt="" height="25px"/>
                                        Dorado
                                    </div>                              
                                    <div class="col-2  text-center align-self-center">
                                        <img src="assets/img/rut.png" alt="" height="25px" />                               
                                    </div>
                                    <div class="col  text-center align-self-center">
                                        <img src="assets/img/ateri.png" alt=""height="25px"/>
                                        Palonegro 
                                    </div>

                                    <div class="col  text-center align-self-center">(BOG - BGA)</div>
                                    <div class="col  text-center align-self-center">8:00AM</div>
                                    <div class="col-2  text-center align-self-center">(1h 30mn)</div>
                                    <div class="col  text-center align-self-center">9:30AM</div>

                                </div>
                            </div>
                        </div>
                        <div class="col-auto  align-self-center">
                            <div class="col  text-center align-self-center h3">$85.000</div>
                            <button class="btn  btn-primary align-middle" type="button" > <img src="assets/img/iconocarrito.png" alt="" height="25px"/>  Reservar Ahora! </button> 
                        </div>
                    </div>
                </div>     
            </div>

            <! –– vuelta 2 ––>
            <div class="container align-self-center align-items-center" >
                <div class="shadow p-3 mb-5 bg-body rounded ">
                    <div class="row justify-content-center">
                        <div class="col-auto  align-self-center ">
                            <img src="assets/img/aero.jpg" class="rounded-circle" alt="..." height="60px" />
                        </div>
                        <div class="col-9  align-self-center">
                            <div class="container align-self-center align-items-cente">
                                <div class="row row-cols-4 align-self-center">
                                    <div class="col  text-center align-self-center h6">FECHA</div>
                                    <div class="col  text-center align-self-center h6 ">BOGOTA </div>
                                    <div class="col-2  text-center align-self-center h6">DIRECTO</div>
                                    <div class="col  text-center align-self-center h6">BUCARAMANGA</div>

                                    <div class="col  text-center align-self-center h5">15 Julio </div>
                                    <div class="col  text-center align-self-center">
                                        <img src="assets/img/despe.png" alt="" height="25px"/>
                                        Dorado
                                    </div>                              
                                    <div class="col-2  text-center align-self-center">
                                        <img src="assets/img/rut.png" alt="" height="25px" />                               
                                    </div>
                                    <div class="col  text-center align-self-center">
                                        <img src="assets/img/ateri.png" alt=""height="25px"/>
                                        Palonegro 
                                    </div>

                                    <div class="col  text-center align-self-center">(BOG - BGA)</div>
                                    <div class="col  text-center align-self-center">8:00AM</div>
                                    <div class="col-2  text-center align-self-center">(1h 30mn)</div>
                                    <div class="col  text-center align-self-center">9:30AM</div>

                                </div>
                            </div>
                        </div>
                        <div class="col-auto  align-self-center">
                            <div class="col  text-center align-self-center h3">$85.000</div>
                            <button class="btn  btn-primary align-middle" type="button" > <img src="assets/img/iconocarrito.png" alt="" height="25px"/>  Reservar Ahora! </button> 
                        </div>
                    </div>
                </div>     
            </div>

            <! –– vuelta 3 ––>
            <div class="container align-self-center align-items-center" >
                <div class="shadow p-3 mb-5 bg-body rounded ">
                    <div class="row justify-content-center">
                        <div class="col-auto  align-self-center ">
                            <img src="assets/img/aero.jpg" class="rounded-circle" alt="..." height="60px" />
                        </div>
                        <div class="col-9  align-self-center">
                            <div class="container align-self-center align-items-cente">
                                <div class="row row-cols-4 align-self-center">
                                    <div class="col  text-center align-self-center h6">FECHA</div>
                                    <div class="col  text-center align-self-center h6 ">BOGOTA </div>
                                    <div class="col-2  text-center align-self-center h6">DIRECTO</div>
                                    <div class="col  text-center align-self-center h6">BUCARAMANGA</div>

                                    <div class="col  text-center align-self-center h5">15 Julio </div>
                                    <div class="col  text-center align-self-center">
                                        <img src="assets/img/despe.png" alt="" height="25px"/>
                                        Dorado
                                    </div>                              
                                    <div class="col-2  text-center align-self-center">
                                        <img src="assets/img/rut.png" alt="" height="25px" />                               
                                    </div>
                                    <div class="col  text-center align-self-center">
                                        <img src="assets/img/ateri.png" alt=""height="25px"/>
                                        Palonegro 
                                    </div>

                                    <div class="col  text-center align-self-center">(BOG - BGA)</div>
                                    <div class="col  text-center align-self-center">8:00AM</div>
                                    <div class="col-2  text-center align-self-center">(1h 30mn)</div>
                                    <div class="col  text-center align-self-center">9:30AM</div>

                                </div>
                            </div>
                        </div>
                        <div class="col-auto  align-self-center">
                            <div class="col  text-center align-self-center h3">$85.000</div>
                            <button class="btn  btn-primary align-middle" type="button" > <img src="assets/img/iconocarrito.png" alt="" height="25px"/>  Reservar Ahora! </button> 
                        </div>
                    </div>
                </div>     
            </div>
            
            
            <a class="w-100 btn btn-primary boton" href="checkout.jsp" role="button">Buscar</a>
            
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
