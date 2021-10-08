<%-- 
    Document   : reservas
    Created on : sep 29, 2021, 2:20:02 a.m.
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lad>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">  
        <title>Reservas</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sidebars/">

        <!-- Bootstrap core CSS -->
        <link href="../assets/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/css/bootstrap/sidebars.css" rel="stylesheet" type="text/css"/>
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


        <!-- Custom styles for this template -->
        <link href="sidebars.css" rel="stylesheet">
    </head>
    <body>

        <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="bootstrap" viewBox="0 0 118 94">
        <title>Bootstrap</title>
        <path fill-rule="evenodd" clip-rule="evenodd" d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z"></path>
    </symbol>
    </svg>

    <main>
        <h1 class="visually-hidden">Sidebars examples</h1>
        <div class="d-flex flex-column flex-shrink-0 p-3 text-white" style="width: 250px; background: linear-gradient(180deg, rgba(0,164,215,1) 0%, rgba(9,91,165,1) 100%);">
            <a href="../index.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"> 
                <img src="../assets/img/logo-blanco.png" width="120"/>
                <span class="fs-4">Admin</span>
            </a>
            <hr>
            <ul class="nav nav-pills flex-column mb-auto">
                <li class="nav-item">
                    <a href="../admin" class="nav-link text-white" >
                        <i class="fab fa-font-awesome-flag"></i>
                        Dashboard
                    </a>
                </li>
                <li>
                    <a href="../admin/aviones.jsp" class="nav-link text-white">
                        <i class="fas fa-plane"></i>
                        Aviones
                    </a>
                </li>
                <li>
                    <a href="../admin/destinos.jsp" class="nav-link text-white">
                        <i class="fas fa-map"></i>
                        Destinos
                    </a>
                </li>
                <li>
                    <a href="../admin/vuelos.jsp" class="nav-link text-white">
                        <i class="fas fa-route"></i>
                        Vuelos
                    </a>
                </li>
                <li>
                    <a href="#" class="nav-link active" aria-current="page">
                        <i class="far fa-calendar-check"></i>
                        Reservas
                    </a>
                </li>
            </ul>
            <hr>
            <div class="dropdown">
                <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="../assets/img/descarga.png" alt="" width="32" height="32" class="rounded-circle me-2">
                    <strong>Administrador</strong>
                </a>
                <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">

                    <li><a class="dropdown-item" href="../index.jsp">Cerrar Sesión</a></li>
                </ul>
            </div>
        </div>


        <div class="w-100 p-3" style="background-color: #ffffff;">   
            <div class="min-vh-100">
                <h2>Reservas</h2>
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">

                    <!-- Botón en HTML (lanza el modal en Bootstrap) -->
                    <a href="#victorModal" role="button" class="btn btn-large btn-primary" data-toggle="modal">Agregar Reserva</a>
                    
                    <!-- Modal / Ventana / Overlay en HTML -->
                    <div id="victorModal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">            
                                    <h4 class="modal-title">Nuevo Vuelo <span class="float-left"></span> </h4>
                                    <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>

                                </div>

                                <div style="margin:35px;">
                                    Reserva en nuestra pagina web                                   
                                </div>
                                    
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-success">Agregar Reserva</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    

                    <div class="btn-toolbar col-sm-3">
                        
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" placeholder="ID Reserva" aria-label="Recipient's username" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="button">Buscar</button>
                            </div>
                        </div>
   
                    </div>
                </div>


                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                            <tr>
                                <th scope="col">ID Reserva</th>
                                <th scope="col">Nombre Cliente</th>
                                <th scope="col">Numero de documento</th>
                                <th scope="col">ID Vuelo</th>
                                <th scope="col">Fecha de Vuelo</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1,001</td>
                                <td>random</td>
                                <td>data</td>
                                <td>placeholder</td>
                                <td>text</td>
                            </tr>
                            <tr>
                                <td>1,002</td>
                                <td>placeholder</td>
                                <td>irrelevant</td>
                                <td>visual</td>
                                <td>layout</td>
                            </tr>
                            <tr>
                                <td>1,003</td>
                                <td>data</td>
                                <td>rich</td>
                                <td>dashboard</td>
                                <td>tabular</td>
                            </tr>
                            <tr>
                                <td>1,003</td>
                                <td>information</td>
                                <td>placeholder</td>
                                <td>illustrative</td>
                                <td>data</td>
                            </tr>
                            <tr>
                                <td>1,004</td>
                                <td>text</td>
                                <td>random</td>
                                <td>layout</td>
                                <td>dashboard</td>
                            </tr>
                            <tr>
                                <td>1,005</td>
                                <td>dashboard</td>
                                <td>irrelevant</td>
                                <td>text</td>
                                <td>placeholder</td>
                            </tr>
                            <tr>
                                <td>1,006</td>
                                <td>dashboard</td>
                                <td>illustrative</td>
                                <td>rich</td>
                                <td>data</td>
                            </tr>
                            <tr>
                                <td>1,007</td>
                                <td>placeholder</td>
                                <td>tabular</td>
                                <td>information</td>
                                <td>irrelevant</td>
                            </tr>
                            <tr>
                                <td>1,008</td>
                                <td>random</td>
                                <td>data</td>
                                <td>placeholder</td>
                                <td>text</td>
                            </tr>
                            <tr>
                                <td>1,009</td>
                                <td>placeholder</td>
                                <td>irrelevant</td>
                                <td>visual</td>
                                <td>layout</td>
                            </tr>
                            <tr>
                                <td>1,010</td>
                                <td>data</td>
                                <td>rich</td>
                                <td>dashboard</td>
                                <td>tabular</td>
                            </tr>
                            <tr>
                                <td>1,011</td>
                                <td>information</td>
                                <td>placeholder</td>
                                <td>illustrative</td>
                                <td>data</td>
                            </tr>
                            <tr>
                                <td>1,012</td>
                                <td>text</td>
                                <td>placeholder</td>
                                <td>layout</td>
                                <td>dashboard</td>
                            </tr>
                            <tr>
                                <td>1,013</td>
                                <td>dashboard</td>
                                <td>irrelevant</td>
                                <td>text</td>
                                <td>visual</td>
                            </tr>
                            <tr>
                                <td>1,014</td>
                                <td>dashboard</td>
                                <td>illustrative</td>
                                <td>rich</td>
                                <td>data</td>
                            </tr>
                            <tr>
                                <td>1,015</td>
                                <td>random</td>
                                <td>tabular</td>
                                <td>information</td>
                                <td>text</td>
                            </tr>
                        </tbody>
                    </table>
                </div>




            </div>    
        </div>
    </body>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/be52fa382d.js" crossorigin="anonymous"></script>
    <script src="../assets/js/bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="../assets/js/bootstrap/sidebars.js" type="text/javascript"></script>
</html>

