/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DAO;

import ConexiónDb.ConexionDb;
import dto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.DAO.Interfaces.ICliente;

/**
 *
 * @author @yotis56
 */
public class IClienteImpl implements ICliente{

  @Override
  public Cliente buscarCliente(String documento) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM cliente WHERE numerodocumento = '"+documento+"'";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result = statement.executeQuery();
      Cliente clienteObtenido = new Cliente();
      result.next();
      do {        
        clienteObtenido.setNumerodocumento(documento);
        clienteObtenido.setTipoDocumento(result.getString("tipoDocumento"));
        clienteObtenido.setNombres(result.getString("nombres"));
        clienteObtenido.setApellidos(result.getString("apellidos"));
        clienteObtenido.setTelefono(result.getString("telefono"));
        clienteObtenido.setCorreoElectronico(result.getString("correoElectronico"));
      } while (result.next());
      return clienteObtenido;
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
  public ArrayList<Cliente> listarClientes() {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "SELECT * FROM cliente";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      ResultSet result = statement.executeQuery();
      ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
      result.next();
      do {        
        Cliente clienteObtenido = new Cliente();
        clienteObtenido.setNumerodocumento(result.getString("numerodocumento"));
        clienteObtenido.setTipoDocumento(result.getString("tipoDocumento"));
        clienteObtenido.setNombres(result.getString("nombres"));
        clienteObtenido.setApellidos(result.getString("apellidos"));
        clienteObtenido.setTelefono(result.getString("telefono"));
        clienteObtenido.setCorreoElectronico(result.getString("correoElectronico"));
        listaClientes.add(clienteObtenido);
      } while (result.next());
      return listaClientes;
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
  public boolean addCliente(Cliente cliente) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "INSERT INTO `cliente` (`numerodocumento`, `tipoDocumento`, `nombres`, `apellidos`, `telefono`, `correoElectronico`) VALUES (?,?,?,?,?,?)";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      statement.setString(1, cliente.getNumerodocumento());
      statement.setString(2, cliente.getTipoDocumento());
      statement.setString(3, cliente.getNombres());
      statement.setString(4, cliente.getApellidos());
      statement.setString(5, cliente.getTelefono());
      statement.setString(6, cliente.getCorreoElectronico());
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
  public boolean updateCliente(String documento, Cliente cliente) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "UPDATE cliente SET ? WHERE `cliente`.`numerodocumento` = '"+documento+"'";
      PreparedStatement statement = con.prepareStatement(sqlQuery);
      String set = "";
      set += "`tipoDocumento` = '"+cliente.getTipoDocumento()+"'";
      set += "`nombres` = '"+cliente.getNombres()+"'";
      set += "`apellidos` = '"+cliente.getApellidos()+"'";
      set += "`telefono` = '"+cliente.getTelefono()+"'";
      set += "`correoElectronico` = '"+cliente.getCorreoElectronico()+"'";
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
  public boolean deleteCliente(String documento) {
    ConexionDb Conexion = new ConexionDb();
    Connection con = Conexion.getConexion();
    try {
      String sqlQuery = "DELETE FROM `cliente` WHERE `numerodocumento` = '"+documento+"'";
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
