/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DAO;

import ConexiónDb.ConexionDb;
import dto.Cliente;
import dto.Reserva;
import dto.Vuelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.DAO.Interfaces.IReserva;

/**
 *
 * @author @yotis56
 */
public class IReservaImpl implements IReserva{
  
  @Override
  public ArrayList<Reserva> listarReservas() {
    IVueloImpl iVuelo = new IVueloImpl();
    IClienteImpl iCliente = new IClienteImpl();
    
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM `reserva`";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result =  statement.executeQuery();
      ArrayList<Reserva> reservasEncontradas = new ArrayList<Reserva>();
      result.next();
      do {        
        Reserva reservaEncontrada = new Reserva();
        reservaEncontrada.setCodigoReserva(result.getInt("codigoReserva"));
        reservaEncontrada.setSolo_ida(result.getInt("solo_Ida"));
        reservaEncontrada.setCantidadPasajeros(result.getInt("cantidadPasajeros"));
        reservaEncontrada.setAdultos(result.getInt("adultos"));
        reservaEncontrada.setInfantes(result.getInt("infantes"));
        Cliente clienteAsociado = iCliente.buscarCliente(result.getString("documentoCliente"));
        reservaEncontrada.setCliente(clienteAsociado);
        reservaEncontrada.setTarifa(result.getInt("tarifa"));
        Vuelo vueloAsociado = iVuelo.buscarVueloPorId(result.getInt("codigoVueloAsoc"));
        reservaEncontrada.setVueloAsociado(vueloAsociado);
        reservasEncontradas.add(reservaEncontrada);
      } while (result.next());
      return reservasEncontradas;
    } catch (Exception e) { 
      System.out.println(e);
      return null;
    } finally {
            try {
                 con.close();
             } catch (SQLException e) {
                 System.err.println(e);
             }
         }
  }

  @Override
  public Reserva buscarReservaPorCódigo(int codigoReserva) {
    IVueloImpl iVuelo = new IVueloImpl();
    IClienteImpl iCliente = new IClienteImpl();
    
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM `reserva` WHERE `codigoReserva` = " +codigoReserva;
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result =  statement.executeQuery();
      result.next();
      Reserva reservaEncontrada = new Reserva();
      do {        
        reservaEncontrada.setCodigoReserva(result.getInt("codigoReserva"));
        reservaEncontrada.setSolo_ida(result.getInt("solo_Ida"));
        reservaEncontrada.setCantidadPasajeros(result.getInt("cantidadPasajeros"));
        reservaEncontrada.setAdultos(result.getInt("adultos"));
        reservaEncontrada.setInfantes(result.getInt("infantes"));
        Cliente clienteAsociado = iCliente.buscarCliente(result.getString("documentoCliente"));
        reservaEncontrada.setCliente(clienteAsociado);
        reservaEncontrada.setTarifa(result.getInt("tarifa"));
        Vuelo vueloAsociado = iVuelo.buscarVueloPorId(result.getInt("codigoVueloAsoc"));
        reservaEncontrada.setVueloAsociado(vueloAsociado);
      } while (result.next());
      return reservaEncontrada;
    } catch (Exception e) { 
      System.out.println(e);
      return null;
    } finally {
            try {
                 con.close();
             } catch (SQLException e) {
                 System.err.println(e);
             }
         }
  }

  @Override
  public ArrayList<Reserva> buscarReservaPorCc(String documentoCliente) {
    IVueloImpl iVuelo = new IVueloImpl();
    IClienteImpl iCliente = new IClienteImpl();
    
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM `reserva` WHERE `documentoCliente` = " +documentoCliente;
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result =  statement.executeQuery();
      ArrayList<Reserva> reservasEncontradas = new ArrayList<Reserva>();
      result.next();
      do {        
        Reserva reservaEncontrada = new Reserva();
        reservaEncontrada.setCodigoReserva(result.getInt("codigoReserva"));
        reservaEncontrada.setSolo_ida(result.getInt("solo_Ida"));
        reservaEncontrada.setCantidadPasajeros(result.getInt("cantidadPasajeros"));
        reservaEncontrada.setAdultos(result.getInt("adultos"));
        reservaEncontrada.setInfantes(result.getInt("infantes"));
        Cliente clienteAsociado = iCliente.buscarCliente(result.getString("documentoCliente"));
        reservaEncontrada.setCliente(clienteAsociado);
        reservaEncontrada.setTarifa(result.getInt("tarifa"));
        Vuelo vueloAsociado = iVuelo.buscarVueloPorId(result.getInt("codigoVueloAsoc"));
        reservaEncontrada.setVueloAsociado(vueloAsociado);
        reservasEncontradas.add(reservaEncontrada);
      } while (result.next());
      return reservasEncontradas;
    } catch (Exception e) { 
      System.out.println(e);
      return null;
    } finally {
            try {
                 con.close();
             } catch (SQLException e) {
                 System.err.println(e);
             }
         }  
  }

  @Override
  public boolean guardarReserva(Reserva reserva) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "INSERT INTO `reserva` ( `solo_Ida`, `cantidadPasajeros`, `adultos`, `infantes`, `documentoCliente`, `tarifa`, `codigoVueloAsoc`) VALUES (?,?,?,?,?,?,?)";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      statement.setInt(1, reserva.getSolo_ida());
      statement.setInt(2, reserva.getCantidadPasajeros());
      statement.setInt(3, reserva.getAdultos());
      statement.setInt(4, reserva.getInfantes());
      statement.setString(5, reserva.getCliente().getNumerodocumento());
      statement.setInt(6, reserva.getTarifa());
      statement.setInt(7, reserva.getVueloAsociado().getIdVuelo());
      statement.execute();
      return true;
    } catch (Exception e) { 
      System.out.println(e);
      return false;
    } finally {
            try {
                 con.close();
             } catch (SQLException e) {
                 System.err.println(e);
             }
    }  
  }

  @Override
  public boolean modificarReserva(int codigoReserva, Reserva reserva) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    
    try {
      String sqlQuery = "UPDATE `reserva` SET ? WHERE `reserva`.`codigoReserva` = ? ";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      String set = "";
      set += "`solo_Ida` = '"+reserva.getSolo_ida()+"'";
      set += "`cantidadPasajeros	` = '"+reserva.getCantidadPasajeros()+"'";
      set += "`adultos` = '"+reserva.getAdultos()+"'";
      set += "`infantes` = '"+reserva.getInfantes()+"'";
      set += "`documentoCliente` = '"+reserva.getCliente().getNumerodocumento()+"'";
      set += "`tarifa` = '"+reserva.getTarifa()+"'";
      set += "`codigoVueloAsoc` = '"+reserva.getVueloAsociado().getIdVuelo()+"'";
      statement.setString(1, set);
      statement.setInt(2, codigoReserva);
      statement.executeUpdate();
      return true;
    } catch (Exception e) { 
      System.out.println(e);
      return false;
    } finally {
            try {
                 con.close();
             } catch (SQLException e) {
                 System.err.println(e);
             }
    }  
  }

  @Override
  public boolean eliminarReserva(int codigoReserva) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "DELETE FROM `reserva` WHERE `codigoReserva` = '"+codigoReserva+"'";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      statement.execute();
      return true;
    } catch (Exception e) { 
      System.out.println(e);
      return false;
    } finally {
            try {
                 con.close();
             } catch (SQLException e) {
                 System.err.println(e);
             }
    }  
  }
  
}
