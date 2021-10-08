/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DAO.Interfaces;

import dto.Reserva;
import java.util.ArrayList;

/**
 *
 * @author @yotis56
 */
public interface IReserva {
  public ArrayList<Reserva> listarReservas();
  public Reserva buscarReservaPorCódigo (int codigoReserva);
  public ArrayList<Reserva> buscarReservaPorCc (String documentoCliente);
  public boolean guardarReserva(Reserva reserva);
  public boolean modificarReserva (int codigoReserva, Reserva reserva);
  public boolean eliminarReserva(int codigoReserva);
}
