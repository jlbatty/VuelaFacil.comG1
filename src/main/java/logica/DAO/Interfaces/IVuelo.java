/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DAO.Interfaces;

import dto.Vuelo;
import java.util.ArrayList;

/**
 *
 * @author @yotis56
 */
public interface IVuelo {
  public ArrayList<Vuelo> buscarVuelos(String fecha, String partida, String destino);
  public Vuelo buscarVueloPorId(int idVuelo);
  public boolean añadirVuelo(Vuelo vuelo);
  public boolean modificarVuelo(int idVuelo, Vuelo vuelo);
  public boolean eliminarVuelo(int idVuelo);
}
