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
public class AsientoReservado {
  int id;
  String idAsientoAsoc;
  int idVueloAsoc;

  public AsientoReservado() {
  }

  public AsientoReservado(int id, String idAsientoAsoc, int idVueloAsoc) {
    this.id = id;
    this.idAsientoAsoc = idAsientoAsoc;
    this.idVueloAsoc = idVueloAsoc;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getIdAsientoAsoc() {
    return idAsientoAsoc;
  }

  public void setIdAsientoAsoc(String idAsientoAsoc) {
    this.idAsientoAsoc = idAsientoAsoc;
  }

  public int getIdVueloAsoc() {
    return idVueloAsoc;
  }

  public void setIdVueloAsoc(int idVueloAsoc) {
    this.idVueloAsoc = idVueloAsoc;
  }
  
  
}
