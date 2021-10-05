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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean editAvion(String matricula, Avion avion) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean deleteAvion(String matricula) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
