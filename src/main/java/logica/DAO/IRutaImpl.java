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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean editRuta(int codigoRuta, Ruta ruta) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean deleteRuta(int codigoRuta) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
