/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DAO.Interfaces;

import dto.Cliente;
import java.util.ArrayList;

/**
 *
 * @author @yotis56
 */
public interface ICliente {
  public Cliente buscarCliente (String documento);
  public ArrayList<Cliente> listarClientes (); 
  public boolean addCliente (Cliente cliente);
  public boolean updateCliente(String documento, Cliente cliente);
  public boolean deleteCliente (String documento);
}
