/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexiónDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author @yotis56
 */
public class ConexionDb {
  private final String database = "vuelafacil";
  private final String user = "root";
  private final String password = "";
  private final String databaseUrl = "jdbc:mysql://localhost:3306/" +database;
  private Connection conexion =  null;
  
  public Connection getConexion()
    {
        try{
            System.out.println("Conectando a la db MySQL ");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(this.databaseUrl, this.user, this.password);
        } 
        catch(SQLException sql_error)
        {
            System.err.println("Error sql "+sql_error.getMessage());
        } catch (ClassNotFoundException ex) {
           System.err.println("Error clase no encontrada excepción\n"+ex.getMessage());
        }
        return conexion;
    }
}
