/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DAO;

import ConexiónDb.ConexionDb;
import dto.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.DAO.Interfaces.IRuta;

/**
 *
 * @author @yotis56
 */
public class IRutaImpl implements IRuta {

  @Override
  public ArrayList<Ruta> listRutas() {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM `rutas`" ;
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result =  statement.executeQuery();
      ArrayList<Ruta> rutasEncontradas = new ArrayList<Ruta>();
      do {        
        Ruta rutaEncontrada = new Ruta();
        rutaEncontrada.setCodigoRuta(result.getInt("codigoRuta")); 
        rutaEncontrada.setSalida(result.getString("salida"));
        rutaEncontrada.setIATASalida(result.getString("IATAsalida"));
        rutaEncontrada.setDestino(result.getString("destino"));
        rutaEncontrada.setIATADestino(result.getString("IATAdestino"));
        rutaEncontrada.setTiempoAprox(result.getTime("tiempoAprox"));
        rutaEncontrada.setDistancia(result.getFloat("distancia"));
        rutasEncontradas.add(rutaEncontrada);
      } while (result.next());
      return rutasEncontradas;
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
  public Ruta findRuta(int codigoRuta) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM `rutas` WHERE `codigoRuta` = "+codigoRuta;
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result =  statement.executeQuery();
      Ruta rutaEncontrada = new Ruta();
      result.next();
      do {        
        rutaEncontrada.setCodigoRuta(codigoRuta); 
        rutaEncontrada.setSalida(result.getString("salida"));
        rutaEncontrada.setIATASalida(result.getString("IATAsalida"));
        rutaEncontrada.setDestino(result.getString("destino"));
        rutaEncontrada.setIATADestino(result.getString("IATAdestino"));
        rutaEncontrada.setTiempoAprox(result.getTime("tiempoAprox"));
        rutaEncontrada.setDistancia(result.getFloat("distancia"));
      } while (result.next());
      return rutaEncontrada;
      
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
  public boolean addRuta(Ruta ruta) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "INSERT INTO `rutas` (`codigoRuta`, `salida`, `IATAsalida`, `destino`, `IATAdestino`, `tiempoAprox`, `distancia`) VALUES (?,?,?,?,?,?,?)";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      statement.setInt(1, ruta.getCodigoRuta());
      statement.setString(2, ruta.getSalida());
      statement.setString(3, ruta.getIATASalida());
      statement.setString(4, ruta.getDestino());
      statement.setString(5, ruta.getIATASalida());
      statement.setTime(6, ruta.getTiempoAprox());
      statement.setFloat(7, ruta.getDistancia());
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
  public boolean editRuta(int codigoRuta, Ruta ruta) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "UPDATE `rutas` SET ? WHERE `rutas`.`codigoRuta` = " + codigoRuta;
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      String set = "";
      set += "`salida` = '"+ruta.getSalida()+"'";
      set += "`IATAsalida` = '"+ruta.getIATASalida()+"'";
      set += "`destino` = '"+ruta.getDestino()+"'";
      set += "`IATAdestino` = '"+ruta.getIATADestino()+"'";
      set += "`tiempoAprox` = '"+ruta.getTiempoAprox()+"'";
      set += "`distancia` = '"+ruta.getDistancia()+"'";
      statement.setString(1, set);
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
  public boolean deleteRuta(int codigoRuta) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "DELETE FROM `rutas` WHERE `codigoRuta` = "+codigoRuta;
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

  @Override
  public boolean checkRuta(int codigoRuta) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM `rutas` WHERE `codigoRuta` = "+codigoRuta;
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      return statement.execute();
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
