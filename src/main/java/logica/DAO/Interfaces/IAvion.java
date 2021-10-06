/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DAO.Interfaces;

import dto.Avion;
import java.util.ArrayList;

/**
 *
 * @author @yotis56
 */
public interface IAvion {
  public ArrayList<Avion> listAviones();
  public Avion findAvion (String matricula);
  public boolean checkAvion (String matricula);
  public boolean addAvion (Avion Avion);
  public boolean editAvion (String matricula, Avion avion);
  public boolean deleteAvion (String matricula);
}
