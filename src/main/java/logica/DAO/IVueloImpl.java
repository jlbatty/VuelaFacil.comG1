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
        PreparedStatement statement = con.prepareStatement(sqlQuery);
        ResultSet result = statement.executeQuery();    
        ArrayList<Vuelo> vuelosEncontrados = new ArrayList<Vuelo>();
          do {
              Vuelo vueloEncontrado = new Vuelo();
              vueloEncontrado.setIdVuelo(result.getInt("idVuelo"));
              vueloEncontrado.setFechaVuelo(result.getDate("fechaVuelo"));
              vueloEncontrado.setAvionAsociado(iAvionImpl.findAvion(result.getString("matriculaAvion")));
              vueloEncontrado.setRutaAsociada(iRutaImpl.findRuta(result.getInt("codigoRutaAsoc")));
              vueloEncontrado.setEjecutivaDisponible(result.getInt("ejecutivaDisponible"));
              vueloEncontrado.setEconomicaDisponible(result.getInt("economicaDisponible"));
              vuelosEncontrados.add(vueloEncontrado);
          } while (result.next());
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
  public boolean añadirVuelo(Vuelo vuelo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean modificarVuelo(int idVuelo, Vuelo vuelo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean eliminarVuelo(int idVuelo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}