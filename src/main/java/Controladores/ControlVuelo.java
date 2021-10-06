/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import dto.Vuelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.DAO.IVueloImpl;

/**
 *
 * @author @yotis56
 */
@WebServlet(name = "ControlVuelo", urlPatterns = {"/vuelos"})
public class ControlVuelo extends HttpServlet {
  IVueloImpl vueloDAO = new IVueloImpl();
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    System.out.println("Servlet de vuelos iniciado");
    String action = request.getParameter("accion");
    
    try {
      switch(action){
        case "Buscar":
          buscar(request, response);
          break;
        //ACA LA IDEA ES AÑADIR LAS DISTINTAS ACCIONES DEL CONTROLADOR
        default:
          break;
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private void buscar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
    //Acá guardo los parametros que me llegan como parametros del request, en variables
    boolean ida = Boolean.parseBoolean(request.getParameter("ida"));
    boolean idaVuelta = Boolean.parseBoolean(request.getParameter("vuelta"));
    String origen = request.getParameter("origen");
    String destino = request.getParameter("destino");
    String fechaSalida = request.getParameter("fechaSalida");
    String fechaRegreso = request.getParameter("fechaRegreso");
    int adultos = Integer.parseInt(request.getParameter("adultos"));
    int infantes = Integer.parseInt(request.getParameter("infantes"));
    
    //System.out.println("ida: "+ida+ " - vuelta: "+idaVuelta+" - origen: "+origen+" - destino: " + destino+ " - fechaSalida: "+ fechaSalida+ " - fechaRegreso: " + fechaRegreso);
    //Luego tengo que llamar el método de la clase IVueloImpl, en este caso buscar vuelo
    ArrayList<Vuelo> listaVuelos = vueloDAO.buscarVuelos(fechaSalida, origen, destino);
    System.out.println(listaVuelos);
    request.setAttribute("listaVuelos", listaVuelos);
    if (idaVuelta){
      ArrayList<Vuelo> listaVuelosVuelta = vueloDAO.buscarVuelos(fechaRegreso, destino, origen);
      request.setAttribute("listaVuelosVuelta", listaVuelosVuelta);
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("vuelos.jsp");
    dispatcher.forward(request, response);
    
  }
  
  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
