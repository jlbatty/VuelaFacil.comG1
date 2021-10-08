/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DAO;

import ConexiónDb.ConexionDb;
import dto.Avion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.DAO.Interfaces.IAvion;

/**
 *
 * @author @yotis56
 */
public class IAvionImpl implements IAvion {

  @Override
  public ArrayList<Avion> listAviones() {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM `avion`";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result =  statement.executeQuery();
      ArrayList<Avion> avionesEncontrados = new ArrayList<Avion>();
      result.next();
      do {        
        Avion avionEncontrado = new Avion();
        avionEncontrado.setMatrícula(result.getString("matricula"));
        avionEncontrado.setMarca(result.getString("marca"));
        avionEncontrado.setModelo(result.getString("modelo"));
        avionEncontrado.setCapacidadTotal(result.getInt("capacidadTotal"));
        avionEncontrado.setCapacidadEconomica(result.getInt("capacidadEconomica"));
        avionEncontrado.setCapacidadEjecutiva(result.getInt("capacidadEjecutiva"));
        avionesEncontrados.add(avionEncontrado);
      } while (result.next());
      return avionesEncontrados;
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
  public Avion findAvion(String matricula) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM `avion` WHERE `matricula` = '"+matricula+"'";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result =  statement.executeQuery();
      Avion avionEncontrado = new Avion();
      result.next();
      do {        
        avionEncontrado.setMatrícula(result.getString("matricula"));
        avionEncontrado.setMarca(result.getString("marca"));
        avionEncontrado.setModelo(result.getString("modelo"));
        avionEncontrado.setCapacidadTotal(result.getInt("capacidadTotal"));
        avionEncontrado.setCapacidadEconomica(result.getInt("capacidadEconomica"));
        avionEncontrado.setCapacidadEjecutiva(result.getInt("capacidadEjecutiva"));
      } while (result.next());
      return avionEncontrado;
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
  public boolean addAvion(Avion Avion) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "INSERT INTO `avion` (`matricula`, `marca`, `modelo`, `capacidadTotal`, `capacidadEjecutiva`, `capacidadEconomica`) (?,?,?,?,?,?)";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      statement.setString(1, Avion.getMatrícula());
      statement.setString(2, Avion.getMarca());
      statement.setString(3, Avion.getModelo());
      statement.setInt(4, Avion.getCapacidadTotal());
      statement.setInt(5, Avion.getCapacidadEjecutiva());
      statement.setInt(6, Avion.getCapacidadEconomica());
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
  public boolean editAvion(String matricula, Avion avion) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();  
    try {
      String sqlQuery = "UPDATE `avion` SET ? WHERE `avion`.`matricula` = ? ";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      String set = "";
      set += "`matricula` = '"+avion.getMatrícula()+"'";
      set += "`marca	` = '"+avion.getMarca()+"'";
      set += "`modelo` = '"+avion.getModelo()+"'";
      set += "`capacidadTotal` = '"+avion.getCapacidadTotal()+"'";
      set += "`capacidadEjecutiva` = '"+avion.getCapacidadEjecutiva()+"'";
      set += "`capacidadEconomica` = '"+avion.getCapacidadEconomica()+"'";
      statement.setString(1, set);
      statement.setString(2, matricula);
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
  public boolean deleteAvion(String matricula) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "DELETE FROM `avion` WHERE `matricula` = '"+matricula+"'";
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
  public boolean checkAvion(String matricula) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM `avion` WHERE `matricula` = '"+matricula+"'";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      return statement.execute() == true;
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
