/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author @yotis56
 */
public class Asiento {
  String idAsiento;
  String categoría;

  public Asiento() {
  }

  public Asiento(String idAsiento, String categoría) {
    this.idAsiento = idAsiento;
    this.categoría = categoría;
  }

  public String getIdAsiento() {
    return idAsiento;
  }

  public void setIdAsiento(String idAsiento) {
    this.idAsiento = idAsiento;
  }

  public String getCategoría() {
    return categoría;
  }

  public void setCategoría(String categoría) {
    this.categoría = categoría;
  }
  
  
}
