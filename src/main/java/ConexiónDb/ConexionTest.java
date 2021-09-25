/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexiónDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author @yotis56
 */
public class ConexionTest extends ConexionDb {
  
  public boolean test (){
    Connection con = getConexion();
    String sqlQuery = "SELECT * FROM rutas";
    try {
      PreparedStatement statementGet = con.prepareStatement(sqlQuery);
      System.out.println(sqlQuery);
      ResultSet datos = statementGet.executeQuery();
      while(datos.next()){
        System.out.println("salida: " + datos.getString("salida") + ", llegada: " + datos.getString("destino"));
      }
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
