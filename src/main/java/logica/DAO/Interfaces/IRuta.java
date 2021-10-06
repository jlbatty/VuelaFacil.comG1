/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DAO.Interfaces;

import dto.Ruta;
import java.util.ArrayList;

/**
 *
 * @author @yotis56
 */
public interface IRuta {
  public ArrayList<Ruta> listRutas();
  public Ruta findRuta(int codigoRuta);
  public boolean checkRuta (int codigoRuta);
  public boolean addRuta (Ruta ruta);
  public boolean editRuta (int codigoRuta, Ruta ruta);
  public boolean deleteRuta (int codigoRuta);
}
