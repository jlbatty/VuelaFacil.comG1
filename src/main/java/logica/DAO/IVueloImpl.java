/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DAO;

import ConexiónDb.ConexionDb;
import dto.Vuelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.DAO.Interfaces.IVuelo;

/**
 *
 * @author @yotis56
 */
public class IVueloImpl implements IVuelo {

    
  @Override
  public ArrayList<Vuelo> buscarVuelos(String fecha, String partida, String destino) {
    
    IAvionImpl iAvionImpl = new IAvionImpl();
    IRutaImpl iRutaImpl = new IRutaImpl();
    
      ConexionDb Conexion = new ConexionDb();
      Connection con = Conexion.getConexion();
      try {
        //la fecha se trae en el formato 'AAAA-MM-DD'
        //Para la salida y la partida, recibe el código IATA
        String sqlQuery = "SELECT * FROM `vuelo` WHERE cast(fechaVuelo as date) = cast('"+fecha+"' as date) " +
                          "AND codigoRutaAsoc = (SELECT codigoRuta from rutas where IATAsalida = '"+partida+"' and IATAdestino = '"+destino+"');";
        System.out.println(sqlQuery);
        PreparedStatement statement = con.prepareStatement(sqlQuery);
        ResultSet result = statement.executeQuery();    
        ArrayList<Vuelo> vuelosEncontrados = new ArrayList<Vuelo>();
        
        while(result.next()){
              Vuelo vueloEncontrado = new Vuelo();
              vueloEncontrado.setIdVuelo(result.getInt("idVuelo"));
              vueloEncontrado.setFechaVuelo(result.getDate("fechaVuelo"));
              vueloEncontrado.setHoraVuelo(result.getTimestamp("fechaVuelo"));
              vueloEncontrado.setAvionAsociado(iAvionImpl.findAvion(result.getString("matriculaAvion")));
              vueloEncontrado.setRutaAsociada(iRutaImpl.findRuta(result.getInt("codigoRutaAsoc")));
              vueloEncontrado.setEjecutivaDisponible(result.getInt("ejecutivaDisponible"));
              vueloEncontrado.setEconomicaDisponible(result.getInt("economicaDisponible"));
              vuelosEncontrados.add(vueloEncontrado);
          } 
            return vuelosEncontrados;
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
  public Vuelo buscarVueloPorId(int idVuelo) {
    
    IAvionImpl iAvionImpl = new IAvionImpl();
    IRutaImpl iRutaImpl = new IRutaImpl();
    
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM `vuelos` WHERE `idVuelo` = " + idVuelo;
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result = statement.executeQuery();   
      Vuelo vueloEncontrado = new Vuelo();
      result.next();
      do {        
       vueloEncontrado.setIdVuelo(result.getInt("idVuelo"));
       vueloEncontrado.setFechaVuelo(result.getDate("fechaVuelo"));
       vueloEncontrado.setAvionAsociado(iAvionImpl.findAvion(result.getString("matriculaAvion")));
       vueloEncontrado.setRutaAsociada(iRutaImpl.findRuta(result.getInt("codigoRutaAsoc")));
       vueloEncontrado.setEjecutivaDisponible(result.getInt("ejecutivaDisponible"));
       vueloEncontrado.setEconomicaDisponible(result.getInt("economicaDisponible"));
      } while (result.next());
       return vueloEncontrado;
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
  public boolean añadirVuelo(Vuelo vuelo, String matricula, int codigoRuta) {
    IAvionImpl iAvionImpl = new IAvionImpl();
    IRutaImpl iRutaImpl = new IRutaImpl();
    
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      if (iAvionImpl.checkAvion(matricula) && iRutaImpl.checkRuta(codigoRuta)){
        String sqlQuery = "INSERT INTO `vuelo` (`idVuelo`, `fechaVuelo`, `matriculaAvion`, `codigoRutaAsoc`, `ejecutivaDisponible`, `economicaDisponible`) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(sqlQuery);
        statement.setInt(1, vuelo.getIdVuelo());
        statement.setDate(2, vuelo.getFechaVuelo());
        statement.setString(3, matricula);
        statement.setInt(4, codigoRuta);
        statement.setInt(5, vuelo.getEjecutivaDisponible());
        statement.setInt(6, vuelo.getEconomicaDisponible());
        statement.execute();
        return true;
      } else {
        return false;
      }
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

  
  //hacer que al guardar una reserva, disminuyan los puestos del vuelo
  @Override
  public boolean modificarVuelo(int idVuelo, Vuelo vuelo) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "UPDATE `vuelo` SET ? WHERE `vuelo`.`idVuelo` = ? ";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      String set = "";
      set += "`fechaVuelo` = '"+vuelo.getFechaVuelo()+"'";
      set += "`matriculaAvion	` = '"+vuelo.getAvionAsociado().getMatrícula()+"'";
      set += "`codigoRutaAsoc` = '"+vuelo.getRutaAsociada().getCodigoRuta()+"'";
      set += "`ejecutivaDisponible` = '"+vuelo.getEjecutivaDisponible()+"'";
      set += "`economicaDisponible` = '"+vuelo.getEconomicaDisponible()+"'";
      statement.setString(1, set);
      statement.setInt(2, idVuelo);
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
  
  public Integer getAsientosDisponibles (int idVuelo, int tipo){
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    String sqlQuery;
    try {
      switch (tipo) {
        case 0:
          sqlQuery = "SELECT `ejecutivaDisponible` FROM `vuelos` WHERE `idVuelo` = " + idVuelo;
          break;
        case 1:
          sqlQuery = "SELECT `economicaDisponible` FROM `vuelos` WHERE `idVuelo` = " + idVuelo;
          break;
        default:
          System.out.println("Por favor ingrese un tipo de aseiento válido");
          return null;
      }
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result = statement.executeQuery();
      result.next();
      if (tipo == 0){
        return result.getInt("ejecutivaDisponible");
      } else {
        return result.getInt("economicaDisponible");
      }
      
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
  
  public boolean apartarAsiento (int idVuelo, int numeroPuestos, int tipo){
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "UPDATE `vuelo` SET ? WHERE `vuelo`.`idVuelo` = ? ";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      String set = "";
      int asientosDisponiblesActualizado = this.getAsientosDisponibles(idVuelo, tipo) - numeroPuestos;
      switch (tipo) {
        case 0:
          set += "`ejecutivaDisponible` = '"+asientosDisponiblesActualizado+"'";
          break;
        case 1:
          set += "`economicaDisponible` = '"+asientosDisponiblesActualizado+"'";
          break;
        default:
          System.out.println("Por favor ingrese un tipo de aseiento válido");
          return false;
      }
      statement.setString(1, set);
      statement.setInt(2, idVuelo);
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
  public boolean eliminarVuelo(int idVuelo) {
ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "DELETE FROM `vuelo` WHERE `idVuelo` = '"+idVuelo+"'";
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
    }  }
  
}
